package com.example.mvc;

import com.example.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class MvcController {
//    private int hitCount = 0;
    private final LottoService lottoService;

    public MvcController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @RequestMapping("/")
    public String home(Model model){
        // 문자열을 모델에 전달
        model.addAttribute("message", "Hello, Thymeleaf");
        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model){
        // 객체를 모델에 전달
        model.addAttribute("object", new Student("jiseon", "jiseon1113@naver.com"));
        return "student";
    }

    @RequestMapping("is-logged-in")
    public String isLoggedIn(Model model){
        model.addAttribute("IsLoggedIn", false);
        return "if-unless";
    }

    @RequestMapping("/each")
    public String items(Model model){
        List<String> listofStrings = new ArrayList<>();
        listofStrings.add("foo");
        listofStrings.add("bar");
        listofStrings.add("baz");
        listofStrings.add("sseni");

        model.addAttribute("listOfStrings", listofStrings);

        List<Student> studentList = Arrays.asList(
                new Student("Alex", "alex@gmail.com"),
                new Student("Brad", "brad@gmail.com"),
                new Student("Chad", "chad@gmail.com"));
        model.addAttribute("studentList", studentList);
        return "each";
    }

    @RequestMapping("/hits")
    public String hits(Model model) {
        int hitCount = lottoService.addHit();
        model.addAttribute("hits", hitCount);
        return "hits";
    }

    @RequestMapping("/lotto")
    public String lotto(Model model){
        // 6개의 임의의 숫자 만들기
        // List 는 인터페이스, ArrayList 는 구현체
        List<Integer> winningNums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            winningNums.add(random.nextInt(1, 46));
        }

        List<String> winningNumStrs = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if(i == 5) winningNumStrs.add(winningNums.get(i).toString());
            else winningNumStrs.add(String.format("%d - ", winningNums.get(i)));
        }
        model.addAttribute("winningNums", winningNums);
        model.addAttribute("winningNumStrs", winningNumStrs);
        return "lotto";
    }
}
