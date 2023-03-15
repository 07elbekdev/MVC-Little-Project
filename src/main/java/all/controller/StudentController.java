package all.controller;

import all.dao.StudentDao;
import all.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/s")
    public String findAll(Model model) {
        model.addAttribute("findAll", studentDao.findAll());
        return "show-AllStudent";
    }

    @PostMapping("/saveStudent")
    public String saveCourse(@ModelAttribute Student student) {
        studentDao.save(student);
        return "redirect:/s";
    }

    @GetMapping("/saveStudentForm")
    public String saveCoursePage() {
        return "student-add";
    }

    @GetMapping("/delete/Student/{id}")
    public String deleteById(Model model, @PathVariable int id) {
        Student student = studentDao.findById(id);
        studentDao.deleteById(id);
        return "redirect:/s";
    }

    @GetMapping("/getStudent/by/{id}")
    public String getById(Model model, @PathVariable int id) {
        Student student = studentDao.findById(id);
        model.addAttribute("student", student);
        return "getByIdStudent";
    }

    @GetMapping("/updateStudentBy/{id}")
    public String updateCourse(@PathVariable int id, Model model) {
        Student student = studentDao.findById(id);
        model.addAttribute("student", student);
        return "updateStudentId";
    }

    @PostMapping("/realStudent/update/{id}")
    public String updateCourse(@RequestParam("name") String name, @RequestParam("age") int age, @PathVariable int id) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentDao.updateStudent(id, student);
        return "redirect:/s";
    }

    @GetMapping("/clearStudent")
    public String clear() {
        studentDao.clear();
        return "redirect:/s";
    }
}