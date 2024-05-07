package wanna.pay.api.wannapayments.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wanna.pay.api.wannapayments.model.common.RefundDetail;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefundRequest {

  /* 환불 상세 정보 */
  @NotNull private RefundDetail refund;
}
