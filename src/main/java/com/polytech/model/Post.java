package com.polytech.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CODING on 3/13/17.
 */
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "USERNAME")
    private String username;

    @Transient
    private List<LikePost> likePosts;

    @Transient
    int nb_like;

    @Transient
    private List<Comment> comments;

    @Transient
    int nb_comments;

    public Post(){
        comments= new ArrayList<>();
        likePosts = new ArrayList<>();
    }

    public int getNb_like() {
        return nb_like;
    }

    public void setNb_like(int nb_like) {
        this.nb_like = nb_like;
    }

    public int getNb_comments() {
        return nb_comments;
    }

    public void setNb_comments(int nb_comments) {
        this.nb_comments = nb_comments;
    }

    public Post(String username, String content) {
        this.setUsername(username);
        this.setContent(content);
        comments= new ArrayList<>();
        likePosts = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<LikePost> getLikePosts() {
        return likePosts;
    }

    public void setLikePosts(List<LikePost> likePosts) {
        this.likePosts = likePosts;
        nb_like= likePosts.size();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {

        this.comments = comments;
        nb_comments=comments.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", likePosts=" + likePosts +
                ", comments=" + comments +
                '}';
    }
}
