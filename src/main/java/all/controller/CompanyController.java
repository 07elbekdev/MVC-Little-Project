package all.controller;

import all.dao.*;
import all.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {
    private final CompanyDao companyDao;
    private final CourseDao courseDao;
    private final GroupsDao groupsDao;
    private final TeacherDao teacherDao;
    private final StudentDao studentDao;

    @Autowired
    public CompanyController(CompanyDao companyDao, CourseDao courseDao, GroupsDao groupsDao, TeacherDao teacherDao, StudentDao studentDao) {
        this.companyDao = companyDao;
        this.courseDao = courseDao;
        this.groupsDao = groupsDao;
        this.teacherDao = teacherDao;
        this.studentDao = studentDao;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("all", companyDao.findAll());
        return "show-all";
    }

    @PostMapping("/saveCompany")
    private String saveCompany(@ModelAttribute("company") Company company) {
        companyDao.save(company);
        return "redirect:/";
    }

    @GetMapping("/saveCompanyForm")
    public String saveCompanyPage() {
        return "company-add";
    }

    @GetMapping("/delete/Company/{id}")
    public String deleteById(@PathVariable int id) {
        companyDao.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/get/by/{id}")
    public String getById(Model model, @PathVariable int id) {
        Company company = companyDao.findById(id);
        model.addAttribute("comp", company);
        return "getById";
    }

    @GetMapping("/update/{id}")
    public String updateCompany(@PathVariable int id, Model model) {
        Company company = companyDao.findById(id);
        model.addAttribute("company", company);
        return "updateId";
    }

    @PostMapping("/real/update/{id}")
    public String updateCompany(@RequestParam("name") String name, @RequestParam("locatedCountry") String locatedCountry, @PathVariable int id) {
        Company company = new Company();
        company.setName(name);
        company.setLocatedCountry(locatedCountry);
        companyDao.updateCompany(id, company);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        companyDao.clear();
        return "redirect:/";
    }

    @GetMapping("/showAllRelations/{id}")
    public String showAllRelations(Model model, @PathVariable("id") int id) {
        model.addAttribute("company", companyDao.findById(id));
        model.addAttribute("course", courseDao.showAllTheRelationsOfCourse(id));
        for (int i = 0; i < teacherDao.showAllRelationsOfTeacher(id).size(); i++) {
            model.addAttribute("teacher", teacherDao.showAllRelationsOfTeacher(id));
        }
        model.addAttribute("groups", groupsDao.showAllRelationsOfGroup(id));
        for (int i = 0; i < studentDao.showAllRelationsOfStudent(id).size(); i++) {
            model.addAttribute("student", studentDao.showAllRelationsOfStudent(id));
        }
        return "showAllRelations";
    }
}