package ApiOne.Repositories;

import ApiOne.Entities.Teacher;
import ApiOne.Entities.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  VoteRepository extends CrudRepository<Vote, Integer>, PagingAndSortingRepository<Vote, Integer>{

    Vote findByVoteId(Integer voteId);

    @Query("select count(*) from Vote p where p.voteId = ?1")
    Integer checkIfExist(Integer voteId);

    @Query("select p from Vote p where p.teacher.teacherId = ?1")
    Iterable<Vote> votesList(Integer id);

    @Query("select avg(p.attractiveness) from Vote p where p.teacher.teacherId = ?1")
    Float attractivenessAverage(Integer id);

    @Query("select avg(p.competency) from Vote p where p.teacher.teacherId = ?1")
    Float competencyAverage(Integer id);

    @Query("select avg(p.difficulty) from Vote p where p.teacher.teacherId = ?1")
    Float difficultyAverage(Integer id);

    @Query("select avg(p.friendship) from Vote p where p.teacher.teacherId = ?1")
    Float friendshipAverage(Integer id);

    @Query("select avg(p.system) from Vote p where p.teacher.teacherId = ?1")
    Float systemAverage(Integer id);

    @Query("select avg(p.classes) from Vote p where p.teacher.teacherId = ?1")
    Float classesAverage(Integer id);

    @Query("select p.comment from Vote p where p.teacher.teacherId = ?1")
    List commentsList(Integer id);


}
