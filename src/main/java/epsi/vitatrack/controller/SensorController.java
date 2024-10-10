package epsi.vitatrack.controller;

import epsi.vitatrack.dto.SensorDataDTO;
import epsi.vitatrack.entity.SensorData;
import epsi.vitatrack.service.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @CrossOrigin("*")
    @PostMapping("/data")
    public ResponseEntity<SensorData> postSensorData(@RequestBody SensorDataDTO sensorDataDTO) {
        SensorData savedData = sensorService.saveSensorData(sensorDataDTO);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @GetMapping("data")
    public ResponseEntity<List<SensorData>> getData(){
        List<SensorData> sensorDataList = sensorService.getAll();
        return new ResponseEntity<>(sensorDataList, HttpStatus.OK);
    }
}
