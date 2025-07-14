import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Instant instant= Instant.now();
        ZonedDateTime zoneDateTime = instant.atZone(TimeZone.getDefault().toZoneId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(zoneDateTime.format(formatter));
    }
}
