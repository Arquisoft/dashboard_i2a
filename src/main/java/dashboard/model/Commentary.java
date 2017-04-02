package dashboard.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "commentary")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String content;
    private Long votes;
    private java.sql.Date fecha;
    @ManyToOne
    private User user_id;
    @ManyToOne
    private Proposal proposal_id;

    public Commentary(String content, Long votes, Date fecha) {
        this.content = content;
        this.votes = votes;
        this.fecha = fecha;
    }

    protected Commentary(){}

    public Long getId() {
    return id;
    }

    public String getContent() {
    return content;
    }

    public void setContent(String content) {
    this.content = content;
    }

    public Long getVotes() {
    return votes;
    }

    public void setVotes(Long votes) {
    this.votes = votes;
    }

    public java.sql.Date getFecha() {
    return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
    this.fecha = fecha;
    }

    public User getUser_id() {
        return user_id;
    }

    protected void _setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Proposal getProposal_id() {
        return proposal_id;
    }

    protected void _setProposal_id(Proposal proposal_id) {
        this.proposal_id = proposal_id;
    }

    @Override
    public String toString() {
        return "Commentary{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", votes=" + votes +
                ", fecha=" + fecha +
                ", user_id=" + user_id +
                ", proposal_id=" + proposal_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentary that = (Commentary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(votes, that.votes) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(user_id, that.user_id) &&
                Objects.equals(proposal_id, that.proposal_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, votes, fecha, user_id, proposal_id);
    }
}
