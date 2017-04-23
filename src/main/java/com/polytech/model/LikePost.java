package com.polytech.model;

import javax.persistence.*;

/**
 * Created by CODING on 19/03/2017.
 */
@Entity
@Table(name = "LIKES")
public class LikePost {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "ID_POST")
    private int ID_POST;

    public LikePost(){}

    public LikePost(String username, int ID_POST) {
        this.username = username;
        this.ID_POST = ID_POST;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID_POST() {
        return ID_POST;
    }

    public void setID_POST(int ID_POST) {
        this.ID_POST = ID_POST;
    }
}
