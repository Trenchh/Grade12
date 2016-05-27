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
public class MixedFraction extends Fraction {

    public MixedFraction(int n, int num, int den) {
        super(num, den);
        this.numerator = this.numerator + (this.denominator * n);
    }

}
