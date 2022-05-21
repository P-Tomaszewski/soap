package pattomaszewski.soap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pattomaszewski.soap.model.Car;
import pattomaszewski.soap.repository.CarRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataInitializer implements ApplicationRunner {

    private CarRepository carRepository;

    public DataInitializer(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Car c1 = Car.builder()
                .modelName("Tesla")
                .color("black")
                .createDate(LocalDate.now())
                .doorNumber(5)
                .build();
        Car c2 = Car.builder()
                .modelName("Peugot")
                .color("black")
                .createDate(LocalDate.now())
                .doorNumber(3)
                .build();
        Car c3 = Car.builder()
                .modelName("KIA")
                .color("black")
                .createDate(LocalDate.now())
                .doorNumber(3)
                .build();
        Car c4 = Car.builder()
                .modelName("Volvo")
                .color("black")
                .createDate(LocalDate.now())
                .doorNumber(3)
                .build();
        carRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
    }
}