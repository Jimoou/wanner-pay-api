package wanner.pay.api.wannerpayments.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TrackIdGenerator {
  public static String generateTrackId() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String timestamp = LocalDateTime.now().format(formatter);
    String uniquePart = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    return String.format("wapy_%s_%s", timestamp, uniquePart);
  }
}
