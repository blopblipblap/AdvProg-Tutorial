package id.ac.ui.cs.advprog.tutorial4.singleton.controller;


import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood;
import id.ac.ui.cs.advprog.tutorial4.singleton.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/singleton")
public class SingletonController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String wanPlusRestaurantHome(Model model) {
        OrderDrink orderDrink = orderService.getDrink();
        OrderFood orderFood = orderService.getFood();
        model.addAttribute("orderDrink", orderDrink);
        model.addAttribute("orderFood", orderFood);
        return "singleton/singleton";
    }

    @PostMapping("/order-a-drink")

    public String orderADrink(@RequestParam(value = "drink") String drink) {
        orderService.orderADrink(drink);
        return "redirect:/singleton/";
    }

    @PostMapping("/order-a-food")

    public String orderAFood(@RequestParam(value = "food") String food) {
        orderService.orderAFood(food);
        return "redirect:/singleton/";
    }
}
