package dashboard.persistence;

import dashboard.persistence.impl.CategoryDaoImpl;
import dashboard.persistence.impl.CommentaryDaoImpl;
import dashboard.persistence.impl.ProposalDaoImpl;
import dashboard.persistence.impl.UserDaoImpl;

/**
 * Created by Alex on 02/04/2017.
 * yes
 */
public class Persistence {

    public static ProposalDao getProposalDao() {
        return new ProposalDaoImpl();
    }

    public static CommentaryDao getCommentaryDao() {
        return new CommentaryDaoImpl();
    }

    public static CategoryDao getCategoryDao(){
        return new CategoryDaoImpl();
    }

    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
