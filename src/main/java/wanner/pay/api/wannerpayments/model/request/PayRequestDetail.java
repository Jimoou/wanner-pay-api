package wanner.pay.api.wannerpayments.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wanner.pay.api.wannerpayments.model.common.Product;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayRequestDetail {

  /* 구매자 성명 */
  @NotBlank private String payerName;

  /* 구매자 이메일 */
  @Email @NotBlank private String payerEmail;

  /* 구매자 전화번호 */
  @NotBlank private String payerTel;

  /* 구매자 카드 정보 */
  @NotNull private CardRequest card;

  /* 구매 상품 리스트 */
  @NotNull private List<Product> products;

  /* 거래 타입 Default = ONTR */
  private String trxType;

  /* 가맹점에서 생성한 중복되지 않는` 번호 */
  private String trackId;

  /* 결제 금액 */
  private long amount;

  /* 가맹점 정의 필드 [응답시 회신] */
  private String udf1;
  private String udf2;

  /* 카드 결제에 Option으로 필요한 값*/
  @NotNull private Metadata metadata;
}
