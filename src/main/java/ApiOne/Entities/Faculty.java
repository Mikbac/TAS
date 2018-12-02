package ApiOne.Entities;


import javax.persistence.*;

@Entity
@Table(name = "faculty_table")
public class Faculty {
    @Id
    @GeneratedValue
    private Integer facultyId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "universityId", referencedColumnName = "universityId")
    private University university;

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Faculty() {
    }

    public Faculty(String name, University university) {
        this.name = name;
        this.university = university;
    }
}
