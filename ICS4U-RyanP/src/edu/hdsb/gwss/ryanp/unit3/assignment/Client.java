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
        //TOY CLASS

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
        assert (gun.getToyID() == 2);
        assert (gun.getName().equals("car"));
        assert (gun.isSold() == false);
        assert (gun.getPrice() == -1);
        assert (gun.getAgeRange() == -1);

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
        assert (gun.getToyID() == 3);
        assert (gun.getName().equals("boat"));
        assert (gun.isSold() == false);
        assert (gun.getPrice() == 19.99);
        assert (gun.getAgeRange() == 3);
        assert (gun.getAgeRangeName().equals("KID"));

        //MANUFACTURER CLASS
        
        
        // TEST #1: Empty Constructor
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - is in business
        //      - price and age range are -1/Not Set
        //      - factoryID is 1
        //      - has a name "MANUFACTURER #1"
        System.out.println("-------------------");
        System.out.println("Test #1 - Empty Constructor");
        Manufacturer matel = new Manufacturer();
        assert (matel.getFactoryID() == 1);
        assert (matel.getName().equals("MANUFACTURER #1"));
        assert (matel.isInBusiness() == true);
        assert (matel.getLocation() == -1);

    }
}
