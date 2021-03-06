package rs3.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j
@Controller
@RequestMapping("/Hello")
public class HelloController {
    @RequestMapping(method =RequestMethod.GET)
        public String printHello(Model model, @RequestParam(value = "custom", required = false) String customHello){
        model.addAttribute("message", customHello==null?"Hello world":customHello);
        return "hello";
    }

}
