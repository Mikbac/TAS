package ApiOne.Controllers;
import ApiOne.Entities.*;
import ApiOne.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping(value = "/teachers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Teacher> allTeachers() {
        return teacherRepository.findAll();
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Teacher oneTeacher(@PathVariable("id") int id) {
        if (id <= teacherRepository.count() && id > 0) {
            return teacherRepository.findOne(id);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public ResponseEntity<Teacher> addTeacher(@RequestBody @Valid @NotNull Teacher teacher) {
        teacherRepository.save(teacher);
        return ResponseEntity.ok().body(teacher);
    }

    @RequestMapping(value = "/teachers/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> editTeacher(@RequestBody @Valid @NotNull Teacher teacher, @PathVariable("id") int id) {
        if (teacherRepository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            teacher.setTeacherId(id);
            teacherRepository.save(teacher);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/teachers/delete/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteTeacher(@PathVariable("id") int id) {
        teacherRepository.delete(id);
        return new RedirectView("/teachers", true);
    }

    @RequestMapping(value = "/teachers/statistics/teachersList/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Teacher> teacherList(@PathVariable("id") Integer id) {
        return teacherRepository.teachersList(id);
    }

}
