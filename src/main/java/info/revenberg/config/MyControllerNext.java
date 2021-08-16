package info.revenberg.config;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class MyControllerNext {

    @GetMapping(value = "/next", produces = MediaType.TEXT_HTML_VALUE)
    public String home(Model model) {

        String fileName = "bingo.txt";
        ArrayList<String> words = new ArrayList<String>();

        FileInputStream fstream;
        try {
            fstream = new FileInputStream(fileName);

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            
            while ((strLine = br.readLine()) != null) {
                words.add(strLine);
            }

            fstream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(words);
        model.addAttribute("words", words);

        return "index";
    }
}
