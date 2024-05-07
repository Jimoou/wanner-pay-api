package wanna.pay.api.wannapayments.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wanna.pay.api.wannapayments.model.common.Product;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayResponseDetail {

  /* 승인 번호 */
  private String authCd;

  /* 결제 카드 정보 */
  private CardResponse card;

  /* 결제 일 ( YYYYMMDDHHMMSS ) */
  private String trxDate;

  /* 결제한 상품 */
  private List<Product> products;

  /* 거래 번호 */
  private String trxId;

  /* 거래 유형 Default = ONTO */
  private String trxType;

  /* 가맹점 ID */
  private String tmnId;

  /* 가맹점의 주문번호 */
  private String trackId;

  /* 결제 금액 */
  private long amount;

  /* 가맹점 정의 필드 [응답시 회신] */
  private String udf1;
  private String udf2;
}
