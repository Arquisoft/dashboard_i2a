package dashboard.persistence;

import dashboard.dto.Commentary;

import java.util.List;

/**
 * Created by Alex on 02/04/2017.
 */
public interface CommentaryDao {

    List<Commentary> getCommentariesFromProposalId(Integer id);
}
