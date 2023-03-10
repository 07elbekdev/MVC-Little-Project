package all.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int studentsAmount;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany
    @JoinColumn(name = "course_id")
    private List<Course> courses;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> studentList;
    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", studentsAmount=" + studentsAmount +
                '}';
    }
}