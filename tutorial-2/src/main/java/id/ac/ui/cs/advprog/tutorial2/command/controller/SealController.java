package id.ac.ui.cs.advprog.tutorial2.command.controller;

import id.ac.ui.cs.advprog.tutorial2.command.service.SealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SealController {
    @Autowired
    private SealService sealService;

    @RequestMapping(path = "/seal", method = RequestMethod.GET)
    public String sealHome(Model model) {
        model.addAttribute("spells", sealService.getSpells());
        model.addAttribute("familiars", sealService.getFamiliar());
        model.addAttribute("spirits", sealService.getHighSpirits());
        return "command/sealHome";
    }

    @RequestMapping(path = "/cast", method = RequestMethod.POST)
    public String castSpell(@RequestParam(value = "spellName") String spellName) {
        // TODO: Complete Me
        sealService.castSpell(spellName);
        return "redirect:/seal";
    }

    @RequestMapping(path = "/undo", method = RequestMethod.GET)
    public String undoSpell() {
        // TODO: Complete Me
        sealService.undoSpell();
        return "redirect:/seal";
    }
}
