package wanna.pay.api.wannapayments.model.common;

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
public class RefundDetail {

  /* 원거래에 대한 윈글로벌페이 거래번호 */
  private String rootTrxId;

  /* 원거래에 대한 가맹점 주문번호 */
  private String rootTrackId;

  /* 원거래의 거래 기준일 ( YYYYMMDD )*/
  private String rootTrxDay;

  /* 윈글로벌 페이 취소 거래 번호 [응답시 회신] */
  private String authCd;

  /* 윈글로벌페이 취소 거래 번호 [응답시 회신]*/
  private String trxId;

  /* 거래 타입 Default = ONTR */
  private String trxType;

  /* 취소 시의 가맹점 주문번호 */
  private String trackId;

  /* 취소 금액 */
  private long amount;

  /* 가맹점 정의 필드 [응답시 회신] */
  private String udf1;
  private String udf2;
}
