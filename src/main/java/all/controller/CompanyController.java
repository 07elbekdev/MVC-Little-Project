package all.controller;

import all.dao.CompanyDao;
import all.dao.CourseDao;
import all.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {
    @Autowired
    private final CompanyDao companyDao;

    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
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
    public String deleteById(Model model, @PathVariable int id) {
//        Company company = companyDao.findById(id);
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
}