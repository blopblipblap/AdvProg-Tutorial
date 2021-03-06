package id.ac.ui.cs.advprog.tutorial1.strategy.controller;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.DefenseBehavior;
import id.ac.ui.cs.advprog.tutorial1.strategy.service.AdventurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/adventurer")
public class StrategyController {

    @Autowired
    private AdventurerService adventurerService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String strategyHome(Model model) {
        Iterable<AttackBehavior> attackBehaviors = adventurerService.getAttackBehaviors();
        Iterable<DefenseBehavior> defenseBehaviors = adventurerService.getDefenseBehaviors();
        //ToDo: Complete me
        Iterable<Adventurer> adventurers = adventurerService.findAll();
        model.addAttribute("attack", attackBehaviors);
        model.addAttribute("defense", defenseBehaviors);
        model.addAttribute("adventurers",adventurers);
        return "strategy/home";
    }

    //ToDo: Fill with a correct method
    @RequestMapping(path = "/change-strategy", method = RequestMethod.POST)
    public String changeAttack(
            @RequestParam(value = "alias") String alias,
            @RequestParam(value = "attackType") String attackType,
            @RequestParam(value = "defenseType") String defenseType) {

        adventurerService.changeStrategy(alias, attackType, defenseType);
        //ToDo: This should redirect to home URL
        return "redirect:/adventurer/all";
    }

}