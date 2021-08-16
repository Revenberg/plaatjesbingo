package info.revenberg.config;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import info.revenberg.module.Words;
import info.revenberg.module.Progress;

@Controller
public class MyController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home(Model model) {

        ArrayList<String> words = Words.getList();
        model.addAttribute("counter", Progress.getNext());
        model.addAttribute("words", words);

        return "index";
    }
}
