/*
This class will have the following methods (according to the exercise):
- loadItems
- loadU1
- loadU2
- runSimulation

Class that will make possible to simulate the rockets behaviour
 */

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    //Constructor
    Simulation() {

    }

    /*
                    For Phase-1 TEXT
    - Method loads items for text file and returns an ARRAY
    - loadItems will be able to read the file line by line and CREATE an OBJECT for each
    - Adds them into an ArrayList
    - Method return the ArrayList
    */
    ArrayList<Item> loadItems(ArrayList<Item> phase, int phaseNr) {

        String lineRead;
        String fileName = "";

        //condition
        try {
            if (phaseNr == 1) {
                System.out.println("Load Items For Phase 1");
                fileName = "Phase-1.txt";
            } else if (phaseNr == 2) {
                System.out.println("Load Items For Phase 2");
                fileName = "Phase-2.txt";
            } else {
                System.out.println("System malfunction. Unable to load items for any Phase");
                System.out.println("PROGRAM STOP!");
                System.exit(1);
            }
            // create OBJECT for phase-x.txt -> instance
            File file = new File(fileName);
            //object scanner for object file
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                //create an Item instance for each
                Item item = new Item();
                //read the line
                lineRead = scanner.nextLine();
                //find the index of "="
                int i = lineRead.indexOf("=");
                //have the name of the item
                item.name = lineRead.substring(0, i);
                //have the weight of item
                item.weight = Integer.parseInt(lineRead.substring(i + 1));
                //Add to the ArrayList (push?)
                phase.add(item);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace(); //-> method in Java is a tool used to handle exceptions and errors. It is a method of Java’s throwable
            // class which prints the throwable along with other details like the line number and class name where the exception occurred.
        }
        return phase;  //return the ArrayList
    }
    /*
     - Method that will return the ArrayList Items that are returned by the loadItems and will start creating rocket U1.
     - First: will try to fill rocket U1 with as many items as possible before creating a new rocket object and fill it that one until
     all items are loaded
     - Method returns the ArrayList of the rockets that are fully load (for the U1).
     */
    ArrayList<U1> loadU1 (ArrayList<Item> items) {
        ArrayList<U1>fleetU1 = new ArrayList<>(); //-> create ArrayList objects for rocket U1 (fleetU1)

        //loop to load the items:
        int i = 0;
        while(i < (items.size() - 1)) { /*
                                        - size() is a specific method of the java.util.Collection which then is inherited by
                                        every data structure in standard library.
                                        - size() is a method implemented by all members of Collection (lists, sets, stacks,...).
                                        It returns the number of elements (NOT the capacity; some collections even don´t have a defined capacity)
                                        the collection contains.
                                        */
            //CREATE a new U1 rocket
            U1 u1 = new U1();
            //repeat until rocket full:
            while (u1.currentWeight <= u1.rocketMaxWeight) {
                if (items.get(i).weight > u1.cargoLimit) { //item weight > cargo limit?
                    System.out.println("Phase-1.txt item is correct " + items.get(i).name + " from line " + (i + 1)
                    + " has weight= " + items.get(i).weight + " which is heavier than the cargo limit of U1 rocket= "
                    + u1.cargoLimit);
                    System.out.print("STOP");
                    System.exit(1);
                } //end 1st if
                if(u1.canCarry(items.get(i))) { //will it carry item i?
                    u1.carry(items.get(i));    //update current rocket weight and cargo carried
                    i++;                       //next item to load
                    if(i >= items.size()) {
                        u1.rocketStatus = "loaded"; //set status to load
                        fleetU1.add(u1);            //add rocket U1 to the fleet
                        break;                      //exit loop -> all items from Phase1.txt are loaded
                    }
                }
            }
            return fleetU1; // method should return ArrayList of the U1 Rockets that are fully loaded
        }
        /*
        Same procedure but for Rocket U2.
        */

        ArrayList<U2> loadU2 (ArrayList<Item>items) {
            ArrayList<U2>fleetU2 = new ArrayList<>(); //create ArrayList object for 'fleetU2'
        int i = 0;
        while (i < (items.size() - 1)) {
            U2 u2 = new U2(); //create a new rocket U2
            while(u2.currentWeight <= u2.rocketMaxWeight) {
                if(items.get(i).weight > u2.cargoLimit) {
                    System.out.println("Phase-1.txt item is correct " + items.get(i).name + " from line " + (i + 1)
                            + " has weight= " + items.get(i).weight + " which is heavier than the cargo limit of U1 rocket= "
                            + u1.cargoLimit);
                    System.out.print("STOP");
                    System.exit(1);
                }
                if (u2.canCarry(items.get(i))) {
                    u2.carry(items.get(i));
                    i++;
                    if(i >= items.size()) {
                        u2.rocketStatus = "loaded";
                        fleetU2.add(u2);
                        break;
                    }
                }
            }
            return fleetU2;
        }
        /*
        - Method will take an ArrayList of Rockets -> will call launch and land methods for each rocket in the ArrayList
        - Everytime a Rocket explode or crash -> send rocket again
        - Need to keep track of the budget so both can go to Mars
        - runSimulation -> will return the total budget required to send all rockets (even the crashed ones)
         */

        @SuppressWarnings("uncheked"); /* used when Java generics just don't let you do what you want to,
                                          and thus, you need to explicitly specify to the compiler that whatever you are
                                          doing is legal and can be executed at the time of execution*/

        int runSimulation (ArrayList fleet) {

            int totalBudget;

            Rocket uTemp = new Rocket();

            int counterRocket = 1;

            for (int i = 0; i < fleet.size(); i++) {

                uTemp = (Rocket) fleet.get(i);
                //launch rocket
                if(uTemp.launch()) {
                    System.out.println("Rocket " + counterRocket + " has successfully launched");
                    uTemp.rocketStatus = "launched";
                //land the rocket
                if(uTemp.land()) {
                    System.out.println("Rocket " + counterRocket + " has successfully landed");
                    uTemp.rocketStatus = "landed";
                    counterRocket = counterRocket + 1;
                } else {
                    System.out.println("Rocket " + counterRocket + " has crashed at landing. Repeat launch with the same cargo.");
                    uTemp.rocketStatus = "crashed";
                    //lauch new rocket with same cargo
                    fleet = insertNewRocket(fleet, i);
                }

                } else {
                    System.out.println("Rocket " + counterRocket + " rocket exploded at launch. Repeat launch with same cargo.");
                    uTemp.rocketStatus = "exploded";
                    fleet = insertNewRocket(fleet, i);
                }
            }
            totalBudget = fleet.size() * uTemp.rocketCost;

            return totalBudget;
            }
            //Insert a new rocket loaded with same cargo:
        @SuppressWarnings("unchecked")

                private ArrayList<Rocket> insertNewRocket(ArrayList fleet, int index) {

                Rocket uTemp;
                //get rocket at index
                uTemp = (Rocket) fleet.get(index);

                //create new rocket with same values
            if(fleet.get(index) instanceof U1) {
                U1 u1New = new U1();
                //loaded
                u1New.rocketStatus = "loaded";
                //same cargo
                u1New.cargoCarried = uTemp.cargoCarried;
                //same weight
                u1New.currentWeight = uTemp.currentWeight;
                //insert new rocket at index
                fleet.add(index + 1, u1New);
            } else if (fleet.get(index) instanceof U2) {
                U2 u2New = new U2();

                u2New.rocketStatus = "loaded";
                u2New.cargoCarried = uTemp.cargoCarried;
                u2New.currentWeight = uTemp.currentWeight;
                fleet.add(index + 1, u2New);
                } else {
                System.out.println("Simulation went wrong, can't run");
                System.out.println("Program STOP");
                System.exit(2);
            }
            return fleet;
            }
        }
    }
  //"main" method ends
}
