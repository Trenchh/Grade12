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
public class StudentClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Student a = new Student("Ryan", "Protheroe", "16", 1231323);
        Student b = new Student("Laqueesha", "Mercedes", "14", 2342364);
        Student c = new Student("Latoya", "Pontiac", "18", 2394723);
        Student d = new Student();
        Student e = new Student();
        Student f = new Student();

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println();
        System.out.println(d.getOen());
        System.out.println(e.getOen());
        System.out.println(f.getOen());

    }

}
