package id.ac.ui.cs.advprog.tutorial4.factory.controller;

import id.ac.ui.cs.advprog.tutorial4.factory.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FactoryController {
    @Autowired
    private MenuService menuService;
    
    @GetMapping("/menus")
    public String getmenus(Model model){
        model.addAttribute("RestaurantMenu", menuService.getMenus());
        return "factory/menus";
    }

    @PostMapping("/newMenu")
    public String createMenu(HttpServletRequest request){
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        menuService.createMenu(name, type);
        return "redirect:/menus";
    }
}