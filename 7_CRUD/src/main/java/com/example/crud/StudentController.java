package com.example.crud;

import ch.qos.logback.core.status.StatusUtil;
import com.example.crud.model.StudentDto;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    // StudentService를 Controller 에서
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/create-view")
    public String createView(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@RequestParam("name") String name, @RequestParam("email") String email){
        StudentDto studentDto = studentService.createStudent(name, email);
        System.out.println(studentDto.toString());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("studentList", studentService.readStudentAll());
        return "home";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model){
        System.out.println(id);
        model.addAttribute("student", studentService.readStudent(id));
        return "read";
    }

    @GetMapping("/{id}/update-view")
    public String updateView(@PathVariable("id") Long id, Model model){
        StudentDto dto = studentService.readStudent(id);
        model.addAttribute("student", dto);
        return "update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @PathParam("name") String name, @PathParam("email") String email){
        StudentDto studentDto = studentService.updateStudent(id, name, email);
        return String.format("redirect:/%s", id);
    }

    @GetMapping("/{id}/delete-view")
    public String deleteView(@PathVariable("id") Long id, Model model){
        StudentDto dto = studentService.readStudent(id);
        model.addAttribute("student", dto);
        return "delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/home";
    }
}
