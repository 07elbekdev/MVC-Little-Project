package all.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Course> courseList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Group> groups;

    public Company(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}