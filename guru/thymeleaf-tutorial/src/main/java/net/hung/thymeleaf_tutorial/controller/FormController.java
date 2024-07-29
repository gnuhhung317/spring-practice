package net.hung.thymeleaf_tutorial.controller;

import net.hung.thymeleaf_tutorial.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FormController {
    @GetMapping("register")
    public String userRegistrationPage(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        List<String>  professionList = List.of("Developer", "Designer", "Tester");
        model.addAttribute("professionList", professionList);
        return "register-form";
    }
    @PostMapping("register/save")
    public String userRegistrationResult(Model model,@ModelAttribute("userForm") UserForm userForm) {
        model.addAttribute("userForm", userForm);
        return "register-result";
    }
}
