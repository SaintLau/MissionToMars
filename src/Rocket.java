import java.util.Random;

//Implements the SpaceShip Interface and all the methods

public class Rocket implements SpaceShip {
    int rocketCost;
    int rocketWeight;
    int rocketMaxWeight;
    int cargoCarried;
    int currentWeight;
    int cargoLimit;

    double rateExplosion;
    double rateCrash;
    double chanceLaunchExplosion;
    double chanceLandingCrash;
    double random;

    String rocketStatus;  //not loaded, loaded, exploded, launched, crashed, landed

    //Constructor
    Rocket() {
        //Start, still on land so all values are 0
        currentWeight = 0;
        cargoCarried = 0;
        chanceLaunchExplosion = 0.0; //the chance will be a % between (cargo carried / cargo limit)
        chanceLandingCrash = 0.0; //the chance will be a % between (cargo carried / cargo limit)
        cargoLimit = 0; //measure in kilograms
        rocketStatus = "Waiting for launch";
        random = new Random().nextDouble(); //generates random num between 0 and 0.99999 but never reach 1
    }

    //launched and land methods
    public boolean launch() {
        return true;
    }
    public boolean land() {
        return true;
    }

    //Carry the Item method -> true it can carry item or false it cannot carry item
    public boolean canCarry(Item cargo) {
        return (this.currentWeight + cargo.weight) <= rocketMaxWeight;
    }

    //Method that updates the weight of rocket
    public void carry(Item cargo) {
        this.currentWeight = this.currentWeight + cargo.weight;
        this.cargoCarried = this.currentWeight - this.rocketWeight;
    }

}
