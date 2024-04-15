package com.tpe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="t_hotel")
public class Hotel {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String locations;

    //Todo: one-to-many
    private List<Room> rooms = new ArrayList<>();

    //param const
    public Hotel(long id, String name, String locations) {
        this.id = id;
        this.name = name;
        this.locations = locations;
    }

    //Hibernate data çekerken(fetch) default constructor'ı kullanır bu sebeple oluşturmak zorundayız.
    public Hotel(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locations='" + locations + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
