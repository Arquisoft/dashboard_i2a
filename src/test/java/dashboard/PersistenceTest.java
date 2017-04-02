package dashboard;

import dashboard.dto.Commentary;
import dashboard.dto.Proposal;
import dashboard.persistence.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 02/04/2017.
 */
public class PersistenceTest {

    private ProposalDao pDao = Persistence.getProposalDao();
    private CommentaryDao cDao = Persistence.getCommentaryDao();

    @Test
    public void testProposal() {
        List<Proposal> p = pDao.getProposals();
        assertTrue(!p.isEmpty());
    }

    @Test
    public void testCommentary(){
        List<Commentary> c = cDao.getCommentariesFromProposalId(1);
        assertTrue(!c.isEmpty());
    }
}
