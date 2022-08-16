package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarServiceImpl implements CarService {

   private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(2019,"Volkswagen", 2305, "black"));
        cars.add(new Car(2021,"Volvo", 4510, "white"));
        cars.add(new Car(2010,"Fiat", 3410, "grey"));
        cars.add(new Car(2015,"Renault", 2100, "green"));
        cars.add(new Car(1990,"Volga", 1804, "white"));

    }


    @Override
    public List<Car> someCars(Integer count) {
        if (count <=0 || count >= 5) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
