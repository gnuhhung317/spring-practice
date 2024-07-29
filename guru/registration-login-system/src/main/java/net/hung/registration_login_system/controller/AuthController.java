package net.hung.registration_login_system.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import net.hung.registration_login_system.dto.UserDto;
import net.hung.registration_login_system.entity.User;
import net.hung.registration_login_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignupForm(Model model) {

        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto,
                           BindingResult result,
                           Model model) {
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null && existing.getEmail()!=null && !existing.getEmail().isEmpty()) {
            result.rejectValue("email",null,"There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
