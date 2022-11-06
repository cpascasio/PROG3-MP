/*
Name: Christan James C. Pascasio && Lawrence Mark Dural
Section : S21
References:
https://stackoverflow.com/questions/12806278/double-decimal-formatting-in-java
https://www.educative.io/answers/how-to-generate-random-numbers-in-java
 */
public class Crop {

    private String name; // name of the seed

    private int days; // the days of the seed

    private int daysNeeded; // days needed to harvest

    private int minimumProduce; // minimum products to be produced

    private int maximumProduce; // maximum products to be produced

    private int cost; // seed cost to plant

    private int sellingPrice; // selling price of each produce

    private double experienceYield; // experience gained by player on harvest

    private int water; // amount of water


    private int waterNeeded; // amount of water needed for harvesting

    private int waterLimit; // maximum amount of water for bonus

    private int fertilizer; // amount of fertilizer


    private int fertilizerNeeded; // amount of fertilizer needed for harvesting

    private int fertilizerLimit; // maximum amount of fertilizer for bonus

    private boolean isWithered; // Withered status of the seed

    /*
	Purpose: creates a Crop object. (Constructor)
	Returns: void
	Pre-condition: the parameters contain valid values
    */

    public Crop(String name, int daysNeeded, int waterNeeded, int waterLimit, int fertilizerNeeded, int fertilizerLimit, int minimumProduce, int maximumProduce, int cost, int sellingPrice, double experienceYield){
        this.name = name;
        this.days = 0;
        this.daysNeeded = daysNeeded;
        this.water = 0;
        this.waterNeeded = waterNeeded;
        this.waterLimit = waterLimit;
        this.fertilizer = 0;
        this.fertilizerNeeded = fertilizerNeeded;
        this.fertilizerLimit = fertilizerLimit;
        this.minimumProduce = minimumProduce;
        this.maximumProduce = maximumProduce;
        this.cost = cost;
        this.sellingPrice = sellingPrice;
        this.experienceYield = experienceYield;
        this.isWithered = false;
    }


    /*
	Purpose: returns the name of the seed
	Returns: String
	Pre-condition: N/A
    */
    public String getName() {
        return name;
    }

    /*
	Purpose: returns true if plant is withered, false if not
	Returns: String
	@param boolean:
	Pre-condition: N/A
    */
    public void setWithered(boolean withered) {
        isWithered = withered;
    }

    public boolean isWithered() {
        return isWithered;
    }

    public int getWaterLimit() {
        return waterLimit;
    }

    public int getFertilizerLimit() {
        return fertilizerLimit;
    }

    public void setWaterLimit(int waterLimit) {
        this.waterLimit = waterLimit;
    }

    public void setFertilizerLimit(int fertilizerLimit) {
        this.fertilizerLimit = fertilizerLimit;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    public int getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(int fertilizer) {
        this.fertilizer = fertilizer;
    }

    public int getCost() {
        return cost;
    }

    public int getDays() {
        return days;
    }

    public int getDaysNeeded() {
        return daysNeeded;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getMinimumProduce() {
        return minimumProduce;
    }

    public int getMaximumProduce() {
        return maximumProduce;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public double getExperienceYield() {
        return experienceYield;
    }
}
