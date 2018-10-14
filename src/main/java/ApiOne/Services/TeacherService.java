package ApiOne.Services;

import ApiOne.Entities.*;

public interface TeacherService {

    Iterable<Teacher> listAllTeachers();

    Teacher getTeachersById(Integer id);

    Teacher saveTeachers(Teacher teacher);

    void deleteTeachers(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Teacher> teachersList(Integer id);


}
