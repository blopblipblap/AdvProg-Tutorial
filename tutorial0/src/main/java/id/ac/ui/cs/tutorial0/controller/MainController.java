package id.ac.ui.cs.tutorial0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    private String home() {
        return "rumah";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/greet")
    private String greetingsWithRequestParam(@RequestParam("name")String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
