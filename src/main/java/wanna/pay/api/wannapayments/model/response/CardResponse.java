package wanna.pay.api.wannapayments.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {

  /* WGP Card Id */
  private String cardId;

  /* 할부 기간 */
  private String installment;

  /* 카드번호 앞 6자리 */
  private String bin;

  /* 카드번호 뒤 4자리 */
  private String last4;

  /* 카드 매입사 */
  private String issuer;

  /* 카드 타입 (신용, 체크, 기타) */
  private String cardType;

  /* 카드 브랜드 */
  private String acquirer;
}
