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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany
    private List<Course> course;
}