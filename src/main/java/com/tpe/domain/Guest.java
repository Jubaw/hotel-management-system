package com.tpe.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_guest")
public class Guest {
    @Id //Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    private LocalDateTime createDate;
    //todo:

    @OneToMany (mappedBy = "guest",orphanRemoval = true)//3rd table is created for it
    private List<Reservation> reservations = new ArrayList<>();

    @Embedded
    private Adress adress;

    @PrePersist
    public void prePersist(){
        this.createDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    //todo: to be deleted
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }


    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createData=" + createDate +
                ", adress=" + adress +
                '}';
    }
}
