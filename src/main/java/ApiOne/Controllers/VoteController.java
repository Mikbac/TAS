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
import java.util.List;

@RestController
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping(value = "/votes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Vote> allVotes() {
        return voteRepository.findAll();
    }

    @RequestMapping(value = "/votes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vote oneVote(@PathVariable("id") int id) {
        if (id <= voteRepository.count() && id > 0) {
            return voteRepository.findOne(id);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/votes/add", method = RequestMethod.POST)
    public ResponseEntity<Vote> addVote(@RequestBody @Valid @NotNull Vote vote) {
        voteRepository.save(vote);
        return ResponseEntity.ok().body(vote);
    }

    @RequestMapping(value = "/votes/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> editVote(@RequestBody @Valid @NotNull Vote vote, @PathVariable("id") int id) {
        if (voteRepository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            vote.setVoteId(id);
            voteRepository.save(vote);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/votes/delete/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteVote(@PathVariable("id") int id) {
        voteRepository.delete(id);
        return new RedirectView("/votes", true);
    }


    @RequestMapping(value = "/votes/statistics/votesList/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Vote> votesList(@PathVariable("id") Integer id) {
            return voteRepository.votesList(id);
    }

    @RequestMapping(value = "/votes/statistics/attractivenessAverage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Float attractivenessAverage(@PathVariable("id") Integer id) {
        return voteRepository.attractivenessAverage(id);
    }

    @RequestMapping(value = "/votes/statistics/competencyAverage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Float competencyAverage(@PathVariable("id") Integer id) {
        return voteRepository.competencyAverage(id);
    }

    @RequestMapping(value = "/votes/statistics/difficultyAverage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Float difficultyAverage(@PathVariable("id") Integer id) {
        return voteRepository.difficultyAverage(id);
    }

    @RequestMapping(value = "/votes/statistics/friendshipAverage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Float friendshipAverage(@PathVariable("id") Integer id) {
        return voteRepository.friendshipAverage(id);
    }

    @RequestMapping(value = "/votes/statistics/systemAverage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Float systemAverage(@PathVariable("id") Integer id) {
        return voteRepository.systemAverage(id);
    }

    @RequestMapping(value = "/votes/statistics/classesAverage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Float classesAverage(@PathVariable("id") Integer id) {
        return voteRepository.classesAverage(id);
    }

    @RequestMapping(value = "/votes/statistics/commentsList/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List commentsList(@PathVariable("id") Integer id) {
        return voteRepository.commentsList(id);
    }


}
