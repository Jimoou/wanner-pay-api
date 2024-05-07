package wanna.pay.api.wannapayments.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanna.pay.api.wannapayments.model.common.RefundDetail;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefundResponse {

  /* 송신 결과 */
  private Result result;

  /* 환불 상세 정보 */
  private RefundDetail refund;
}
