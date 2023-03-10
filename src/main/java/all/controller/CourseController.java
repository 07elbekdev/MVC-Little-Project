package all.controller;

import all.dao.CourseDao;
import all.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired
    private final CourseDao courseDao;

    public CourseController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @GetMapping("/c")
    public String findAll(Model model) {
        model.addAttribute("findAll", courseDao.findAll());
        return "show-AllCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute Course course) {
        courseDao.save(course);
        return "redirect:/c";
    }

    @GetMapping("/saveCourseForm")
    public String saveCoursePage() {
        return "course-add";
    }

    @GetMapping("/delete/Course/{id}")
    public String deleteById(Model model, @PathVariable int id) {
//        Course course = courseDao.findById(id);
        courseDao.deleteById(id);
        return "redirect:/c";
    }

    @GetMapping("/getCourse/by/{id}")
    public String getById(Model model, @PathVariable int id) {
        Course course = courseDao.findById(id);
        model.addAttribute("get", course);
        return "getByIdCourse";
    }

    @GetMapping("/updateCourseBy/{id}")
    public String updateCourse(@PathVariable int id, Model model) {
        Course course = courseDao.findById(id);
        model.addAttribute("update", course);
        return "updateCourseId";
    }

    @PostMapping("/real/updateCourse/{id}")
    public String updateCourse(@RequestParam("name") String name, @RequestParam("duration") int duration, @PathVariable int id) {
        Course course = new Course();
        course.setName(name);
        course.setDuration(duration);
        courseDao.updateCourse(id, course);
        return "redirect:/c";
    }

    @GetMapping("/clearCourse")
    public String clear() {
        courseDao.clear();
        return "redirect:/c";
    }
}