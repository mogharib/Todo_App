package com.MoAbdelHamied.TodoApp.Model;


import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;


public class Todos {
    @Id
    @NotNull

    private String id;
    @NotNull
    private String title;

    private  String description ;
    private Long timeStamp ;
    public Todos (){
        this.timeStamp = System.currentTimeMillis();
    }

    public Todos(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeStamp = System.currentTimeMillis();
    }

;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
