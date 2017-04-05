package dashboard;

import dashboard.dto.Category;
import dashboard.dto.Commentary;
import dashboard.dto.Proposal;
import dashboard.dto.User;
import dashboard.persistence.*;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alex on 02/04/2017.
 * Checks the validity of the database using DAOs.
 */
public class PersistenceTest {

    @Test
    public void testProposal() {
        ProposalDao pDao = Persistence.getProposalDao();
        List<Proposal> p = pDao.getProposals();
        assertFalse(p.isEmpty());
    }

    @After


    @Test
    public void testCommentary(){
        CommentaryDao cDao = Persistence.getCommentaryDao();
        List<Commentary> c = cDao.getCommentariesFromProposalId(1);
        assertFalse(c.isEmpty());
    }

    @Test
    public void testProposal2() {
        ProposalDao pDao = Persistence.getProposalDao();
        List<Proposal> p = pDao.getProposals();
        assertFalse(p.isEmpty());
    }

    @Test
    public void testCommentary2(){
        CommentaryDao cDao = Persistence.getCommentaryDao();
        List<Commentary> c = cDao.getCommentariesFromProposalId(1);
        assertFalse(c.isEmpty());
    }

    @Test
    public void testProposal3() {
        ProposalDao pDao = Persistence.getProposalDao();
        List<Proposal> p = pDao.getProposals();
        assertFalse(p.isEmpty());
    }

    @Test
    public void testCommentary3(){
        CommentaryDao cDao = Persistence.getCommentaryDao();
        List<Commentary> c = cDao.getCommentariesFromProposalId(1);
        assertFalse(c.isEmpty());
    }

    @Test
    public void testCategory(){
        CategoryDao cDao = Persistence.getCategoryDao();
        Category category = cDao.getCategoryById(1);
        assertNotNull(category);
    }

    @Test
    public void testUser(){
        UserDao userDao = Persistence.getUserDao();
        User user= userDao.getUserById(1);
        assertNotNull(user);
    }
}
