package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    private final CarServiceImpl carServiceImpl;

    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }


    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", defaultValue = "5", required = false) Integer count, Model model){
        List<Car> list = carServiceImpl.someCars(count);
        model.addAttribute("cars",list);
        return "cars";
    }
}
