package id.ac.ui.cs.advprog.tutorial3.adapter.controller;

import id.ac.ui.cs.advprog.tutorial3.adapter.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/battle")
public class AdapterController {

    @Autowired
    private WeaponService weaponService;

    // TODO: complete me
    @RequestMapping(path = "", method = RequestMethod.GET)
    public String battleHome(Model model) {
        model.addAttribute("weapons", weaponService.findAll());
        model.addAttribute("logs", weaponService.getAllLogs());
        return "adapter/home";
    }

    // TODO: complete me
    @RequestMapping(path = "/attack")
    public String attackWithWeapon(
        @RequestParam(value = "weaponName") String weaponName,
        @RequestParam(value = "attackType") int attackType) {
        weaponService.attackWithWeapon(weaponName, attackType);
        return "redirect:/battle";
    }
}
