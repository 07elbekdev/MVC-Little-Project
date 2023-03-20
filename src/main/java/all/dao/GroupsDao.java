package all.dao;

import all.model.Groups;

import java.util.List;

public interface GroupsDao {
    List<Groups> findAll();

    Groups findById(int id);

    void save(Groups group);

    void deleteById(int id);

    void updateGroup(int id, Groups group);

    void clear();

    List<Groups> showAllRelationsOfGroup(int id);
}