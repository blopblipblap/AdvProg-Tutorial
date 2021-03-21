package id.ac.ui.cs.advprog.tutorial2.template.controller;

import id.ac.ui.cs.advprog.tutorial2.template.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestController {
    @Autowired
    private QuestService questService;

    @RequestMapping(path = "/attack")
    public String questHome(Model model) {
        model.addAttribute("Saber", questService.getSaber());
        model.addAttribute("Archer", questService.getArcher());
        model.addAttribute("Lancer", questService.getLancer());
        return "template/quest";
    }

}