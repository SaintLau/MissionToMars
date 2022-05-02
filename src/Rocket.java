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
        
    }

}
