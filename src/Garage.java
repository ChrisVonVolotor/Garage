
import java.util.ArrayList;
import java.util.Scanner;

public class Garage {


    public static void main(String[] args) {
        boolean booExit = false;

        Storage storeage = new Storage();

        while(booExit == false){
            booExit = storeage.menu();
        }

        System.out.println();
        System.out.println("Goodbye!");
/*
        Car Car1 = new Car(1,"Mazda", "Crash", 500.75);

        ArrayList<Vehicle> arlStorage = new ArrayList<Vehicle>();

        arlStorage.add(new Car(1,"Mazda","Crash", 500.75));

       */
    }





}
