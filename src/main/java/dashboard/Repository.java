package dashboard;

import dashboard.dto.Category;
import dashboard.dto.Proposal;
import dashboard.dto.User;
import dashboard.persistence.Persistence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Dax on 05-Apr-17.
 */
@Component
public class Repository {

    private ArrayList<Proposal> proposals;
    private ArrayList<Category> categories;

    public Repository() {
        loadDatabaseData();
    }

    public void loadDatabaseData() {
        ArrayList<User>  users = new ArrayList<>();
        categories = new ArrayList<>();
        proposals = (ArrayList<Proposal>) Persistence.getProposalDao().getProposals();
        proposals.forEach(proposal -> {
            proposal.setCommentaries(Persistence.getCommentaryDao()
                    .getCommentariesFromProposalId(proposal.getId()));
            proposal.setCategory(Persistence.getCategoryDao()
                    .getCategoryById(proposal.getCategoryId()));
            proposal.setUser(Persistence.getUserDao().getUserById(proposal.getUserId()));
            proposal.getCommentaries().forEach(comment ->
                    comment.setUser(Persistence.getUserDao().getUserById(comment.getUserId())));
            if (!categories.contains(proposal.getCategory())) {
                categories.add(proposal.getCategory());
            }
            categories.get(categories.indexOf(proposal.getCategory()))
                    .getProposals().add(proposal);
        });
    }

    public ArrayList<Proposal> getProposals() {
        return proposals;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
