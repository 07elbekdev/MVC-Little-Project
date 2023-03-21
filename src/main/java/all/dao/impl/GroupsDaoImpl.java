package all.dao.impl;

import all.dao.CompanyDao;
import all.dao.GroupsDao;
import all.model.Company;
import all.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class GroupsDaoImpl implements GroupsDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CompanyDao companyDao;

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

    @Override
    public List<Groups> showAllRelationsOfGroup(int id) {
        List<Groups> groups = new ArrayList<>();
        Company company = companyDao.findById(id);
        for (Groups group : findAll()) {
            Groups groups1 = findById(group.getId());
            if (groups1.getCompany().getId() == company.getId()) {
                groups.add(groups1);
            }
        }
        return groups;
    }
}