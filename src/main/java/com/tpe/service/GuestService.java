package com.tpe.service;

import com.tpe.domain.Adress;
import com.tpe.domain.Guest;
import com.tpe.exception.GuestNotFoundException;
import com.tpe.repository.GuestRepository;

import java.util.List;
import java.util.Scanner;

public class GuestService {
    private Scanner scanner=new Scanner(System.in);

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // ödev2
    public Guest findGuestById(Long id) {
        try {
            Guest foundGuest = guestRepository.findById(id);
            if(foundGuest!=null){
                System.out.println("*-----------------------------*");
                System.out.println(foundGuest);
                return foundGuest;
            }else{
                throw new GuestNotFoundException("Guest not found with id : "+id);
            }
        }catch (GuestNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    //ödev3
    public void findAllGuest() {
        List<Guest> guests = guestRepository.findAll();
        if (!guests.isEmpty()) {
            for (Guest guest : guests) {
                System.out.println(guest);
            }
        } else {
            System.out.println("Guest not found");
        }
    }

    //9-b
    public void saveGuest() {
        Guest guest = new Guest();

        System.out.println("Enter guest name");
        guest.setName(scanner.nextLine());

        Adress adress = new Adress();

        System.out.println("Enter street");
        adress.setStreet(scanner.nextLine());

        System.out.println("Enter city");
        adress.setCity(scanner.nextLine());

        System.out.println("Enter country");
        adress.setCountry(scanner.nextLine());

        System.out.println("Enter zipcopde");
        adress.setZipcode(scanner.nextLine());

        guest.setAdress(adress);

        guestRepository.save(guest);
        System.out.println("Guest is saved successfully");

    }

    //10-b
    public void deleteGuestById(Long id) {
        Guest guestFound = findGuestById(id);
        //if guest has reservation,deletion with orphanremoval
        if (guestFound!=null){
            System.out.println(guestFound);
            System.out.println("Are you sure to delete ? Y/N");
            String select = scanner.nextLine();
            if (select.equalsIgnoreCase("y")){
                guestRepository.delete(guestFound);
            }else{
                System.out.println("Deletion aborted");
            }
        }

    }
}
