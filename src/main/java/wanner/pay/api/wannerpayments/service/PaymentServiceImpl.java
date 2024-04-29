package wanner.pay.api.wannerpayments.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import wanner.pay.api.wannerpayments.model.common.Refund;
import wanner.pay.api.wannerpayments.model.request.PayRequest;
import wanner.pay.api.wannerpayments.model.response.PayResponse;
import wanner.pay.api.wannerpayments.model.response.RefundResponse;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

  private final WebClient webClient;

  /**
   * 결제 요청을 수행합니다.
   *
   * @param payRequest 필요한 모든 정보를 담고 있는 결제 요청 객체
   * @return API 응답을 포함하는 Mono<ResponseEntity<?>> 객체
   */
  public Mono<ResponseEntity<?>> paymentPay(PayRequest payRequest) {
    return webClient
        .post()
        .uri("/pay")
        .bodyValue(payRequest)
        .retrieve()
        .bodyToMono(PayResponse.class)
        .map(ResponseEntity::ok);
  }

  /**
   * 환불 요청을 수행합니다.
   *
   * @param refundRequest 환불에 필요한 모든 정보를 담고 있는 요청 객체
   * @return API 응답을 포함하는 Mono<ResponseEntity<?>> 객체
   */
  public Mono<ResponseEntity<?>> paymentRefund(Refund refundRequest) {
    return webClient
        .post()
        .uri("/refund")
        .bodyValue(refundRequest)
        .retrieve()
        .bodyToMono(RefundResponse.class)
        .map(ResponseEntity::ok);
  }
}
