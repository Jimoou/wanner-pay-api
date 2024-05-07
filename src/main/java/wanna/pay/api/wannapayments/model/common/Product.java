package wanna.pay.api.wannapayments.model.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  /* 상품 ID */
  private String prodId;

  /* 상품명   */
  @NotBlank private String name;

  /* 구매 수량 */
  private Integer qty = 1;

  /* 상품 가격 */
  @NotNull private Integer price;

  /* 상세 설명 */
  private String desc;
}
