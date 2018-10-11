package ApiOne.Repositories;

import ApiOne.Entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  UniversityRepository extends CrudRepository<University, Integer>, PagingAndSortingRepository<University, Integer>{

    University findByUniversityId(Integer universityId);

    @Query("select count(*) from University p where p.universityId = ?1")
    Integer checkIfExist(Integer universityId);
}
