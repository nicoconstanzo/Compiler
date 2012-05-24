package compiler;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 10/05/12
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class CompleteTest {
    
    public static void main (String args[]){
        //addTest();
        //subTest();
//        mulTest();
        boolTest();

    }

    public static void addTest(){
        String a = "Hola ";
        int b = 3;
        String c = a+b;
        System.out.println(c);
    }

    public static void subTest(){
        int a = 2;
        float b = 3;
        float c = a-b;
        System.out.println(c);
    }

    public static void mulTest(){
        int a = 2;
        int b = 3;
        int c = a*b;
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
}
