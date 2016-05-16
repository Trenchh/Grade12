package edu.hdsb.gwss.ryanp.unit5.dataStructures.HashTable;

/**
 * Simple Student Object
 */
public class Student {

    private long studentID;
    private String name;
    private String lastName;

    public Student(long studentID, String name, String lastName) {
        this.studentID = studentID;
        this.name = name;
        this.lastName = lastName;
    }

    // TO DO
    public long getKey() {
        return this.studentID;
    }

    public long getStudentID() {
        return this.studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", lastName=" + lastName + '}';
    }
}
