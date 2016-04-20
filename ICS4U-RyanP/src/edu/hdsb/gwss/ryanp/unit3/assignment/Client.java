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

        Manufacturer matel = new Manufacturer("Matel");
        Manufacturer yeet = new Manufacturer();

        Toy nerfGun = new Toy("Nerf Gun");
        nerfGun.setManufacturer(matel);
        nerfGun.setAgeRange(3);

        Toy barbieDoll = new Toy("Barbie Doll");
        barbieDoll.setManufacturer(matel);

        System.out.println(nerfGun.getManufacturer().getName());
        System.out.println(barbieDoll.getManufacturer().getName());

        matel.add(nerfGun);
        matel.add(barbieDoll);

        System.out.println(matel.getProducts().size());
        System.out.println(nerfGun.toString());

        matel.remove(barbieDoll);
        System.out.println(matel.getProducts().size());

        System.out.println(matel.get(nerfGun));

        System.out.println(yeet.getName());
        matel.setLocation(4);
        System.out.println(matel.toString());

    }

}
