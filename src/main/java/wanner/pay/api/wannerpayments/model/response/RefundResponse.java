package wanner.pay.api.wannerpayments.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanner.pay.api.wannerpayments.model.common.Refund;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefundResponse {

  /* 송신 결과 */
  private Result result;

  /* 환불 정보 */
  private Refund refund;
}
