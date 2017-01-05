package Main;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrey on 17.12.2016.
 */

interface A {
    int summ(int x, int y);
}
class B implements A{
    int pp = 1;
    protected int pr = 2;

    public int diff(int x, int y){return x - y;}
    public int summ(int x, int y){return x + y;}
}
class C extends B{
    public int mult(int x, int y){return x * y;}
    public int diff(int x, int y){return y - x;}

}


final class AnnotationTest {

    @interface ChangedBy {
        String author();
        long time() default 0;
    }

    @ChangedBy (author =  "neo")
    public void test() {
        @ChangedBy(author = "neo", time = 1)
        Class<?> clazz = this.getClass();
        Annotation[] annotations = clazz.getAnnotations();
    }
}



@interface MyA {};

public class Main {

    // not recommended throws ArrayIndexOutOfBoundsException
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{

        A aB = new B();
        A aC = new C();
        B bB= new B();
        B bC= new C();
        C cC = new C();


        if (  aC.summ(1,1)==2) {
            System.out.println("true");
        }
        if ( bC.diff(1,2) ==1) {
            System.out.println("true");
        }

        System.out.println(bB.pp);
        System.out.println(bB.pr);

        System.out.println(cC.pp);
        System.out.println(cC.pr);


        int[] i = {};
        Class<?> cl = Integer.class;
        System.out.println(cl);

        System.out.println(2|1);
        System.out.println(3^1);


        int[] array = new int[] {1, 2, 3};

        for(int a: array) {
            System.out.print(a + " ");
        }


        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < array.length; index++)
        {
            intList.add(array[index]);
        }

        for(int a: intList) {
            System.out.print(a + " ");
        }




        // int u = -1;
        // VM -ea
        //assert (u > 0): "U < 0";

    }
}
