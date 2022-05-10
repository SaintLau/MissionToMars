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
  //method ends
}
