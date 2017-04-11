package org.arquisoft.kafka.dashboard.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 05-Apr-17.
 */
@Component
public class Report {

    private ArrayList<Proposal> proposals;
    private List<Category> categories = new ArrayList<>();

    public Report(){}

    public Report(List<Category> categories) {
        this.categories = categories;
    }


//    public Repository() {
//        loadDatabaseData();
//    }

//    public void loadDatabaseData() {
//        ArrayList<User>  users = new ArrayList<>();
//        categories = new ArrayList<>();
//        proposals = (ArrayList<Proposal>) Persistence.getProposalDao().getProposals();
//        proposals.forEach(proposal -> {
//            proposal.setCommentaries(Persistence.getCommentaryDao()
//                    .getCommentariesFromProposalId(proposal.getId()));
//            proposal.setCategory(Persistence.getCategoryDao()
//                    .getCategoryById(proposal.getCategoryId()));
//            proposal.setUser(Persistence.getUserDao().getUserById(proposal.getUserId()));
//            proposal.getCommentaries().forEach(comment ->
//                    comment.setUser(Persistence.getUserDao().getUserById(comment.getUserId())));
//            if (!categories.contains(proposal.getCategory())) {
//                categories.add(proposal.getCategory());
//            }
//            categories.get(categories.indexOf(proposal.getCategory()))
//                    .getProposals().add(proposal);
//        });
//    }
//
//    public ArrayList<Proposal> getProposals() {
//        return proposals;
//    }
//
//    public ArrayList<Category> getCategories() {
//        return categories;
//    }
//
//    public void add(Proposal proposal) {
//        categories.forEach(category -> {
//            if (category.getId().equals(proposal.getCategoryId()))
//                category.getProposals().add(proposal);
//        });
//    }
//
//    public void add(Comment comment) {
//        categories.forEach(category -> {
//            getProposals().forEach(proposal -> {
//                if (proposal.getId().equals(comment.getProposalId()))
//                    proposal.getCommentaries().add(comment);
//            });
//        });
//    }


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(ArrayList<Proposal> proposals) {
        this.proposals = proposals;
    }
}
