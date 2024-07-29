package net.hung.thymeleaf_tutorial.controller;

import net.hung.thymeleaf_tutorial.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    @GetMapping("variable-expression")
    public  String variableExpression(Model model) {
        User user= new User("hung", "5Jf9I@example.com", "admin", "male");
        model.addAttribute("user", user);
        return "variable-expression";
    }
    @GetMapping("selection-expression")
    public String selectionExpression(Model model) {
        User user= new User("hung", "5Jf9I@example.com", "admin", "male");
        model.addAttribute("user", user);
        return "selection-expression";
    }
    @GetMapping("message-expression")
    public String messageExpression() {
        return "message-expression";
    }
    @GetMapping("link-expression")
    public String linkExpression(Model model) {
        model.addAttribute("id",1);
        return "link-expression";
    }
    @GetMapping("fragment-expression")
    public String fragmentExpression() {
        return "fragment-expression";
    }
    @GetMapping("users")
    public String users(Model model) {
        User user= new User("hung", "5Jf9I@example.com", "admin", "female");
        User user1= new User("hung1", "FSDF@example.com", "guest", "male");
        User user2 = new User("hung2", "qửakjwqn@example.com", "guest", "male");
        User test = new User("test", "mkasj@example.com", "user", "female");
        model.addAttribute("users", List.of(user,user1,user2,test));
        return "users";
    }
    @GetMapping("if-unless")
    public String ifUnless(
            Model model
    ) {
        User user= new User("hung", "5Jf9I@example.com", "admin", "female");
        User user1= new User("hung1", "FSDF@example.com", "guest", "male");
        User user2 = new User("hung2", "qửakjwqn@example.com", "guest", "male");
        User test = new User("test", "mkasj@example.com", "user", "female");
        model.addAttribute("users", List.of(user,user1,user2,test));
        return "if-unless";
    }
    @GetMapping("switch-case/{name}")
    public String switchCase(
            Model model,
            @PathVariable String name
    ) {
        User user= new User("hung", "5Jf9I@example.com", "admin", "female");
        User user1= new User("hung1", "FSDF@example.com", "guest", "male");
        User user2 = new User("hung2", "qửakjwqn@example.com", "guest", "male");
        User test = new User("test", "mkasj@example.com", "user", "female");
        model.addAttribute("users", List.of(user,user1,user2,test));
        model.addAttribute("name", name);
        return "switch-case";
    }

}
