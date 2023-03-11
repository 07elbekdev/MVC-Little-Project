package all.dao.impl;

import all.dao.GroupDao;
import all.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Group> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Group p", Group.class).getResultList();
    }

    @Override
    public Group findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Group.class, id);
    }

    @Override
    public void save(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.save(group);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group where id=:groupId").setParameter("groupId", id).executeUpdate();
    }

    @Override
    public void updateGroup(int id, Group group) {
        Session session = sessionFactory.getCurrentSession();
        Group group1 = findById(id);
        group1.setName(group.getName());
        group1.setStudentsAmount(group.getStudentsAmount());
        session.merge(group1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group").executeUpdate();
    }
}