package all.controller;

import all.dao.TeacherDao;
import all.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    @Autowired
    private final TeacherDao teacherDao;

    public TeacherController(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @GetMapping("/t")
    public String findAll(Model model) {
        model.addAttribute("findAllS", teacherDao.findAll());
        return "show-AllTeacher";
    }

    @PostMapping("/saveTeacher")
    public String saveCourse(@ModelAttribute Teacher teacher) {
        teacherDao.save(teacher);
        return "redirect:/t";
    }

    @GetMapping("/saveTeacherForm")
    public String saveCoursePage() {
        return "teacher-add";
    }

    @GetMapping("/delete/Teacher/{id}")
    public String deleteById(Model model, @PathVariable int id) {
        Teacher teacher = teacherDao.findById(id);
        teacherDao.deleteById(id);
        return "redirect:/t";
    }

    @GetMapping("/getTeacherBy/{id}")
    public String getById(Model model, @PathVariable int id) {
        Teacher teacher = teacherDao.findById(id);
        model.addAttribute("get", teacher);
        return "getByIdTeacher";
    }

    @GetMapping("/updateTeacherBy/{id}")
    public String updateCourse(@PathVariable int id, Model model) {
        Teacher teacher = teacherDao.findById(id);
        model.addAttribute("update", teacher);
        return "updateTeacherId";
    }

    @PostMapping("/realTeacher/update/{id}")
    public String updateCourse(@RequestParam("name") String name, @RequestParam("age") int age, @PathVariable int id) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setAge(age);
        teacherDao.updateTeacher(id, teacher);
        return "redirect:/t";
    }

    @GetMapping("/clearTeacher")
    public String clear() {
        teacherDao.clear();
        return "redirect:/t";
    }
}