package org.springsse.example.sseexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    /**
     * pagina de inicio
     * @return
     */
    @GetMapping("/")
    public String inicio(){
        return "index.html";
    }
}
