/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.assignment;

/**
 *
 * @author 1protheroery
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------------------------------
        //TOY CLASS
        //----------------------------------------------------------------------
        // TEST #1: Empty Constructor
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - isn't sold
        //      - price and age range are -1/Not Set
        //      - toyID is 1
        //      - has a name "Toy #1"
        System.out.println("-------------------");
        System.out.println("Test #1 - Empty Constructor");
        Toy gun = new Toy();
        assert (gun.getToyID() == 1);
        assert (gun.getName().equals("TOY #1"));
        assert (gun.isSold() == false);
        assert (gun.getPrice() == -1);
        assert (gun.getAgeRange() == -1);

        // TEST #2: Constructor w/ Name
        // PRE-CONDTION:
        //      - name given
        // POST-CONDTION:
        //      - isn't sold
        //      - price and age range are -1/Not Set
        //      - toyID is 2
        //      - has a name "car"
        System.out.println("-------------------");
        System.out.println("Test #2 - Constructor w/ Name");
        Toy car = new Toy("car");
        assert (car.getToyID() == 2);
        assert (car.getName().equals("CAR"));
        assert (car.isSold() == false);
        assert (car.getPrice() == -1);
        assert (car.getAgeRange() == -1);

        // TEST #3: Constructor "valid toy"
        // PRE-CONDTION:
        //      - name given
        //      - price given
        //      - ageRange given
        // POST-CONDTION:
        //      - isn't sold
        //      - price is 19.99
        //      - ageRange is 3, "KID"
        //      - toyID is 3
        //      - has a name "boat"
        System.out.println("-------------------");
        System.out.println("Test #3 - Constructor 'valid toy'");
        Toy boat = new Toy("boat", 3, 19.99);
        assert (boat.getToyID() == 3);
        assert (boat.getName().equals("BOAT"));
        assert (boat.isSold() == false);
        assert (boat.getPrice() == 19.99);
        assert (boat.getAgeRange() == 3);
        assert (boat.getAgeRangeName().equals("KID"));

        //----------------------------------------------------------------------
        //MANUFACTURER CLASS
        //----------------------------------------------------------------------
        // TEST #1: Empty Constructor
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - is in business
        //      - location is not set
        //      - factoryID is 1
        //      - has a name "MANUFACTURER #1"
        System.out.println("-------------------");
        System.out.println("Test #1 - Empty Constructor");
        Manufacturer mattel = new Manufacturer();
        assert (mattel.getFactoryID() == 1);
        assert (mattel.getName().equals("MANUFACTURER #1"));
        assert (mattel.isInBusiness() == true);
        assert (mattel.getLocation() == -1);

        // TEST #2: Constructor w/ Name
        // PRE-CONDTION:
        //      - name given
        // POST-CONDTION:
        //      - is in business
        //      - location is not set
        //      - factoryID is 2
        //      - has a name "HASBRO"
        System.out.println("-------------------");
        System.out.println("Test #2 - Constructor w/ Name");
        Manufacturer hasbro = new Manufacturer("Hasbro");
        assert (hasbro.getFactoryID() == 2);
        assert (hasbro.getName().equals("HASBRO"));
        assert (hasbro.isInBusiness() == true);
        assert (hasbro.getLocation() == -1);

        // TEST #3: Constructor 'Valid Manufacturer'
        // PRE-CONDTION:
        //      - name given
        //      - location given
        //      - factoryID given
        // POST-CONDTION:
        //      - is in business
        //      - location is not set
        //      - factoryID is 1
        //      - has a name "MANUFACTURER #1"
        System.out.println("-------------------");
        System.out.println("Test #3 - Constructor 'Valid Manufacturer'");
        Manufacturer tonka = new Manufacturer("Tonka", 3);
        assert (tonka.getFactoryID() == 3);
        assert (tonka.getName().equals("TONKA"));
        assert (tonka.isInBusiness() == true);
        assert (tonka.getLocation() == 3);

        // TEST #4: isValid()
        // PRE-CONDTION:
        //      - valid object
        // POST-CONDTION:
        //      - returns true
        System.out.println("-------------------");
        System.out.println("Test #4 - isValid()");
        assert (tonka.isValid() == true);

        // TEST #5: add()
        // PRE-CONDTION:
        //      - valid object
        // POST-CONDTION:
        //      - adds toy to list
        System.out.println("-------------------");
        System.out.println("Test #5 - add() valid object");
        boat.setManufacturer(mattel);
        mattel.add(boat);
        assert (mattel.getProducts().size() == 1);
        assert (mattel.getProducts().contains(boat));

        // TEST #5: add()
        // PRE-CONDTION:
        //      - invalid object
        // POST-CONDTION:
        //      - doesn't add toy to list
        System.out.println("-------------------");
        System.out.println("Test #5 - add() invalid object");
        Toy lego = new Toy("lego", 7, 19.99);
        lego.setManufacturer(mattel);
        mattel.add(lego);
        assert (mattel.getProducts().size() == 1);

        // TEST #6: remove()
        // PRE-CONDTION:
        //      - valid object
        // POST-CONDTION:
        //      - removes toy
        //      - empty array
        System.out.println("-------------------");
        System.out.println("Test #6 - remove() valid object");
        mattel.remove(boat);
        assert (mattel.getProducts().isEmpty());

        // TEST #7: remove()
        // PRE-CONDTION:
        //      - re-add boat
        //      - try to remove invalid object
        // POST-CONDTION:
        //      - doesn't remove toy
        //      - array size is 1 and contains boat
        System.out.println("-------------------");
        System.out.println("Test #7 - remove() invalid object");
        mattel.add(boat);
        mattel.remove(lego);
        assert (mattel.getProducts().size() == 1);
        assert (mattel.getProducts().contains(boat));
    }
}
