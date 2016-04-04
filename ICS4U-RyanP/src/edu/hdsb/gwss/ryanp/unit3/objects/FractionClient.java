/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.objects;

/**
 *
 * @author 1protheroery
 */
public class FractionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Fraction a = new Fraction(7, 2);
        Fraction b = new Fraction(3, 4);
        Fraction c = new Fraction();

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        
    }

}
