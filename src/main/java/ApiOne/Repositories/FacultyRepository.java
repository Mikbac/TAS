package ApiOne.Repositories;

import ApiOne.Entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  FacultyRepository extends CrudRepository<Faculty, Integer>, PagingAndSortingRepository<Faculty, Integer>  {

    Faculty findByFacultyId(Integer facultyId);

    @Query("select count(*) from Faculty p where p.facultyId = ?1")
    Integer checkIfExist(Integer facultyId);

    @Query("select f from Faculty f where f.university.universityId = ?1")
    Iterable<Faculty> facultiesList(Integer id);

}
