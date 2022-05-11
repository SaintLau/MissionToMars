/*
Create a Main class with the main method and start running the simulation:
 1.Create a Simulation object
 2.Load Items for Phase-1 and Phase-2
 3.Load a fleet of U1 rockets for Phase-1 and then for Phase-2
 4.Run the simulation using the fleet of U1 rockets and display the total budget required.
 5.Repeat the same for U2 rockets and display the total budget for that.
 */

import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        //create ArrayList itemsPhase1
        ArrayList <Item> itemsPhase1 = new ArrayList<>();
        //create ArrayList itemsPhase2
        ArrayList <Item> itemsPhase2 = new ArrayList<>();
        //create Simulation Object
        Simulation simulation = new Simulation();
        //declare ArrayList object fleetU1 for phase1
        ArrayList<U1>fleetU1Phase1;
        //declare ArrayList object fleetU2 for phase1
        ArrayList<U2>fleetU2Phase1;
        //declare ArrayList object fleetU1 for phase2
        ArrayList<U1>fleetU1Phase2;
        //declare ArrayList object fleetU2 for phase2
        ArrayList<U2>fleetU2Phase2;

        //load items from files
        //for Phase1
        itemsPhase1 = simulation.loadItems(itemsPhase1, 1);
        //for Phase2
        itemsPhase2 = simulation.loadItems(itemsPhase2, 2);

        //Load FLEET PHASE1
        fleetU1Phase1 = simulation.loadU1(itemsPhase1);
        int nrU1Rockets = fleetU1Phase1.size();
        System.out.println("Phase1 Fleet U1 has " + nrU1Rockets + " rockets");

        fleetU2Phase1 = simulation.loadU2(itemsPhase1);
        int nrU2Rockets = fleetU2Phase1.size();
        System.out.println("Phase1 Fleet U2 has " + nrU2Rockets + " rockets");

        //Load FLEET PHASE2
        fleetU1Phase2 = simulation.loadU1(itemsPhase2);
        nrU1Rockets = fleetU1Phase2.size();
        System.out.println("Phase2 Fleet1 has " + nrU1Rockets + " rockets");

        fleetU2Phase2 = simulation.loadU2(itemsPhase2);
        nrU2Rockets = fleetU2Phase2.size();
        System.out.println("Phase2 FleetU2 has " + nrU2Rockets + " rockets");

        //PHASE1 -> run simulation with th fleet of the U1; display budget required
        System.out.println("Simulation: Phase 1 with U1 Rockets START *****");
        int totalBudgetPhase1U1 = simulation.runSimulation(fleetU1Phase1);
        System.out.println("Simulation Phase 1 using U1 fleet: budget = $" + totalBudgetPhase1U1 + " millions");

        //PHASE2 -> run simulation with th fleet of the U1; display budget required
        System.out.println("Simulation: Phase 2 with U1 Rockets START *****");
        int totalBudgetPhase2U1 = simulation.runSimulation(fleetU1Phase2);
        System.out.println("Simulation Phase 2 using U1 fleet: budget = $" + totalBudgetPhase2U1 + " millions");

        //total budget U1
        int totalBudgetU1 = totalBudgetPhase1U1 + totalBudgetPhase2U1;
        System.out.println("Simulation with U1 rockets: total budget = $" + totalBudgetU1 + " millions");

        //PHASE1 -> run simulation with th fleet of the U2; display budget required
        System.out.println("Simulation: Phase 1 with U2 Rockets START *****");
        int totalBudgetPhase1U2 = simulation.runSimulation(fleetU2Phase1);
        System.out.println("Simulation Phase 1 using U2 fleet: budget = $" + totalBudgetPhase1U2 + " millions");

        //PHASE2 -> run simulation with th fleet of the U2; display budget required
        System.out.println("Simulation: Phase 2 with U2 Rockets START *****");
        int totalBudgetPhase2U2 = simulation.runSimulation(fleetU2Phase2);
        System.out.println("Simulation Phase 2 using U2 fleet: budget = $" + totalBudgetPhase2U2 + " millions");

        //total budget U2
        int totalBudgetU2 = totalBudgetPhase1U2 + totalBudgetPhase2U2;
        System.out.println("Simulation with U2 rockets: total budget = $" + totalBudgetU2 + " millions");
    }

}
