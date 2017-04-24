package com.polytech.model;


import javax.persistence.*;

/**
 * Created by CODING on 19/03/2017.
 */
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "username")
    private String username;

    @Column(name = "ID_POST")
    private int ID_POST;

    @Transient
    int nb_cmt;
    public Comment(){}

    public int getNb_cmt() {
        return nb_cmt;
    }

    public void setNb_cmt(int nb_cmt) {
        this.nb_cmt = nb_cmt;
    }

    public Comment(String content, String username, int ID_POST) {
        this.content = content;
        this.username = username;
        this.ID_POST = ID_POST;
    }

    public int getID_POST() {
        return ID_POST;
    }

    public void setID_POST(int ID_POST) {
        this.ID_POST = ID_POST;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
