package asema.herokuapp.com.humiditysensor.Control;

import asema.herokuapp.com.humiditysensor.Model.SensorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class WebController {


    private static final Logger logger = LoggerFactory.getLogger(WebController.class);


    @Autowired
    SensorRepository sensorRepository;

    @RequestMapping(value = "/newdata/{temp}/{humi}", method = RequestMethod.GET)
    public String getEditBookForm(@PathVariable Double temp, @PathVariable Double humi) {

        logger.info("temp: " + temp + "    humidity: " + humi);

        sensorRepository.save(new SensorData(new Date(), Instant.now().getEpochSecond(), temp, humi));

        return "redirect:/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getNewBookForm(Model model) {

        List<SensorData> list = (List<SensorData>) sensorRepository.findAll();

        model.addAttribute("list", list);
        return "listall";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)  //TODO Do proper error page and error handling
    public String getErrorPage() {
        return "error";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultPage() {
        return "listall";
    }


    //API's

    @CrossOrigin
    @RequestMapping(value = "/datalist", method = RequestMethod.GET)
    public @ResponseBody
    List<SensorData> getAll() {
        return (List<SensorData>) sensorRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/datalist/{value}", method = RequestMethod.GET)
    public @ResponseBody
    List<SensorData> getLimitedToValue(@PathVariable int value) {
        List<SensorData> list = (List<SensorData>) sensorRepository.findAll();
        List<SensorData> lastItems = new ArrayList<>();
        for (int i = list.size(); i > list.size() - value; i--) {
            lastItems.add(list.get(i - 1));
        }
        return lastItems;
    }


}
