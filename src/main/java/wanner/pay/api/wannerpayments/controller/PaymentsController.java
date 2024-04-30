package wanner.pay.api.wannerpayments.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import wanner.pay.api.wannerpayments.model.request.PayRequest;
import wanner.pay.api.wannerpayments.model.request.RefundRequest;
import wanner.pay.api.wannerpayments.service.PaymentService;

@RestController
@RequestMapping("/wanner")
@RequiredArgsConstructor
public class PaymentsController {

  private final PaymentService paymentService;

  @PostMapping("/pay")
  public Mono<ResponseEntity<?>> paymentPay(@RequestBody PayRequest payRequest) {
    return paymentService.paymentPay(payRequest);
  }

  @PostMapping("/refund")
  public Mono<ResponseEntity<?>> paymentRefund(@RequestBody RefundRequest paymentRequest) {
    return paymentService.paymentRefund(paymentRequest);
  }
}
