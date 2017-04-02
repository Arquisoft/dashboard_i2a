package dashboard.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "proposal")
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String content;
    private Long votes;

    @ManyToOne private User user_id;
    @ManyToOne private Category category_id;

    @OneToMany private Set<Commentary> commentaries = new HashSet<>();

    protected Proposal(){}

    public Proposal(String content, Long votes) {
        this.content = content;
        this.votes = votes;
    }

    public Set<Commentary> getCommentaries() {
        return new HashSet<>(commentaries);
    }

    Set<Commentary> _getCommentaries() {
        return commentaries;
    }

    protected void _setUser_id(User user_id) {
        this.user_id = user_id;
    }

    protected void _setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    this.id = id;
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

    public Category getCategory_id() {
    return category_id;
    }

    public User getUser_id() { return user_id; }

    @Override
    public String toString() {
        return "Proposal{" +
            "id=" + id +
            ", content='" + content + '\'' +
            ", votes=" + votes +
            ", user_id=" + user_id +
            ", category_id=" + category_id +
            '}';
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
        Proposal proposal = (Proposal) o;
        return Objects.equals(id, proposal.id) &&
            Objects.equals(content, proposal.content) &&
            Objects.equals(votes, proposal.votes) &&
            Objects.equals(user_id, proposal.user_id) &&
            Objects.equals(category_id, proposal.category_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, votes, user_id, category_id);
    }
}
