package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // MVC방식
    @GetMapping("hello") // url mapping
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // (key , value)
        return "hello"; // template와 매핑
    }

    // MVC방식:파라미터 name으로 받기
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); // 모델에 담기
        return "hello-template"; // 모델 넘기기
    }

    // API방식(HttpMessageConverter작동)

    // 단순문자
    @GetMapping("hello-string")
    @ResponseBody // 응답 body부에 return값을 전달하겠다 / 문자 ( HttpMessageConverter의 StringConverter가 변환해줌)
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello 파라미터"
    }

    // 객체
    @GetMapping("hello-api")
    @ResponseBody // 객체면 json으로 데이터 만들어서 전달 ( HttpMessageConverter의 JsonConverter가 변환해줌)
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // 객체생성
        hello.setName(name); // 이름설정
        return hello; // 객체를 넘김
    }

    // Hello 클래스 만들어주기
    static class Hello{
        private  String name;

        // ctrl + enter -> getter and setter하면 완성
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

