package wanna.pay.api.wannapayments.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PayResponse {

  /* 송신 결과 */
  private Result result;

  /* 결제 상세 정보 */
  private PayResponseDetail pay;
}
