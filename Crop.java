public class Crop {

    private String name;

    private int days;

    private int daysNeeded;

    private int minimumProduce;

    private int maximumProduce;

    private int cost;

    private int sellingPrice;

    private double experienceYield;

    private int water;


    private int waterNeeded;

    private int waterLimit;

    private int fertilizer;


    private int fertilizerNeeded;

    private int fertilizerLimit;

    private boolean isWithered;

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








    //Macky
    @Override
    public String toString(){ // prints the plant's days left before harvest, current water
        return "String";
    }


    public String getName() {
        return name;
    }

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

    public void setCost(int cost) {
        this.cost = cost;
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
}
