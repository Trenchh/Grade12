/*
 * ICS4U.2015.16.S2
 */
package edu.hdsb.gwss.ryanp.unit1;

public class RoundOffErrorMuir {

    public static void main( String[] args ) {

       double x1 = 0.3;
        double x2 = 0.1 + 0.1 + 0.1;
        System.out.println( x1 + " == " + x2 );
        System.out.println( x1 == x2 );

        double z1 = 0.5;
        double z2 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        System.out.println( z1 + " == " + z2 );
        System.out.println( z1 == z2 );

    }

}
