package ApiOne.Repositories;

import ApiOne.Entities.Teacher;
import ApiOne.Entities.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface  VoteRepository extends CrudRepository<Vote, Integer>, PagingAndSortingRepository<Vote, Integer>{

    Vote findByVoteId(Integer voteId);

    @Query("select count(*) from Vote p where p.voteId = ?1")
    Integer checkIfExist(Integer voteId);

    @Query("select p from Vote p where p.teacher.teacherId = ?1")
    Iterable<Vote> votesList(Integer id);


}
