package wanner.pay.api.wannerpayments.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

  /* WGP 정의된 응답코드 */
  private String resultCd;

  /* 실패 사유 */
  private String resultMsg;

  /* 포맷에러, 승인실패, 한도부족 등에 대한 상세 메시지 */
  private String advanceMsg;

  /* 응답 시간 ( YYYYMMDDHHMMSS ) */
  private String create;
}
