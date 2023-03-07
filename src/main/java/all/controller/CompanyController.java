package all.controller;

import all.dao.CompanyDao;
import all.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompanyController {
    private final CompanyDao companyDao;

    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("all", companyDao.findAll());
        return "find-all";
    }

    @PostMapping("/saveCompany")
    private String saveCompany(@RequestParam("name") String name, @RequestParam("age") int age) {
        Company company = new Company();
        company.setName(name);
        company.setAge(age);
        companyDao.save(company);
        return "redirect:/";
    }

    @GetMapping("/saveCompanyForm")
    public String saveStudentPage() {
        return "company-add";
    }

    @GetMapping("/delete/Company/{id}")
    public String deleteById(Model model, @PathVariable int id) {
        Company company = companyDao.findById(id);
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
        model.addAttribute("update", company);
        return "updateId";
    }

    @PostMapping("/real/update/{id}")
    public String updateCompany(@RequestParam("name") String name, @RequestParam("age") int age, @PathVariable int id) {
        Company company = new Company();
        company.setName(name);
        company.setAge(age);
        companyDao.updatePerson(id, company);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        companyDao.clear();
        return "redirect:/";
    }
}