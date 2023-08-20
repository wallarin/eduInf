package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    // URL 이름을 매핑시켜준다.
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // data 부분은 html이 받을 이름 값이다. | hello!! 부분은 넘겨줄 값이다.
        return "hello";
    }
}
