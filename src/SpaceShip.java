//SpaceShip Interface includes definitions for: launch, land, canCarry, carry (Methods)

public interface SpaceShip {
    boolean launch();               //returns true or false if rocket was launch or not
    boolean land();                 //true or false if rocket landed or crashed (not landed)
    boolean canCarry(Item cargo);  //has an argument and if rocket canCarry is true otherwise is false and rocket can't carry (weight >)
    void carry(Item cargo);        //takes an argument and checks and update the current rocket weight
}
