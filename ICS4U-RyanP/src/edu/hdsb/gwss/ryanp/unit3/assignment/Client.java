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
        Manufacturer fisherPrice = new Manufacturer();
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

        // TEST #4: equals() same object
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - object equals the same object
        //      - returns true
        System.out.println("-------------------");
        System.out.println("Test #4 - equals() same object");
        boat.setManufacturer(fisherPrice);
        assert (boat.equals(boat));

        // TEST #5: equals() different object
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - object equals the same object
        //      - returns true
        System.out.println("-------------------");
        System.out.println("Test #5 - equals() different object");
        assert (!boat.equals(car));

        // TEST #6: isValid()
        // PRE-CONDTION:
        //      - valid object
        // POST-CONDTION:
        //      - returns true
        System.out.println("-------------------");
        System.out.println("Test #6 - isValid()");
        assert (boat.isValid() == true);

        // TEST #7: isValid() not valid object
        // PRE-CONDTION:
        //      - invalid object
        // POST-CONDTION:
        //      - returns false
        System.out.println("-------------------");
        System.out.println("Test #7 - isValid() not valid object");
        Toy lego = new Toy("lego", 7, 19.99);
        assert (lego.isValid() == false);

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
        assert (mattel.getFactoryID() == 2);
        assert (mattel.getName().equals("MANUFACTURER #2"));
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
        assert (hasbro.getFactoryID() == 3);
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
        assert (tonka.getFactoryID() == 4);
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

        // TEST #5: isValid() not valid object
        // PRE-CONDTION:
        //      - invalid object
        // POST-CONDTION:
        //      - returns false
        System.out.println("-------------------");
        System.out.println("Test #5 - isValid() not valid object");
        Manufacturer littleTikes = new Manufacturer("Little Tikes", 13);
        assert (littleTikes.isValid() == false);

        // TEST #6: add()
        // PRE-CONDTION:
        //      - valid object
        // POST-CONDTION:
        //      - adds toy to list
        System.out.println("-------------------");
        System.out.println("Test #6 - add() valid object");
        mattel.add(boat);
        assert (mattel.getProducts().size() == 1);
        assert (mattel.getProducts().contains(boat));

        // TEST #7: add()
        // PRE-CONDTION:
        //      - invalid object
        // POST-CONDTION:
        //      - doesn't add toy to list
        System.out.println("-------------------");
        System.out.println("Test #7 - add() invalid object");
        lego.setManufacturer(mattel);
        mattel.add(lego);
        assert (mattel.getProducts().size() == 1);

        // TEST #8: remove() valid object
        // PRE-CONDTION:
        //      - valid object
        // POST-CONDTION:
        //      - removes toy
        //      - empty array
        System.out.println("-------------------");
        System.out.println("Test #8 - remove() valid object");
        mattel.remove(boat);
        assert (mattel.getProducts().isEmpty());

        // TEST #9: remove() invald object
        // PRE-CONDTION:
        //      - re-add boat
        //      - try to remove invalid object
        // POST-CONDTION:
        //      - doesn't remove toy
        //      - array size is 1 and contains boat
        System.out.println("-------------------");
        System.out.println("Test #9 - remove() invalid object");
        mattel.add(boat);
        mattel.remove(lego);
        assert (mattel.getProducts().size() == 1);
        assert (mattel.getProducts().contains(boat));

        // TEST #10: get() valid object
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - name of toy is returned as whole object
        System.out.println("-------------------");
        System.out.println("Test #10 - get() valid object");
        assert (mattel.get("boat").equals(boat));

        // TEST #11: equals() same object
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - object equals the same object
        //      - returns true
        System.out.println("-------------------");
        System.out.println("Test #11 - equals() same object");
        assert (mattel.equals(mattel));

        // TEST #12: equals() different object
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - object equals the same object
        //      - returns true
        System.out.println("-------------------");
        System.out.println("Test #12 - equals() different object");
        assert (!mattel.equals(tonka));

    }
}
