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
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @RequestMapping(value = "/universities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<University> allUniversities() {
        return universityRepository.findAll();
    }

    @RequestMapping(value = "/universities/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public University oneUniversity(@PathVariable("id") int id) {
        if (id <= universityRepository.count() && id > 0) {
            return universityRepository.findOne(id);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/universities/add", method = RequestMethod.POST)
    public ResponseEntity<University> addUniversity(@RequestBody @Valid @NotNull University university) {
        universityRepository.save(university);
        return ResponseEntity.ok().body(university);
    }

    @RequestMapping(value = "/universities/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> editUniversity(@RequestBody @Valid @NotNull University university, @PathVariable("id") int id) {
        if (universityRepository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            university.setUniversityId(id);
            universityRepository.save(university);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/universities/delete/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteUniversity(@PathVariable("id") int id) {
        universityRepository.delete(id);
        return new RedirectView("/universities", true);
    }



}
