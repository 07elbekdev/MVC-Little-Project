package all.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String locatedCountry;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Course> courseList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Groups> groups;

    public Company(String name, String locatedCountry) {
        this.name = name;
        this.locatedCountry = locatedCountry;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", locatedCountry=" + locatedCountry +
                '}';
    }
}