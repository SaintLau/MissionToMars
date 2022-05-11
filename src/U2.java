/*
- This Rocket is heavy and safe
- Can carry 29 tones of cargo
- Costs $120 Million to build
- Weight: 20 tones
- Has high change of crashing while landing
- Smaller change to explode when launching
- Crash and explosion depend on the amount of cargo carried

Specifications:
- Cost: $120 Million
- weight: 18 tones
- Max weight (with cargo): 29 tones

- chance launch explosion = 4% * (cargo carried/cargo limit)
- chance landing crash = 8% * (cargo carried/cargo limit)
 */

public class U2 {
    //Constructor
    U2() {
        rocketCost = 120;
        rocketWeight = 18000;
        rocketMaxWeight = 29000;
        rateExplosion = 0.45;                // 4% rate of explosion
        rateCrash = 0.55;                    // 8% rate of crash
        cargoLimit = rocketMaxWeight - rocketWeight;
        currentWeight = rocketWeight;
    }
    public boolean launch() {
        this.chanceLaunchExplosion = rateExplosion * ((double)cargoCarried / (double) cargoLimit);
        return !(this.changeLaunchExplosion >= this.random);
    }
    public boolean land() {
        this.chanceLandingCrash = rateCrash * ((double)cargoCarried / (double) cargoLimit);
        return !(this.chanceLandingCrash >= this.random);
    }
}
