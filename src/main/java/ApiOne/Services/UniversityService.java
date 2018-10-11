package ApiOne.Services;
import ApiOne.Entities.*;
public interface UniversityService {

    Iterable<University> listAllUniversities();

    University getUniversitiesById(Integer id);

    University saveUniversities(University university);

    void deleteUniversities(Integer id);

    Boolean checkIfExist(Integer id);
}
