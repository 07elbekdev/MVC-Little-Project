package all.dao.impl;

import all.dao.GroupsDao;
import all.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupsDaoImpl implements GroupsDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Groups> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Groups p", Groups.class).getResultList();
    }

    @Override
    public Groups findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Groups.class, id);
    }

    @Override
    public void save(Groups group) {
        Session session = sessionFactory.getCurrentSession();
        session.save(group);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups where id=:groupsId").setParameter("groupsId", id).executeUpdate();
    }

    @Override
    public void updateGroup(int id, Groups group) {
        Session session = sessionFactory.getCurrentSession();
        Groups group1 = findById(id);
        group1.setName(group.getName());
        group1.setStudentsAmount(group.getStudentsAmount());
        session.merge(group1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups ").executeUpdate();
    }
}