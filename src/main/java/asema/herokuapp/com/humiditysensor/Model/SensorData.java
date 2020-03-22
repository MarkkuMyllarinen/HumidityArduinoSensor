package asema.herokuapp.com.humiditysensor.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stringTime;
    private Date date;
    private Double temperature;
    private Double humidity;
    private Long unixTime;

    public SensorData() {
    }

    public SensorData(Date date, Long unixTime, String stringTime, Double temperature, Double humidity) {
        this.date = date;
        this.unixTime = unixTime;
        this.stringTime = stringTime;
        this.temperature = temperature;
        this.humidity = humidity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(Long unixTime) {
        this.unixTime = unixTime;
    }

    public String getStringTime() {
        return stringTime;
    }

    public void setStringTime(String stringTime) {
        this.stringTime = stringTime;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", stringTime='" + stringTime + '\'' +
                ", date=" + date +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", unixTime=" + unixTime +
                '}';
    }
}
