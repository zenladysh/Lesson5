package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nБалка "+CalcBeam.getNumBeam()+"\n ");
        CalcBeam beam1 = new CalcBeam(5.7f, 20.5f);

        System.out.println("\nБалка "+CalcBeam.getNumBeam()+"\n ");
        CalcBeam beam2 = new CalcBeam(6f, 30.2f);

        System.out.println("\nБалка "+CalcBeam.getNumBeam()+"\n ");
        CalcBeam beam3 = new CalcBeam(3.5f, 15f);

    }

}
