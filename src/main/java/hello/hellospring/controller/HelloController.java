package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("hello")
    // URL 이름을 매핑시켜준다.
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // data 부분은 html이 받을 이름 값이다. | hello!! 부분은 넘겨줄 값이다.
        return "hello";
    }

    // 전체 Import 단축키 Eclipse = Ctrl Shift O | Intellij = Ctrl Alt O

    //@RequestParam 이런 파라미터 정보 보는 단축 키 Ctrl P
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 body 부의 값을 직접 내려주겠다는 의미
    // HTML의 형식 없이 JSON와 같은 데이터만 내려줄 때를 위해 사용한다.
    public String helloString(@RequestParam("name") String name) {

        System.out.println("출력합니다 : " + name);
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    //JSON 형태로 내려주는 방식이다.
    //ResponseBody를 사용하면 viewResolver 대신 HttpMessageConverter가 동작하게 된다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
