import java.util.Scanner;
import java.util.ArrayList;

public class Storage {
    ArrayList<Vehicle> arlStorage = new ArrayList<Vehicle>();
    Scanner sc = new Scanner(System.in);
    public boolean menu(){


        String strInput;
        boolean booExit = false;
        while(booExit == false){
            System.out.println("Please Choose Your preferred Service");
            System.out.println("1.Add Vehicle");
            System.out.println("2.Remove Vehicle");
            System.out.println("3.Search Vehicle");
            System.out.println("4.Show All Vehicle(s)");
            System.out.println("0.Exit");

            strInput = sc.nextLine();

            switch(strInput) {
                case "0":
                    sc.close();
                    return true;
                case "1":
                    addVehicle();
                    break;
                case "2":
                    removeVehicle();
                    break;
                case "3":
                    searchVehicle();
                    break;
                case "4":
                    listVehicle();
                    break;
                default:
                    System.out.println("This isn't an option you Dinlow");
                    break;
            }


        }
        return false;
    }

    private void addVehicle(){
        boolean booAddingVehicles = true;
        String strInput;
        String strInput2;
        Double dblInput=0.0;
        int intInput;
        String strContinue;

        while(booAddingVehicles){
            System.out.println("Please Insert the Vehicle Name:");
            strInput = sc.nextLine();

            do {
                System.out.println("Please Insert the Vehicle Specification:");
                System.out.println("1.Car, 2.Motorbike 3.Plane");
                try {
                    intInput = sc.nextInt();
                    sc.nextLine();
                }catch (Throwable e){
                    System.out.println("Please ensure value is a number.");
                    intInput = 0;
                }

            }while (!(intInput == 1 || intInput == 2 || intInput == 3));


            System.out.println("Please Insert the Vehicle Damage Type:");
            strInput2 = sc.nextLine();

            do {
                System.out.println("Please insert the repair fee:");
                while (!sc.hasNextDouble()) {

                    String input = sc.next();
                    sc.nextLine();
                    System.out.println("You must enter a valid number! Try again: ");
                }
                dblInput = sc.nextDouble();
                sc.nextLine();

            }while(dblInput < 0.0);

            if (intInput == 1){
                arlStorage.add(new Car((int)(100000+(Math.random()*100000)),strInput,strInput2, dblInput));

            }else if(intInput == 2){
                arlStorage.add(new Motorcycle((int)(200000+(Math.random()*100000)),strInput,strInput2, dblInput));

            }else if(intInput == 3){
                arlStorage.add(new Plane((int)(300000+(Math.random()*100000)),strInput,strInput2, dblInput));

            }

            do {
                System.out.println("Dow you wish to add another Vehicle? (Y/N)");
                strContinue = sc.nextLine();

            }while (!(strContinue.equals("Y") || strContinue.equals("N")));

            if (strContinue.equals("Y")){
                booAddingVehicles = true;
            }else{
                booAddingVehicles = false;
            }

        }
    }

    private void removeVehicle(){
        if (arlStorage.size() == 0){
            System.out.println("No vehicles!");
            return;
        }
        String strRemoveQueury;
        boolean booRemoving = true;

        do {
            System.out.println("Would you like to delete All Vehicles (A) or Individual Vehicles (I) (A/I)");
            strRemoveQueury = sc.nextLine();

        }while (!(strRemoveQueury.toUpperCase().equals("A") || strRemoveQueury.toUpperCase().equals("I")));

        if(strRemoveQueury.equals("A")){
            removeAll();
        }else if(strRemoveQueury.equals("I")){
            while (booRemoving == true) {
                booRemoving = removeInd();
            }
        }



    return;
    }


    private void removeAll(){
        System.out.println("Removing All...");

        System.out.println("Garage Emptied!");
        arlStorage.removeAll(arlStorage);

    }

    private boolean removeInd(){

        String strRemoveQuery;
        ArrayList<Vehicle> arlToBeDeleted = new ArrayList<Vehicle>();

        System.out.println("What is the ID of the Vehicle you wish to remove:");
        strRemoveQuery = sc.nextLine();

        for (Vehicle stored: arlStorage
             ) {
            if (strRemoveQuery.equals(Integer.toString(stored.getIntID()))){
                do {
                    System.out.println("Would You Like to Remove this Vehicle (Y/N)");
                    System.out.println(stored.toString());
                    strRemoveQuery = sc.nextLine();

                }while (!(strRemoveQuery.toUpperCase().equals("Y") || strRemoveQuery.toUpperCase().equals("N")));

                if (strRemoveQuery.toUpperCase().equals("Y")){
                    System.out.println("Prepping to Remove...");
                    arlToBeDeleted.add(stored);


                }


            }

        }

        System.out.println("Removing Vehicle");
        arlStorage.removeAll(arlToBeDeleted);

        do {
            System.out.println("Would You Like to Remove another Vehicle (Y/N)");
            strRemoveQuery = sc.nextLine();

        }while (!(strRemoveQuery.toUpperCase().equals("Y") || strRemoveQuery.equals("N")));

        if (strRemoveQuery.toUpperCase().equals("Y")){
            return true;

        }else{
            return false;
        }


    }

    private void searchVehicle(){
        if (arlStorage.size() == 0){
            System.out.println("No vehicles!");
            return;
        }
        String strSearchQuesry;
        String strTestQuesry;
        boolean booSearching = true;
        boolean booFound = false;

        while(booSearching == true) {

            System.out.println("Please input a search value:");
            strSearchQuesry = sc.nextLine();

            for (Vehicle stored : arlStorage
                    ) {

                if (strSearchQuesry.equals(stored.getStrName())|| strSearchQuesry.equals(Integer.toString(stored.getIntID()))) {
                    booFound = true;
                    System.out.println(stored.toString() + " classification:" + stored.getClass());


                    do {
                        System.out.println("Would you like to test the " + stored.getStrName() + " (Y/N)");
                        strTestQuesry = sc.nextLine();

                    }while (!(strTestQuesry.equals("Y") || strTestQuesry.equals("N")));

                    if (strTestQuesry.equals("Y")){
                        testVehicle(stored);

                    }
                    strTestQuesry="";

                    booSearching = false;

                }






            }

            if (booFound == false){
                System.out.println("No results found!");

            }

            do {
                System.out.println("Would you like to conduct a different search (Y/N)");
                strTestQuesry = sc.nextLine();

            }while (!(strTestQuesry.equals("Y") || strTestQuesry.equals("N")));

            if (strTestQuesry.equals("N")){
                booSearching = false;

            }

            booFound = false;

        }
    }


    private void listVehicle(){
        if (arlStorage.size() == 0){
            System.out.println("No vehicles!");
            return;
        }

        double dbdTotal = 0.0;
        for (Vehicle vehicle: arlStorage){
            System.out.println(vehicle.toString());
            dbdTotal += vehicle.getDblFee();

        }
        System.out.println("Total Fees £" +dbdTotal);
        System.out.println();

    }

    private void testVehicle(Vehicle test){
        System.out.println(test.testRun());
        System.out.println();
    }
}
