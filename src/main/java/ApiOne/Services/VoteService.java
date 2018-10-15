package ApiOne.Services;
import ApiOne.Entities.*;

import java.util.List;

public interface VoteService {

    Iterable<Vote> listAllVotes();

    Vote getVotesById(Integer id);

    Vote saveVotes(Vote vote);

    void deleteVotes(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Vote> votesList(Integer id);

    Float attractivenessAverage(Integer id);

    Float competencyAverage(Integer id);

    Float difficultyAverage(Integer id);

    Float friendshipAverage(Integer id);

    Float systemAverage(Integer id);

    Float classesAverage(Integer id);

    List commentsList(Integer id);


}
