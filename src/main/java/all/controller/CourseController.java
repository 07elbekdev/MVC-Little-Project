package all.controller;

import all.dao.CompanyDao;
import all.dao.CourseDao;
import all.model.Company;
import all.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    private final CourseDao courseDao;
    private final CompanyDao companyDao;

    @Autowired
    public CourseController(CourseDao courseDao, CompanyDao companyDao) {
        this.courseDao = courseDao;
        this.companyDao = companyDao;
    }

    @GetMapping("/c")
    public String findAll(Model model) {
        model.addAttribute("findAll", courseDao.findAll());
        return "show-AllCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute Course course, @RequestParam("id") int id) {
        Company company = companyDao.findById(id);
        course.setCompany(company);
        courseDao.save(course);
        return "redirect:/c";
    }

    @GetMapping("/saveCourseForm")
    public String saveCoursePage(Model model) {
        model.addAttribute("company", companyDao.findAll());
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