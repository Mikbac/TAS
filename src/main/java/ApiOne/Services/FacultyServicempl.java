package ApiOne.Services;

import ApiOne.Entities.*;
import ApiOne.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

public class FacultyServicempl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Iterable<Faculty> listAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultiesById(Integer id) {
        return facultyRepository.findOne(id);
    }

    @Override
    public Faculty saveFaculties(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculties(Integer id) {
        facultyRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return facultyRepository.checkIfExist(id) > 0;
    }

    @Override
    public Iterable<Faculty> facultiesList(Integer id) {
        return facultyRepository.facultiesList(id);
    }

}
