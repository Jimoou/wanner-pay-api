package wanner.pay.api.wannerpayments.service;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import wanner.pay.api.wannerpayments.model.request.PayRequest;
import wanner.pay.api.wannerpayments.model.request.RefundRequest;

public interface PaymentService {
  Mono<ResponseEntity<?>> paymentPay(PayRequest payRequest);

  Mono<ResponseEntity<?>> paymentRefund(RefundRequest refundRequest);
}
