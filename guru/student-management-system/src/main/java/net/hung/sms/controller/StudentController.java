package net.hung.sms.controller;

import jakarta.validation.Valid;
import net.hung.sms.dto.StudentDto;
import net.hung.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public String getStudents(Model model) {
        List<StudentDto> studentDtos = studentService.getAllStudent();
        model.addAttribute("students", studentDtos);
        return "students";

    }

    @GetMapping("/students/new")
    public String newStudentPage(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "new-student";
    }
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                              BindingResult result,
                              Model model) {
        if(result.hasErrors()) {
            model.addAttribute("student", studentDto);
            return "new-student";
        }
        studentService.save(studentDto);
        return "redirect:/students";
    }
    @GetMapping("students/edit/{id}")
    public String editStudentPage(@PathVariable Long id , Model model){
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student", studentDto);
        return "edit-student";

    }
    @PostMapping("students/{id}/edit")
    public String updateStudent(@PathVariable Long id,@Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("student", studentDto);
            return "edit-student";
        }
        studentDto.setId(id);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }
    @GetMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
    @GetMapping("students/{id}/view")
    public String viewStudent(@PathVariable Long id,Model model){
        StudentDto studentDto = studentService.getStudentById(id);

        model.addAttribute("student", studentDto);

        return "view-student";
    }
}
