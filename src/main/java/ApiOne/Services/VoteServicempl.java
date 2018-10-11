package ApiOne.Services;
import ApiOne.Entities.*;
import ApiOne.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
public class VoteServicempl implements VoteService{

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Iterable<Vote> listAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Vote getVotesById(Integer id) {
        return voteRepository.findOne(id);
    }

    @Override
    public Vote saveVotes(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public void deleteVotes(Integer id) {
        voteRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return voteRepository.checkIfExist(id) > 0;
    }

}
