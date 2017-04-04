package dashboard;

import dashboard.dto.Commentary;
import dashboard.dto.Proposal;
import dashboard.persistence.*;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 02/04/2017.
 */
public class PersistenceTest {

    @Test
    public void testProposal() {
        ProposalDao pDao = Persistence.getProposalDao();
        List<Proposal> p = pDao.getProposals();
        assertTrue(!p.isEmpty());
    }

    @After


    @Test
    public void testCommentary(){
        CommentaryDao cDao = Persistence.getCommentaryDao();
        List<Commentary> c = cDao.getCommentariesFromProposalId(1);
        assertTrue(!c.isEmpty());
    }

    @Test
    public void testProposal2() {
        ProposalDao pDao = Persistence.getProposalDao();
        List<Proposal> p = pDao.getProposals();
        assertTrue(!p.isEmpty());
    }

    @Test
    public void testCommentary2(){
        CommentaryDao cDao = Persistence.getCommentaryDao();
        List<Commentary> c = cDao.getCommentariesFromProposalId(1);
        assertTrue(!c.isEmpty());
    }

    @Test
    public void testProposal3() {
        ProposalDao pDao = Persistence.getProposalDao();
        List<Proposal> p = pDao.getProposals();
        assertTrue(!p.isEmpty());
    }

    @Test
    public void testCommentary3(){
        CommentaryDao cDao = Persistence.getCommentaryDao();
        List<Commentary> c = cDao.getCommentariesFromProposalId(1);
        assertTrue(!c.isEmpty());
    }
}
