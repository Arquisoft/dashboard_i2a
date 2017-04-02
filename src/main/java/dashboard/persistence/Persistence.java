package dashboard.persistence;

import dashboard.persistence.Impl.CommentaryDaoImpl;
import dashboard.persistence.Impl.ProposalDaoImpl;

/**
 * Created by Alex on 02/04/2017.
 */
public class Persistence {

    public static ProposalDao getProposalDao() {
        return new ProposalDaoImpl();
    }

    public static CommentaryDao getCommentaryDao() {
        return new CommentaryDaoImpl();
    }
}
