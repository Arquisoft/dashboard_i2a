package dashboard.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Commentary {
    private Integer id;

    private String content;
    private int votes;
    private Date fecha;
    private Integer proposalId;
    private Integer userId;

    private User user;

    public Commentary() {
    }

    public Commentary(Integer idComment, String content, Integer votes, Date fecha, Integer userID,
                      Integer proposalID) {
        super();
        this.id = idComment;
        this.content = content;
        this.votes = votes;
        this.fecha = fecha;
        this.proposalId = proposalID;
        this.userId = userID;
    }

    public Commentary(String content, int votes, Date fecha, Integer proposalId, Integer usedId) {
        super();
        this.content = content;
        this.votes = votes;
        this.fecha = fecha;
        this.proposalId = proposalId;
        this.userId = usedId;
    }

    public Commentary(String content, Integer propId, Integer userId) {
        this(content, 0, new Date(), propId, userId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Date getFecha() {
        return fecha;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(this.toString());
    }

    @Override
    public String toString() {
        String simpleDate = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        return "Content: " + content + "; Votes: " + votes + "; " + "Date: " + simpleDate + "; Proposal: " + proposalId
                + "; User: " + userId;

    }
}
