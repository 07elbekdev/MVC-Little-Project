package all.controller;

import all.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {
    @Autowired
    private final TeacherDao teacherDao;

    public TeacherController(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
}