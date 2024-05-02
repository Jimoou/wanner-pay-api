package wanner.pay.api.wannerpayments.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import wanner.pay.api.wannerpayments.model.request.PayRequest;
import wanner.pay.api.wannerpayments.model.request.RefundRequest;
import wanner.pay.api.wannerpayments.model.response.PayResponse;
import wanner.pay.api.wannerpayments.model.response.RefundResponse;
import wanner.pay.api.wannerpayments.model.response.Result;
import wanner.pay.api.wannerpayments.persist.document.PaymentLog;
import wanner.pay.api.wannerpayments.persist.repository.PaymentLogRepository;
import wanner.pay.api.wannerpayments.util.TrackIdGenerator;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

  private final WebClient webClient;
  private final PaymentLogRepository paymentLogRepository;

  /**
   * 결제 요청을 수행합니다.
   *
   * @param payRequest 필요한 모든 정보를 담고 있는 결제 요청 객체
   * @return API 응답을 포함하는 Mono<ResponseEntity<?>> 객체
   */
  @Override
  public Mono<ResponseEntity<?>> paymentPay(PayRequest payRequest) {
    payRequest.getPay().setTrackId(TrackIdGenerator.generateTrackId());
    log.info("[결제 요청 발생]\n>주문번호 : {}", payRequest.getPay().getTrackId());
    return webClient
        .post()
        .uri("/pay")
        .bodyValue(payRequest)
        .retrieve()
        .bodyToMono(PayResponse.class)
        .publishOn(Schedulers.boundedElastic())
        .map(
            response -> {
              if (response.getResult().getResultCd().equals("0000")) {
                log.info(
                    "[결제 요청 성공 - {}]\n>주문번호 : {}\n>거래번호 : {}",
                    response.getResult().getAdvanceMsg(),
                    response.getPay().getTrackId(),
                    response.getPay().getTrxId());
              } else {
                log.error(
                    "[결제 요청 실패 - {}]\n>주문번호 : {}\n>에러코드 : {}\n>상세내용 : {}",
                    response.getResult().getResultMsg(),
                    payRequest.getPay().getTrackId(),
                    response.getResult().getResultCd(),
                    response.getResult().getAdvanceMsg());
              }
              PaymentLog paymentLog =
                  buildPaymentLog("pay", response.getPay(), response.getResult());
              savePaymentLog(paymentLog, "결제", payRequest.getPay().getTrackId());
              return ResponseEntity.ok(response.getResult());
            });
  }

  /**
   * 환불 요청을 수행합니다.
   *
   * @param refundRequest 환불에 필요한 모든 정보를 담고 있는 요청 객체
   * @return API 응답을 포함하는 Mono<ResponseEntity<?>> 객체
   */
  @Override
  public Mono<ResponseEntity<?>> paymentRefund(RefundRequest refundRequest) {
    log.info(
        "[결제취소 요청 발생]\n>주문번호 : {}\n>거래번호 : {}",
        refundRequest.getRefund().getTrackId(),
        refundRequest.getRefund().getRootTrxId());
    return webClient
        .post()
        .uri("/refund")
        .bodyValue(refundRequest)
        .retrieve()
        .bodyToMono(RefundResponse.class)
        .publishOn(Schedulers.boundedElastic())
        .map(
            response -> {
              if (response.getResult().getResultCd().equals("0000")) {
                log.info(
                    "[결제취소 요청 성공 - {}]\n>주문번호 : {}\n>거래번호 : {}",
                    response.getResult().getAdvanceMsg(),
                    response.getRefund().getTrackId(),
                    response.getRefund().getRootTrxId());
              } else {
                log.error(
                    "[결제취소 요청 실패 - {}]\n>주문번호 : {}\n>에러코드 : {}\n>상세내용 : {}\n>거래번호 : {}",
                    response.getResult().getResultMsg(),
                    refundRequest.getRefund().getTrackId(),
                    response.getResult().getResultCd(),
                    response.getResult().getAdvanceMsg(),
                    refundRequest.getRefund().getRootTrxId());
              }
              PaymentLog paymentLog =
                  buildPaymentLog("refund", response.getRefund(), response.getResult());
              savePaymentLog(paymentLog, "결제 취소", refundRequest.getRefund().getTrackId());
              return ResponseEntity.ok(response.getResult());
            });
  }

  private PaymentLog buildPaymentLog(String requestType, Object detail, Result result) {
    return PaymentLog.builder().requestType(requestType).result(result).detail(detail).build();
  }

  private void savePaymentLog(PaymentLog paymentLog, String action, String trackId) {
    paymentLogRepository
        .save(paymentLog)
        .subscribe(result -> log.info("[{} 로그 저장 완료]\n>주문번호 : {}", action, trackId));
  }
}
