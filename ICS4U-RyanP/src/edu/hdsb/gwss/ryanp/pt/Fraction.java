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
public class Fraction {

    protected int numerator;
    protected int denominator;

    public Fraction(int num, int den) {
        if (den > 0) {
            this.numerator = num;
            this.denominator = den;
        }
    }

    public double size() {
        return this.numerator / this.denominator;
    }

    public Fraction larger(Fraction f) {
        if (this.size() > f.size()) {
            return this;
        } else if (this.size() == f.size()) {
            return this;
        }
        return f;
    }

    public Fraction larger(Fraction f, Fraction g) {
        if (g.size() > f.size()) {
            return g;
        } else if (g.size() == f.size()) {
            return g;
        }
        return f;
    }

    public Fraction times(Fraction f) {
        int newNum = this.numerator * f.numerator;
        int newDen = this.denominator * f.denominator;
        Fraction woo = new Fraction(newNum, newDen);
        return woo;
    }

    public Fraction times(Fraction f, Fraction g) {
        int newNum = g.numerator * f.numerator;
        int newDen = g.denominator * f.denominator;
        Fraction woo = new Fraction(newNum, newDen);
        return woo;
    }

    public void reduce() {
        this.numerator = this.numerator * gcd(this.numerator, this.denominator);
        this.denominator = this.denominator * gcd(this.numerator, this.denominator);

    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    public String toString() {
        return "Fraction{ " + this.numerator + "/" + this.denominator + " )";
    }

    public boolean equal(Fraction f) {
        if (this.size() == f.size()) {
            return true;
        }
        return false;
    }

    public void invert() {
        if (this.numerator < 0) {
            int tmp = this.numerator;
            tmp = tmp * -1;
            int tmp2 = this.denominator;
            tmp2 = tmp2 * -1;
            this.denominator = tmp;
            this.numerator = tmp2;
        } else {
            int tmp = this.numerator;
            this.numerator = this.denominator;
            this.denominator = tmp;
        }
    }

    public void toMixed() {
        if (this.numerator % this.denominator == 0) {

        }
    }

    public void toImproper() {

    }

}
