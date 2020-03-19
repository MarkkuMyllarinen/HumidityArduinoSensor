package asema.herokuapp.com.humiditysensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HumiditysensorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumiditysensorApplication.class, args);
    }


    //Arduino based humidity sensor which sends data to Heroku server and is visualized with React frontend.

}
