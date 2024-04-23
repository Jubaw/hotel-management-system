package com.tpe.service;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import com.tpe.repository.RoomRepository;

import java.util.List;
import java.util.Scanner;


//serviceler serviceler ile iletişime geçer ve ya kendi repoları ile.
public class RoomService {
    private Scanner scanner = new Scanner(System.in);

    private final HotelService hotelService;

    private final RoomRepository roomRepository;

    //param const
    public RoomService(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }

    //4-b
    public void saveRoom() {

        Room room = new Room();

        System.out.println("Enter room ID : ");
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter room number : ");
        room.setNumber(scanner.nextLine());

        System.out.println("Enter room capacity : ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter hotel ID : ");
        Long hotelId = scanner.nextLong();
        scanner.nextLine();

        //which hotel belongs to the input ID
        Hotel foundHotel = hotelService.findHotelById(hotelId);
        if (foundHotel != null) {

            //setting this room to the hotels room list.
            room.setHotel(foundHotel);

            //foundHotel.getRooms().add(room); already been mapped by mappedby at Hotel.java,no need.

            roomRepository.save(room);//adding to the table

            System.out.println("Room is saved successfully. Room ID: " + room.getId());
        } else {
            System.out.println("Room is not saved.");
        }
    }


    //5-b: return the room given by ID and output
    public Room findRoomById(Long roomID) {
        RoomRepository roomRepository = new RoomRepository();
        List<Room> roomList = roomRepository.findAll();

        for (Room room : roomList) {
            if (room.getId().equals(roomID)) {

                System.out.println("Room: " + room);
                return room;
            }
        }
        return null;
    }

    //6-b: if table is not null, list all rooms
    public void getAllRooms() {

        List<Room> roomList = roomRepository.findAll();
        if (!roomList.isEmpty()) {
            System.out.println("----------------------------ALL ROOMS----------------------------");
            for (Room room : roomList) {
                System.out.println(room);
            }
            System.out.println("------------------------------------------------------------------");
        } else {
            System.out.println("Room list is empty.");
        }
    }


    public void deleteRoom(Long deleteRoomId) {


        Room foundRoom = findRoomById(deleteRoomId);
        if (foundRoom != null) {
            System.out.println(foundRoom);
            System.out.println("Are you sure to delete ? Y/N");
            String select = scanner.nextLine();
            if (select.equalsIgnoreCase("y")) {
                roomRepository.delete(foundRoom);
                System.out.println("Room deleted successfully");
            } else {
                System.out.println("Deletion aborted");
            }
        }


    }


}

