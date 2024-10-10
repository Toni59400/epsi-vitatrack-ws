package epsi.vitatrack.service;


import epsi.vitatrack.dto.SensorDataDTO;
import epsi.vitatrack.entity.SensorData;
import epsi.vitatrack.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorDataRepository sensorDataRepository;

    public SensorService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public SensorData saveSensorData(SensorDataDTO sensorDataDTO) {
        SensorData sensorData = new SensorData();
        sensorData.setTemperature(sensorDataDTO.getTemperature());
        sensorData.setHumidity(sensorDataDTO.getHumidity());
        return sensorDataRepository.save(sensorData); // Save the data with a timestamp
    }

    public List<SensorData> getAll(){
        return sensorDataRepository.findAll();
    }
}
