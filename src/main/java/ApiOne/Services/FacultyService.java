package ApiOne.Services;

import ApiOne.Entities.*;

public interface  FacultyService {

    Iterable<Faculty> listAllFaculties();

    Faculty getFacultiesById(Integer id);

    Faculty saveFaculties(Faculty faculty);

    void deleteFaculties(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Faculty> facultiesList(Integer id);
}
