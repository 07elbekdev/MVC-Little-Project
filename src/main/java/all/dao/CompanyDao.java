package all.dao;

import all.model.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> findAll();

    Company findById(int id);

    void save(Company company);

    void deleteById(int id);

    void updatePerson(int id, Company company);

    void clear();
}