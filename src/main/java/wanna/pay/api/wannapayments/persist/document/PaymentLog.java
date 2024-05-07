package wanna.pay.api.wannapayments.persist.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import wanna.pay.api.wannapayments.model.response.Result;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment_log")
public class PaymentLog {
  @Id private String id;
  private String requestType;
  private Result result;
  private Object detail;
}
