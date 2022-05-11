/*
- This Rocket is light, agile and safe
- Can only carry 18 tones of cargo
- Costs $60 Million to build
- Weight: 10 tones
- Has slim change of crashing while landing
- Bigger change to explode when launching
- Crash and explosion depend on the amount of cargo carried

Specifications:
- Cost: $100 Million
- weight: 10 tones
- Max weight (with cargo): 18 tones

- chance launch explosion = 5% * (cargo carried/cargo limit)
- chance landing crash = 1% * (cargo carried/cargo limit)
 */

public class U1 extends Rocket {
    //Constructor
    U1() {
        rocketCost = 100;
        rocketWeight = 10000;
        rocketMaxWeight = 18000;
        rateExplosion = 0.49;
        rateCrash = 0.53;
        cargoLimit = rocketMaxWeight - rocketWeight;
        currentWeight = rocketWeight;
    }
    //override launch method to calculate change of explosion
    public boolean launch() {
        this.chanceLaunchExplosion = rateExplosion * ((double)cargoCarried / (double)cargoLimit);
        return !(this.chanceLaunchExplosion >= this.random);
    }
    //override launch method to calculate change of crash
    public boolean land() {
        this.chanceLandingCrash = rateCrash * ((double)cargoCarried / (double)cargoLimit);
        return !(this.chanceLandingCrash >= this.random);
    }

}
