package all.controller;

import all.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    @Autowired
    private final GroupDao groupDao;

    public GroupController(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
}