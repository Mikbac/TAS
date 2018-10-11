package ApiOne.Services;
import ApiOne.Entities.*;
import ApiOne.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
public class TeacherServicempl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Iterable<Teacher> listAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeachersById(Integer id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public Teacher saveTeachers(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeachers(Integer id) {
        teacherRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return teacherRepository.checkIfExist(id) > 0;
    }
}
