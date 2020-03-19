package asema.herokuapp.com.humiditysensor.Control;

import asema.herokuapp.com.humiditysensor.Model.SensorData;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<SensorData,Long> {
}
