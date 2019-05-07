package valve.net.fortniteforever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @Autowired
    public StartController() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("t", 0);
        model.addAttribute("lambda", 0);
        model.addAttribute("su", 0);
        model.addAttribute("cp", 0);
        model.addAttribute("p", 0);
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String getResult(Model model, @ModelAttribute("R") double r, @ModelAttribute("T") double t, @ModelAttribute("λ")
            double λ, @ModelAttribute("Su") double su, @ModelAttribute("Cp") double cp, @ModelAttribute("p") double p) {
        String res;
        if (r != 0 && t != 0 && λ != 0 && su != 0 && cp != 0 && p != 0) {
            res = 32.5 * r * t * λ / su / cp / p + "";
        } else {
            res = "Incorrect input!!!";
        }
        model.addAttribute("t", t);
        model.addAttribute("lambda", λ);
        model.addAttribute("su", su);
        model.addAttribute("cp", cp);
        model.addAttribute("p", p);
        model.addAttribute("res", res);
        return "start";
    }
}
