package pattomaszewski.soap.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pattomaszewski.soap.model.Car;
import pattomaszewski.sri4.cars.CarDto;

@Component
@RequiredArgsConstructor
public class CarDtoMapper {
    private final ModelMapper modelMapper;

    public CarDto convertToDto(Car e) {return modelMapper.map(e, CarDto.class);}

//    public CarDetailsDto convertToDtoDetails(Car e) {return modelMapper.map(e, CarDetailsDto.class);}

    public Car convertToEntity(CarDto dto) {
        return modelMapper.map(dto, Car.class);
    }
}
