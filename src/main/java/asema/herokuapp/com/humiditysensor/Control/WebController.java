package asema.herokuapp.com.humiditysensor.Control;

import asema.herokuapp.com.humiditysensor.Model.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@Controller
public class WebController {


    @Autowired
    SensorRepository sensorRepository;

    @RequestMapping(value = "/measurements", method = RequestMethod.GET)
    public String getNewBookForm(Model model) {
        model.addAttribute("temperature", new SensorData(new Date(),23.2, 24.2));
        return "index";
    }


}
