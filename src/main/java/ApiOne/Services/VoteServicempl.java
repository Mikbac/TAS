package ApiOne.Services;
import ApiOne.Entities.*;
import ApiOne.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public Iterable<Vote> votesList(Integer id) { return voteRepository.votesList(id); }

    @Override
    public Float attractivenessAverage(Integer id) {return voteRepository.attractivenessAverage(id);}

    @Override
    public Float competencyAverage(Integer id) {return voteRepository.competencyAverage(id);}

    @Override
    public Float difficultyAverage(Integer id) {return voteRepository.difficultyAverage(id);}

    @Override
    public Float friendshipAverage(Integer id) {return voteRepository.friendshipAverage(id);}

    @Override
    public Float systemAverage(Integer id) {return voteRepository.systemAverage(id);}

    @Override
    public Float classesAverage(Integer id) {return voteRepository.classesAverage(id);}

    @Override
    public List commentsList(Integer id) {return voteRepository.commentsList(id);}

}
