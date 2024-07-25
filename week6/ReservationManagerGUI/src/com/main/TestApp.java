package com.main;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.manager.Address;
import com.manager.Contact;
import com.manager.Manager;
import com.manager.ReservationType;

public class TestApp {
    Manager manager;

    public TestApp(){ this.manager = new Manager();}

    public static void main(String[] args) {
        TestApp tester = new TestApp();
        
        tester.testCreateAccounts();
        tester.testCreateReservationsForAccount1();
        tester.testCreateReservationsForAccount2();
        tester.testViewReservationsForAccounts();
        tester.testLoadAndCancelReservation();
        tester.testReservationPrices();
    }

    public void testCreateAccounts() {
        

        List<Object> accountParams1 = Arrays.asList(
            new Contact(Arrays.asList("Alice", "Johnson", "alice.johnson@example.com", "555-1111")),
            new Address(Arrays.asList("123 Apple St", "Apt 1", "Springfield", "IL", "62701")),
            new Address(Arrays.asList("456 Orange St", "Suite 2", "Springfield", "IL", "62702")),
            ""
        );

        List<Object> accountParams2 = Arrays.asList(
            new Contact(Arrays.asList("Bob", "Smith", "bob.smith@example.com", "555-2222")),
            new Address(Arrays.asList("789 Pear St", "Floor 3", "Springfield", "IL", "62703")),
            new Address(Arrays.asList("101 Cherry St", "Office 4", "Springfield", "IL", "62704")),
            ""
        );

        List<Object> accountParams3 = Arrays.asList(
            new Contact(Arrays.asList("Carol", "Brown", "carol.brown@example.com", "555-3333")),
            new Address(Arrays.asList("202 Banana St", "House 5", "Springfield", "IL", "62705")),
            new Address(Arrays.asList("303 Grape St", "House 6", "Springfield", "IL", "62706")),
            ""
        );

        try {
            manager.createNewAccount();
            manager.updateObject(manager.viewCurrentAccountObject(), accountParams1);
            manager.saveObject(manager.viewCurrentAccountObject());
            System.out.println("Account 1 created successfully!");

            manager.createNewAccount();
            manager.updateObject(manager.viewCurrentAccountObject(), accountParams2);
            manager.saveObject(manager.viewCurrentAccountObject());
            System.out.println("Account 2 created successfully!");

            manager.createNewAccount();
            manager.updateObject(manager.viewCurrentAccountObject(), accountParams3);
            manager.saveObject(manager.viewCurrentAccountObject());
            System.out.println("Account 3 created successfully!");

            System.out.println("Available Accounts:");
            manager.listAllAccounts().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testCreateReservationsForAccount1() {
        
        manager.selectAccountFromAll(0);

        List<Object> reservationParamsCabin1 = Arrays.asList(
            new Address(Arrays.asList("789 Cabin Ln", "", "Springfield", "IL", "62703")),
            new Address(Arrays.asList("789 Cabin Ln", "", "Springfield", "IL", "62703")),
            new Date(),
            3,
            1,
            1,
            1,
            700,
            true,
            false
        );

        List<Object> reservationParamsHotel1 = Arrays.asList(
            new Address(Arrays.asList("123 Hotel St", "", "Springfield", "IL", "62701")),
            new Address(Arrays.asList("123 Hotel St", "", "Springfield", "IL", "62701")),
            new Date(),
            2,
            1,
            1,
            1,
            300,
            true
        );

        List<Object> reservationParamsHouse1 = Arrays.asList(
            new Address(Arrays.asList("202 House Dr", "", "Springfield", "IL", "62705")),
            new Address(Arrays.asList("202 House Dr", "", "Springfield", "IL", "62705")),
            new Date(),
            4,
            2,
            2,
            2,
            1400,
            1
        );

        try {
            System.out.println("Creating New Cabin Reservation for Account 1:");
            manager.createNewReservation(ReservationType.CABIN);
            manager.updateObject(manager.viewCurrentReservationObject(), reservationParamsCabin1);

            System.out.println("Creating New Hotel Reservation for Account 1:");
            manager.createNewReservation(ReservationType.HOTEL);
            manager.updateObject(manager.viewCurrentReservationObject(), reservationParamsHotel1);

            System.out.println("Creating New House Reservation for Account 1:");
            manager.createNewReservation(ReservationType.HOUSE);
            manager.updateObject(manager.viewCurrentReservationObject(), reservationParamsHouse1);

            System.out.println("All Reservations for Account 1:");
            manager.viewAllCurrentAccountReservations().forEach(System.out::println);
            manager.saveObject(manager.viewCurrentAccountObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testCreateReservationsForAccount2() {
        
        manager.selectAccountFromAll(1);

        List<Object> reservationParamsCabin2 = Arrays.asList(
            new Address(Arrays.asList("101 Cabin Rd", "", "Springfield", "IL", "62704")),
            new Address(Arrays.asList("101 Cabin Rd", "", "Springfield", "IL", "62704")),
            new Date(),
            7,
            3,
            3,
            3,
            1200,
            true,
            true
        );

        List<Object> reservationParamsHotel2 = Arrays.asList(
            new Address(Arrays.asList("456 Hotel Ave", "", "Springfield", "IL", "62702")),
            new Address(Arrays.asList("456 Hotel Ave", "", "Springfield", "IL", "62702")),
            new Date(),
            5,
            2,
            1,
            2,
            600,
            true
        );

        List<Object> reservationParamsHouse2 = Arrays.asList(
            new Address(Arrays.asList("303 House Blvd", "", "Springfield", "IL", "62706")),
            new Address(Arrays.asList("303 House Blvd", "", "Springfield", "IL", "62706")),
            new Date(),
            10,
            5,
            5,
            5,
            2500,
            2
        );

        try {
            System.out.println("Creating New Cabin Reservation for Account 2:");
            manager.createNewReservation(ReservationType.CABIN);
            manager.updateObject(manager.viewCurrentReservationObject(), reservationParamsCabin2);

            System.out.println("Creating New Hotel Reservation for Account 2:");
            manager.createNewReservation(ReservationType.HOTEL);
            manager.updateObject(manager.viewCurrentReservationObject(), reservationParamsHotel2);

            System.out.println("Creating New House Reservation for Account 2:");
            manager.createNewReservation(ReservationType.HOUSE);
            manager.updateObject(manager.viewCurrentReservationObject(), reservationParamsHouse2);

            System.out.println("All Reservations for Account 2:");
            manager.viewAllCurrentAccountReservations().forEach(System.out::println);
            manager.saveObject(manager.viewCurrentAccountObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testViewReservationsForAccounts() {
        

        System.out.println("Available Accounts:");
        manager.listAllAccounts().forEach(System.out::println);

        System.out.println("Viewing Reservations for Account 1:");
        manager.selectAccountFromAll(0);
        manager.viewAllCurrentAccountReservations().forEach(System.out::println);

        System.out.println("Viewing Reservations for Account 2:");
        manager.selectAccountFromAll(1);
        manager.viewAllCurrentAccountReservations().forEach(System.out::println);
    }

    public void testLoadAndCancelReservation() {
        
        manager.selectAccountFromAll(1);

        try {
            System.out.println("Loading Second Reservation for Account 2:");
            manager.selectReservationFromAll(1);
            System.out.println(manager.viewCurrentReservationObject());

            System.out.println("Attempting to Cancel Reservation:");
            manager.deleteObject(manager.viewCurrentReservationObject(), manager.getReservationId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testReservationPrices(){
        try{
            System.out.println("Calculating Prices");
            System.out.println("Total:");
            System.out.println(manager.calulateResPrice());
            System.out.println("Daily:");
            System.out.println(manager.calculateDailyPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
