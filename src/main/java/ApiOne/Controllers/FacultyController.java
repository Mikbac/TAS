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
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @RequestMapping(value = "/faculties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Faculty> allFaculties() {
        return facultyRepository.findAll();
    }

    @RequestMapping(value = "/faculties/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Faculty oneFaculty(@PathVariable("id") int id) {
        if (id <= facultyRepository.count() && id > 0) {
            return facultyRepository.findOne(id);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/faculties/add", method = RequestMethod.POST)
    public ResponseEntity<Faculty> addFaculty(@RequestBody @Valid @NotNull Faculty faculty) {
        facultyRepository.save(faculty);
        return ResponseEntity.ok().body(faculty);
    }

    @RequestMapping(value = "/faculties/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> editFaculty(@RequestBody @Valid @NotNull Faculty faculty, @PathVariable("id") int id) {
        if (facultyRepository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            faculty.setFacultyId(id);
            facultyRepository.save(faculty);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/faculties/delete/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteFaculty(@PathVariable("id") int id) {
        facultyRepository.delete(id);
        return new RedirectView("/faculties", true);
    }


    @RequestMapping(value = "/faculties/statistics/facultiesList/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Faculty> facultiesList(@PathVariable("id") Integer id) {
        return facultyRepository.facultiesList(id);
    }
}
