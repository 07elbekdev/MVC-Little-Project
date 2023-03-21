package all.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int studentsAmount;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> studentList;
    @ManyToMany(mappedBy = "groups")
    private List<Course> courses;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public String toString() {
        return "Group {" +
                "name='" + name + '\'' +
                ", studentsAmount=" + studentsAmount +
                '}';
    }
}