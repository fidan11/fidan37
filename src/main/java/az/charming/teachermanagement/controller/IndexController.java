package az.charming.teachermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;//sirf springin kitabxanasindan gelir

@Controller
public class IndexController {


    @RequestMapping("/alma")
    public String index() {
        return "index";
    }
}
