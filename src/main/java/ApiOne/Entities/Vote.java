package ApiOne.Entities;
import javax.persistence.*;

@Entity
@Table(name = "vote_table")
public class Vote {
    @Id
    @GeneratedValue
    private Integer voteId;

    @Column(name = "attractiveness")
    private int attractiveness;

    @Column(name = "competency")
    private int competency;

    @Column(name = "difficulty")
    private int difficulty;

    @Column(name = "friendship")
    private int friendship;

    @Column(name = "system")
    private int system;

    @Column(name = "classes")
    private int classes;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "teacher", referencedColumnName = "teacherId")
    private Teacher teacher;

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public int getAttractiveness() {
        return attractiveness;
    }

    public void setAttractiveness(int attractiveness) {
        this.attractiveness = attractiveness;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCompetency() {
        return competency;
    }

    public void setCompetency(int competency) {
        this.competency = competency;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getFriendship() {
        return friendship;
    }

    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public Vote() {}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
