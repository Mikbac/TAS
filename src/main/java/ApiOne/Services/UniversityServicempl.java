package ApiOne.Services;
import ApiOne.Entities.*;
import ApiOne.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
public class UniversityServicempl implements UniversityService{

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public Iterable<University> listAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University getUniversitiesById(Integer id) {
        return universityRepository.findOne(id);
    }

    @Override
    public University saveUniversities(University university) {
        return universityRepository.save(university);
    }

    @Override
    public void deleteUniversities(Integer id) {
        universityRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return universityRepository.checkIfExist(id) > 0;
    }
}
