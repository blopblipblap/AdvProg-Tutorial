package id.ac.ui.cs.advprog.tutorial1.observer.controller;

import id.ac.ui.cs.advprog.tutorial1.observer.core.Quest;
import id.ac.ui.cs.advprog.tutorial1.observer.service.GuildServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ObserverController {

    @Autowired
    private GuildServiceImpl guildService;

    @RequestMapping(value = "/create-quest", method = RequestMethod.GET)
    public String createQuest(Model model){
        model.addAttribute("quest", new Quest());
        return "observer/questForm";
    }

    @RequestMapping(value = "/add-quest", method = RequestMethod.POST)
    public String addQuest(@ModelAttribute("quest") Quest quest) {
        guildService.addQuest(quest);
        // ToDo redirect this to adventurer-list URl
        return "redirect:/adventurer-list";
    }

    @RequestMapping(value = "/adventurer-list", method = RequestMethod.GET)
    public String getAdventurers(Model model){
        model.addAttribute("adventurers", guildService.getAdventurers());
        return "observer/adventurerList";
    }
}
