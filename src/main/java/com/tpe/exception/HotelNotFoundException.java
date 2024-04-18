package com.tpe.exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}
//Todo: RoomNotFoundException, ReservationNotFoundException,GuestNotFoundException oluştur.