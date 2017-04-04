package dashboard.persistence;

import dashboard.persistence.Impl.CategoryDaoImpl;
import dashboard.persistence.Impl.CommentaryDaoImpl;
import dashboard.persistence.Impl.ProposalDaoImpl;
import dashboard.persistence.Impl.UserDaoImpl;

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
