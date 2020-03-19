package asema.herokuapp.com.humiditysensor.Config;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${postgres://pacftualtbycbb:9b54c895db4bbb797dd413120a05c2377d45405c047d5dcca6ed2be99e058e36@ec2-54-228-237-40.eu-west-1.compute.amazonaws.com:5432/dcjh4np1f3fhl2  }")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
}
