package dashboard.dto;

import java.util.List;

public class Proposal {
    private Integer id;
    private String content;
    private Integer votes;
    private Integer categoryId;
    private Integer userId;

    private Category category;
    private User user;
    private List<Commentary> commentaries;

    public Proposal() {
    }

    public Proposal(String content, Integer votes, Integer categoryId, Integer usedId) {
        super();
        this.content = content;
        this.votes = votes;
        this.categoryId = categoryId;
        this.userId = usedId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Commentary> getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(List<Commentary> commentaries) {
        this.commentaries = commentaries;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Content: " + content + "; Votes: " + votes + "; "
                + "Category: " + categoryId + "; User: " + userId;

    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(this.toString());
    }

}
