package ApiOne.Entities;

import javax.persistence.*;

@Entity
@Table(name = "univeristy_table")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer universityId;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public University() {}

    public University(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
