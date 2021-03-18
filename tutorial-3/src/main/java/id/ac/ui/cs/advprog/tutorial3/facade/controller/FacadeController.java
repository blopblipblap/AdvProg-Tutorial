package id.ac.ui.cs.advprog.tutorial3.facade.controller;

import id.ac.ui.cs.advprog.tutorial3.facade.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/runicArts")
public class FacadeController {

    @Autowired
    private FacadeService facadeService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    private String home(){
        return "facade/translateForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/processTranslate")
    private String translateForm(HttpServletRequest request){
        String type = request.getParameter("type");
        String text = request.getParameter("text");
        facadeService.setRequestType(type);
        facadeService.setRequestValue(text);
        return "redirect:/runicArts/translate";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/translate")
    private String processText(Model model){
        boolean isEncode = facadeService.isRequestEncode();
        String value = facadeService.getRequestValue();
        model.addAttribute("inputType", isEncode ? "Text" : "Rune");
        model.addAttribute("input", value);
        model.addAttribute("result", isEncode ? facadeService.encode(value) : facadeService.decode(value));
        return "facade/result";
    }
}