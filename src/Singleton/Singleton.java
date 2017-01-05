package Singleton;

/**
 * Created by Andrey on 14.12.2016.
 * Singleton - порождающий шаблон проектирования, гарантирующий,
 * что в однопоточном приложении будет единственный экземпляр класса с глобальной точкой доступа.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

     public static synchronized  Singleton getInstance() {
         if (instance == null) {
             instance = new Singleton();
         }
         return instance;
     }

    public void helloWorld() {
        System.out.println("Hello world!");
    }


    public static void main(String[] args) {

        Singleton s = getInstance();
        s.helloWorld();

    }
}
