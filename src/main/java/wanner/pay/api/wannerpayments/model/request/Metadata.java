package wanner.pay.api.wannerpayments.model.request;

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
public class Metadata {

  /* 카드 인증 요청 여부 */
  private boolean cardAuth;

  /* 카드 비밀번호 앞 2자리 */
  private String authPw;

  /* 카드 소유주 생년 월일 ( YYMMDD )*/
  private String authDob;
}
