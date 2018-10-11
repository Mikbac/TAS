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
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping(value = "/votes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Vote> allVotes() {
        return voteRepository.findAll();
    }

    @RequestMapping(value = "/votes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vote oneVotes(@PathVariable("id") int id) {
        if (id <= voteRepository.count() && id > 0) {
            return voteRepository.findOne(id);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/votes/add", method = RequestMethod.POST)
    public ResponseEntity<Vote> addVotes(@RequestBody @Valid @NotNull Vote vote) {
        voteRepository.save(vote);
        return ResponseEntity.ok().body(vote);
    }

    @RequestMapping(value = "/votes/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> editVotes(@RequestBody @Valid @NotNull Vote vote, @PathVariable("id") int id) {
        if (voteRepository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            vote.setVoteId(id);
            voteRepository.save(vote);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/votes/delete/{id}", method = RequestMethod.DELETE)
    public RedirectView deleteVotes(@PathVariable("id") int id) {
        voteRepository.delete(id);
        return new RedirectView("/votes", true);
    }
}
