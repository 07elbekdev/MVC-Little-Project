package all.controller;

import all.dao.GroupsDao;
import all.dao.StudentDao;
import all.model.Groups;
import all.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentDao studentDao;
    private final GroupsDao groupsDao;

    @Autowired
    public StudentController(StudentDao studentDao, GroupsDao groupsDao) {
        this.studentDao = studentDao;
        this.groupsDao = groupsDao;
    }

    @GetMapping("/s")
    public String findAll(Model model) {
        model.addAttribute("findAll", studentDao.findAll());
        return "show-AllStudent";
    }

    @PostMapping("/saveStudent")
    public String saveCourse(@ModelAttribute Student student,@RequestParam("id") int id) {
        Groups groups = groupsDao.findById(id);
        student.setGroup(groups);
        studentDao.save(student);
        return "redirect:/s";
    }

    @GetMapping("/saveStudentForm")
    public String saveCoursePage(Model model) {
        model.addAttribute("group",groupsDao.findAll());
        return "student-add";
    }

    @GetMapping("/delete/Student/{id}")
    public String deleteById(Model model, @PathVariable int id) {
        Student student = studentDao.findById(id);
        studentDao.deleteById(id);
        return "redirect:/s";
    }

    @GetMapping("/getStudentBy/{id}")
    public String getById(Model model, @PathVariable int id) {
        Student student = studentDao.findById(id);
        model.addAttribute("s", student);
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