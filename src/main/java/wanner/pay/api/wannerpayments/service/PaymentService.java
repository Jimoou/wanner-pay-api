package wanner.pay.api.wannerpayments.service;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import wanner.pay.api.wannerpayments.model.common.Refund;
import wanner.pay.api.wannerpayments.model.request.PayRequest;

public interface PaymentService {
  Mono<ResponseEntity<?>> paymentPay(PayRequest payRequest);

  Mono<ResponseEntity<?>> paymentRefund(Refund refundRequest);
}
