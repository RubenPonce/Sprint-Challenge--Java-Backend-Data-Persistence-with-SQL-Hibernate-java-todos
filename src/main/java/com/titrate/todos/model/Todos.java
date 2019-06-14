package com.titrate.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="todos")
public class Todos{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;


    @Column(name = "description", nullable = false, unique = true )
    private String description;

    @Column(name = "datestarted", nullable = false)

//    @CreatedDate
//    @Temporal(TIMESTAMP)

    private String datestarted;


    @Column(name = "completed", nullable = false)
    private boolean completed = false;


//    @OneToMany(mappedBy = "todo",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JsonIgnoreProperties("todo")
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "userid", nullable = false)
@JsonIgnoreProperties({"todos", "hibernateLazyInitializer"})
private User user;




    public Todos(String description, String datestarted, User user) {
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
        this.user = user;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(String datestarted) {
        this.datestarted = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS").format(new Date(datestarted));
    }


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
