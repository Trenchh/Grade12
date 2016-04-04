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
public class Student {

    //CLASS CONSTANT
    private static final String SCHOOL = "Garth Webb";

    //CLASS VARIABLE
    private static int lastIDUsed = 0;

    //OBJECT/ INSTANCE VARIABLES
    private String firstName;
    private String lastName;
    private String age;
    private int oen;

    public Student() {

        this.setOen(lastIDUsed++);
        this.oen = lastIDUsed;
    }

    public Student(String firstName, String lastName, String age, int oen) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.oen = oen;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getOen() {
        return oen;
    }

    public void setOen(int oen) {
        this.oen = oen;
    }

    @Override
    public String toString() {
        return "Student{" + firstName + "," + lastName + "," + SCHOOL + "," + age + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.oen != other.oen) {
            return false;
        }
        if (this.oen == 0 || other.oen == 0) {
            return false;
        }
        return true;
    }

}
