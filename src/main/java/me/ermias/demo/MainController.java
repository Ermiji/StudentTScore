package me.ermias.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    TestScoreRepository testScoreRepository;

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("testscores", testScoreRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String scoreForm(Model model){
        model.addAttribute("testscore", new TestScore());
        model.addAttribute("students", studentRepository.findAll());
        return "testform";
    }

    @PostMapping("/process")
    public String processForm(@Valid TestScore testScore, BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("students", studentRepository.findAll());
            return "testform";
        }
        testScoreRepository.save(testScore);
        return "redirect:/";
    }

    @GetMapping("/addstudent")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/processstudent")
    public String processSubject(@Valid Student student, BindingResult result,
                                 Model model){
        if(result.hasErrors()){
            return "student";
        }
        studentRepository.save(student);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showStudent(@PathVariable("id") long id, Model model){
        model.addAttribute("testscore", testScoreRepository.findById(id).get());
        return "home";
    }

    @RequestMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, Model model){
        model.addAttribute("subjects", studentRepository.findAll());
        model.addAttribute("testscore", testScoreRepository.findById(id).get());
        return "testform";
    }
}
