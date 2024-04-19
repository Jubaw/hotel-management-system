package com.tpe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_room")
public class Room {
    @Id
    private Long id;

    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private Integer capacity; //Wrappers return null


    //todo: many-to-one
    @ManyToOne() //Relation between room and hotel, adds FK(hotel_id) to room table
    @JoinColumn(name = "hotel_id", nullable = false) //optional
    private Hotel hotel;

    @OneToMany(mappedBy = "room",orphanRemoval = true)
    private List<Reservation> reservationList = new ArrayList<>();

    public Room() {
    }

    public Room(Long id, String number, Integer capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                ", reservationList=" + reservationList +
                '}';
    }
}
