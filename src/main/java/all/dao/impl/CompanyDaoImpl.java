package all.dao.impl;

import all.dao.CompanyDao;
import all.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public void save(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company where id=:companyId").setParameter("companyId", id).executeUpdate();
    }

    @Override
    public void updateCompany(int id, Company company) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = findById(id);
        company1.setName(company.getName());
        company1.setLocatedCountry(company.getLocatedCountry());
        session.merge(company1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company").executeUpdate();
    }

    @Override
    public void ShowAllRelations(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("select p from Company p where id=:companyId");
    }
}