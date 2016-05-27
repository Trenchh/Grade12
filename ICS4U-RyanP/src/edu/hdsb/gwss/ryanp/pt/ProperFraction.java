/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.pt;

/**
 *
 * @author 1protheroery
 */
public class ProperFraction extends Fraction {

    public ProperFraction(int num, int den) {
        super(num, den);
        if (num < den) {
            System.out.println("Proper fraction created");
        } else {
            System.out.println("Fraction was changed to a improper fracton");
        }
    }
}
