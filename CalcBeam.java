package com.company;

public class CalcBeam {
    private final int DESIGN_RESISTANCE = 240000000; //Расчетное сопротивление в Па
    private final long ELASTIC_MODULE = 206000000000L; //Модуль упругости в Па
    private final float LIMIT_OF_DEFORMATION = 0.005f;//Предельные значения  прогиба балки по отношению к длине
    private final float LOAD_SAFETY_FACTOR = 1.35f;// Коэффициент надежности по нагрузке

    private static int numBeam=1;

    private float lengthBeam; //Длина балки в метрах
    private float loadBeam; //Нагрузка на балку в кПа

    public CalcBeam(float lengthBeam, float loadBeam) {
        setLengthBeam(lengthBeam);
        setLoadBeam(loadBeam);
        System.out.printf("Максимальный изгибающий момент: %.2f кН*м \n", calcBendingMoment());
        System.out.printf("Требуемый минимальный момент сопротивления: %.1f см3 \n", calcMomentOfResistance());
        System.out.printf("Требуемый минимальный момент инерции: %.1f см4 \n", calcMomentOfInertia());
        numBeam++;
    }


    public static int getNumBeam() {
        return numBeam;
    }

    public float getLengthBeam() {
        return lengthBeam;
    }

    public void setLengthBeam(float lengthBeam) {
        if (lengthBeam > 0) {
            this.lengthBeam = lengthBeam;
        } else {
            System.out.println("Проверьте длину балки");
        }
    }

    public float getLoadBeam() {
        return loadBeam;
    }

    public void setLoadBeam(float loadBeam) {
        this.loadBeam = 0;
        if (loadBeam != 0) {
            this.loadBeam = loadBeam;
        } else {
            System.out.println("Нагрузка не должна быть равна 0");
        }
    }

    private double calcBendingMoment() { //Расчет максимального изгибающего момента балки в кН/м
        float lengthBeam = getLengthBeam();
        float loadBeam = getLoadBeam();
        return loadBeam * Math.pow(lengthBeam, 2) / 8;

    }

    private double calcMomentOfResistance() { //Расчет минимального требуемого момента сопротивления в см3

        return (calcBendingMoment() * 1000 / DESIGN_RESISTANCE) * 1000000;
    }

    private double calcMomentOfInertia() {//Расчет минимального момента инерции в см4
        float lengthBeam = getLengthBeam();
        float loadBeam = getLoadBeam();
        return 5 * loadBeam * 1000 * Math.pow(lengthBeam, 3) / (384 * ELASTIC_MODULE * LIMIT_OF_DEFORMATION * LOAD_SAFETY_FACTOR) * 100000000;

    }


}