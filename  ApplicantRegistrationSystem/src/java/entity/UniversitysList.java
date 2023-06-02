/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Administrator
 */
public class UniversitysList {

    private static University[] university = new University[5];

    static {
        university[0] = new University("Витебский государственный университет", 143.23);
        university[1] = new University("Витебский государственные технологический университет", 275.98);
        university[2] = new University("Белорусский государственный университет", 180.54);
        university[3] = new University("Белорусский государственный технологический университет", 321.2);
        university[4] = new University("Белорусский государственный медицинский университет", 399.87);
    }

    public static University[] getUniversitys() {
        return university;
    }
}
