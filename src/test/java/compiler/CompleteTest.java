package compiler;

import java.sql.SQLOutput;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 10/05/12
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class CompleteTest {

    public static void main(String args[]) {
//        addTest();
//        subTest();
//        mulTest();
//        boolTest();
        greaterThanTest();
//        equalsTest();
//        lessThanTest();
//        whileTest();
//        andTest();
    }


    public static void addTest() {
        String a = "Hola ";
        int b = 3;
        String c = a + b;
        System.out.println(c);
    }

    public static void subTest() {
        int a = 2;
        float b = 3;
        float c = a - b;
        System.out.println(c);
    }

    public static void mulTest() {
        int a = 2;
        int b = 3;
        int c = a * b;
        System.out.println(c);
    }

    public static void boolTest() {
        boolean a;
        a = true;
        boolean b;
        b = false;
        boolean c;
        c = true;
    }

    public static void greaterThanIntegerTest() {
        int a = 2;
        int b = 3;
        if (a<b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void greaterThanFloatTest() {
        float a = (float) 2.4;
        float b = (float) 3.0;
        if (a<b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void greaterThanTest() {
        int a = 2;
        float b = (float) 3.0;
        if (a<b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }    }


    public static void lessThanIntegerTest() {
        int a = 2;
        int b = 3;
        if (a>b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }    }

    public static void lessThanFloatTest() {
        float a = (float) 2.4;
        float b = (float) 3.0;

        if (a>b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void lessThanTest() {
        int a = 4;
        float b = (float) 5.5;

        System.out.println(a<b);
    }

    public static void equalTest() {
        int a = 4;
        float b = (float) 5.5;
        System.out.println(a==b);
    }

    public static void equalIntegerTest() {
        int a = 2;
        int b = 3;
        System.out.println(a==b);
    }

    public static void equalFloatTest() {
        float a = (float) 2.4;
        float b = (float) 3.0;
        System.out.println(a==b);
    }

    public static void andTest() {
        int a = 2;
        int b = 2;
        int c = 4;

        if ((a == b) & c==4) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void whileTest() {

        int counter = 0;
        while (counter < 2.5f) {
            counter++;
        }
    }

    public static void ifTest() {
        int a;
        a = 2;
        int b;
        b=1;

        if (a > b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

