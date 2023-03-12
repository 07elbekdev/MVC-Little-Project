package all.controller;

import all.dao.GroupsDao;
import all.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroupController {
    @Autowired
    private final GroupsDao groupDao;

    public GroupController(GroupsDao groupDao) {
        this.groupDao = groupDao;
    }

    @GetMapping("/g")
    public String findAll(Model model) {
        model.addAttribute("G", groupDao.findAll());
        return "show-AllGroup";
    }

    @PostMapping("/saveGroup")
    public String saveCourse(@ModelAttribute Groups group) {
        groupDao.save(group);
        return "redirect:/g";
    }

    @GetMapping("/saveGroupForm")
    public String saveCoursePage() {
        return "group-add";
    }

    @GetMapping("/delete/Group/{id}")
    public String deleteById(Model model, @PathVariable int id) {
        Groups group = groupDao.findById(id);
        groupDao.deleteById(id);
        return "redirect:/g";
    }

    @GetMapping("/getGroup/by/{id}")
    public String getById(Model model, @PathVariable int id) {
        Groups group = groupDao.findById(id);
        model.addAttribute("get", group);
        return "getByIdGroup";
    }

    @GetMapping("/updateGroupBy/{id}")
    public String updateCourse(@PathVariable int id, Model model) {
        Groups group = groupDao.findById(id);
        model.addAttribute("update", group);
        return "updateGroupId";
    }

    @PostMapping("/realGroup/update/{id}")
    public String updateCourse(@RequestParam("name") String name, @RequestParam("studentsAmount") int studentsAmount, @PathVariable int id) {
        Groups group = new Groups();
        group.setName(name);
        group.setStudentsAmount(studentsAmount);
        groupDao.updateGroup(id, group);
        return "redirect:/g";
    }

    @GetMapping("/clearGroup")
    public String clear() {
        groupDao.clear();
        return "redirect:/g";
    }
}