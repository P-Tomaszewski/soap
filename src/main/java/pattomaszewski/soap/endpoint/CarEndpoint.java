package pattomaszewski.soap.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pattomaszewski.soap.SoapConfig;
import pattomaszewski.soap.mapper.CarDtoMapper;
import pattomaszewski.soap.model.Car;
import pattomaszewski.soap.repository.CarRepository;
import pattomaszewski.sri4.cars.CarDto;
import pattomaszewski.sri4.cars.GetCarsRequest;
import pattomaszewski.sri4.cars.GetCarsResponse;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
@RequiredArgsConstructor
public class CarEndpoint {

    private final CarDtoMapper carDtoMapper;
    private final CarRepository carRepository;

    @PayloadRoot(namespace = SoapConfig.CAR_NAMESPACE, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarsResponse getCar(@RequestPayload GetCarsRequest request){
        List<Car> carList = carRepository.findAll();
        List<CarDto> dtoList = carList.stream()
                .map(carDtoMapper::convertToDto)
                .collect(Collectors.toList());
        GetCarsResponse res = new GetCarsResponse();
        res.getCars().addAll(dtoList);
        return res;
    }
}
