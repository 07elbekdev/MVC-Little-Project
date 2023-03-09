package all.dao;

import all.model.Group;

import java.util.List;

public interface GroupDao {
    List<Group> findAll();

    Group findById(int id);

    void save(Group group);

    void deleteById(int id);

    void updateGroup(int id, Group group);

    void clear();
}