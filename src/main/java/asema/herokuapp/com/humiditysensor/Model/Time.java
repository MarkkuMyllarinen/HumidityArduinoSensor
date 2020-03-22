package asema.herokuapp.com.humiditysensor.Model;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

    public String getTime() {

        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("Europe/Helsinki");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);

        return (DateTimeFormatter.ofPattern("dd.MM.yyyy   HH:mm").format(zdt));
    }


}
