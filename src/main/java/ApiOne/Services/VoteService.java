package ApiOne.Services;
import ApiOne.Entities.*;
public interface VoteService {

    Iterable<Vote> listAllVotes();

    Vote getVotesById(Integer id);

    Vote saveVotes(Vote vote);

    void deleteVotes(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Vote> votesList(Integer id);
}
