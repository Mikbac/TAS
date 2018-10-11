package ApiOne.Repositories;

import ApiOne.Entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  TeacherRepository  extends CrudRepository<Teacher, Integer>, PagingAndSortingRepository<Teacher, Integer>{

    Teacher findByTeacherId(Integer teacherId);

    @Query("select count(*) from  Teacher p where p.teacherId = ?1")
    Integer checkIfExist(Integer teacherId);
}
