package wanner.pay.api.wannerpayments.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardRequest {

  /* 카드 비밀번호 16자리 (-)없음 */
  @NotBlank
  @Length(min = 16, max = 19)
  private String number;

  /* 카드 유효기간 ( YYMM ) */
  @NotBlank
  @Length(min = 4, max = 4)
  private String expiry;

  /* 카드 CVC */
  @NotBlank
  @Length(min = 3, max = 4)
  private String cvv;

  /* 할부 기간 */
  @NotNull private Integer installment;
}
