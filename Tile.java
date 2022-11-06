/*
Name: Christan James C. Pascasio && Lawrence Mark Dural
Section : S21
References:
https://stackoverflow.com/questions/12806278/double-decimal-formatting-in-java
https://www.educative.io/answers/how-to-generate-random-numbers-in-java
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Tile {
    private boolean isPlowed; // If tile is plowed or not

    private boolean rock; // If there is a rock on tile or not

    private Crop seed; // The planted seed on the tile

    /*
    Purpose: Creates a Tile instance (Constructor)
    Returns: void
    Pre-condition: N/A
    */
    public Tile(){
        this.isPlowed = false;

        this.rock = false;

        this.seed = null;
    }

    /*
	Purpose: Checks if the tile can be plowed, plows the tile and updates player's experience. Prints the feedback.
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	Pre-condition: the parameters contain valid values
    */
    public void Plow(Farmer farmer){
        if(this.isPlowed){
            System.out.println("<Failed> The tile is already plowed.");
        }else{
            this.isPlowed = true;
            System.out.println("<Success> The tile has been plowed.");
            farmer.setExperience(farmer.getExperience()+0.5);
        }
    }

    /*
	Purpose: Checks if the tile can be planted on, plants the seed given in the parameter and applies the player's water and fertilizer limit. It also updates the player's experience and coins. Prints the feedback.
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	@param : seed is a Crop object containing the water needs, fertilizer needs, days needed to harvest, and etc.
	Pre-condition: the parameters contain valid values
    */
    public void PlantSeed(Farmer farmer, Crop seed){
        var seedCost = seed.getCost() - farmer.getSeedDiscount();
        if(this.isPlowed && this.rock == false && this.seed == null && farmer.hasSufficientCoins(seedCost)){
            this.seed = seed;
            System.out.println("<Success> Seed is planted.");
            System.out.println("<Update> ObjectCoins : " + farmer.getObjectcoins() + " - (" + seedCost + ")");
            farmer.setObjectcoins(farmer.getObjectcoins()-seedCost);
            SeedUpdate(this.seed, farmer);

        }else if(this.isPlowed == false){
            System.out.println("<Failed> Tile is not plowed.");
        }else if(this.rock){
            System.out.println("<Failed> Tile has rock.");
        }else if(farmer.hasSufficientCoins(seedCost) == false){
            System.out.println("<Failed> Not enough coins.");
        }else{
            System.out.println("<Failed> A seed is already planted.");
        }

    }

    /*
	Purpose: Checks if the tile can be watered, waters the seed and updates the farmer's experience. Prints the feedback.
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	Pre-condition: the parameters contain valid values
    */
    public void Water(Farmer farmer){
        if(this.seed.isWithered()){
            System.out.println("<Failed> Plant has withered.");
        }else if(this.seed == null){
            System.out.println("<Failed> No seed is planted.");
        }else{
            if(this.seed.getWater() < seed.getWaterLimit()){
                this.seed.setWater(seed.getWater()+1);
            }
            System.out.println("<Success> Plant has been watered.");
            System.out.println("<Update> Experience : " + farmer.getExperience() + " + (0.5)");
            farmer.setExperience(farmer.getExperience()+0.5);
        }
    }

    /*
	Purpose: Checks if the tile can be fertilized, adds fertilizer to the seed and updates player's Objectcoins and experience. Prints the feedback.
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	Pre-condition: the parameters contain valid values
    */
    public void Fertilize(Farmer farmer){
        if(this.seed.isWithered()){
            System.out.println("<Failed> Plant has withered.");
        }else if(this.seed != null && farmer.hasSufficientCoins(10)){
            if(seed.getFertilizer() < seed.getFertilizerLimit()){
                seed.setFertilizer(seed.getFertilizer()+1);
            }
            System.out.println("<Success> Plant fertilized.");
            System.out.println("<Update> ObjectCoins : " + farmer.getObjectcoins() + " - (10)");
            System.out.println("<Update> Experience : " + farmer.getExperience() + " + (4)");
            farmer.setExperience(farmer.getExperience()+4);
            farmer.setObjectcoins(farmer.getObjectcoins()-10);
        }else if(farmer.hasSufficientCoins(10) == false){
            System.out.println("<Failed> insufficient money");
        }else{
            System.out.println("<Failed> no seed");
        }
    }

    /*
	Purpose: Checks if there is a rock, removes the rock and updates the player's Objectcoins and experience. Prints the feedback.
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	@param : seed is a Crop object containing the water needs, fertilizer needs, days needed to harvest, and etc.
	Pre-condition: the parameters contain valid values
    */
    public void Pickaxe(Farmer farmer){
        if(this.isRock() && farmer.hasSufficientCoins(50)){
            this.rock = false;
            System.out.println("<Success> Rock is removed.");
            System.out.println("<Update> ObjectCoins : " + farmer.getObjectcoins() + " - (50)");
            System.out.println("<Update> Experience : " + farmer.getExperience() + " + (15)");
            farmer.setExperience(farmer.getExperience()+15);
            farmer.setObjectcoins(farmer.getObjectcoins()-50);
        }else if(this.isRock() == false && farmer.hasSufficientCoins(50)){
            System.out.println("<Failed> No rock on tile.");
        }else{
            System.out.println("<Failed> Not enough coins.");
        }
    }

    /*
	Purpose: Checks the tile there is a seed. Removes the seed on the tile. Updates the player's objectcoins and experience. Prints feedback.
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	Pre-condition: the parameters contain valid values
    */
    public void Shovel(Farmer farmer){
        if(this.seed != null && farmer.hasSufficientCoins(7)){ // withered or not
            this.seed = null;
            this.isPlowed = false;
            System.out.println("<Success> Plant has been removed.");
            System.out.println("<Update> ObjectCoins : " + farmer.getObjectcoins() + " - (7)");
            System.out.println("<Update> Experience : " + farmer.getExperience() + " + (2)");
            farmer.setExperience(farmer.getExperience()+2);
            farmer.setObjectcoins(farmer.getObjectcoins()-7);

        }else if(this.rock == true || this.isPlowed == false && farmer.hasSufficientCoins(7)){
            System.out.println("<Success> Tile has been shoveled. ");
            System.out.println("<Update> ObjectCoins : " + farmer.getObjectcoins() + " - (7)");
            farmer.setObjectcoins(farmer.getObjectcoins()-7);
        }else{
            System.out.println("<Failed> Not enough coins.");
        }
    }

    /*
	Purpose: Harvests the plant/seed in the tile. Resets the plow status and seed of the tile. Updates the player's objectcoins and experience. Prints feedback.
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	Pre-condition: the parameters contain valid values
    */
    public void Harvest(Farmer farmer){
        NumberFormat formatter = new DecimalFormat("#0.0");
        int productsProduced = (int)Math.floor(Math.random()*(seed.getMaximumProduce()-seed.getMinimumProduce()+1)+seed.getMinimumProduce());
        double HarvestTotal = productsProduced * (seed.getSellingPrice() + farmer.getBonusEarnings());
        double WaterBonus = HarvestTotal * 0.2 * (seed.getWater() - 1);
        double FertilizerBonus = HarvestTotal * 0.2 * (seed.getFertilizer());
        double FinalHarvestPrice = HarvestTotal + WaterBonus + FertilizerBonus;
        System.out.println("[HARVESTED (" + seed.getName() + ")]");
        System.out.println("Products sold : " + productsProduced + "(" + HarvestTotal + ")");
        System.out.println("Harvest Total : " + HarvestTotal);
        System.out.println("Water Bonus : " + formatter.format(WaterBonus));
        System.out.println("Fertilizer Bonus : " + formatter.format(FertilizerBonus));
        System.out.println("Total Harvest Price : " + FinalHarvestPrice);
        System.out.println("<Update> ObjectCoins : " + farmer.getObjectcoins() + " + (" + FinalHarvestPrice + ")");
        System.out.println("<Update> Experience : " + farmer.getExperience() + " + (" + this.seed.getExperienceYield() + ")");
        farmer.setObjectcoins(farmer.getObjectcoins() + FinalHarvestPrice);
        farmer.setExperience(farmer.getExperience() + this.seed.getExperienceYield());
        this.isPlowed = false;
        this.seed = null;
    }


    /*
	Purpose: Checks the seed if it's not empty, checks the seed if it has withered status requirements. Updates the status of seed.
	Returns: void
	Pre-condition: N/A
    */
    public void WitherChecker(){
        if(seed != null){
            if(this.seed.getDays() > this.seed.getDaysNeeded()){
                this.seed.setWithered(true);
            }else if(this.seed.getDaysNeeded() == this.seed.getDays() && this.seed.getWater() < this.seed.getWaterNeeded() || this.seed.getFertilizer() < this.seed.getFertilizerNeeded()){
                this.seed.setWithered(true);
            }
        }
    }

    /*
	Purpose: returns true if the seed meets the harvesting requirements, false if not.
	Returns: boolean
	Pre-condition: N/A
    */
    public boolean isHarvestable(){
        if(this.seed != null){
            if(this.seed.getDays() == this.seed.getDaysNeeded() && this.seed.getWater() >= this.seed.getWaterNeeded() && this.seed.getFertilizer() >= this.seed.getFertilizerNeeded() && this.seed.isWithered() == false){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /*
	Purpose: Updates the water limit and fertilizer limit of the seed based on farmer's waterlimit bonus and fertilizer limit bonus
	Returns: void
	@param : farmer is a Farmer object containing the player's coins, experience, farmer level, and benefits.
	@param : seed is a Crop object containing the water needs, fertilizer needs, days needed to harvest, and etc.
	Pre-condition: N/A
    */
    public void SeedUpdate(Crop seed, Farmer farmer){
        this.seed.setWaterLimit(seed.getWaterLimit() + farmer.getWaterBonus());
        this.seed.setFertilizerLimit(seed.getFertilizerLimit() + farmer.getFertilizerBonus());
    }

    /*
	Purpose: displays the status of the tile.
	Returns: void
	Pre-condition: N/A
    */
    public void TileStatus(){
        System.out.println("[TILE STATUS]");
        if(seed != null){
            System.out.println("Plant : " + seed.getName());
            if(seed.isWithered()){
                System.out.println("Withered : Yes");
            }else{
                System.out.println("Withered : No");
            }
            System.out.println("Days till harvest : " + (seed.getDaysNeeded() - seed.getDays()));
            System.out.println("Current Water : " + seed.getWater());
            System.out.println("Water needed to harvest : " + seed.getWaterNeeded() + " (" + seed.getWaterLimit() + ")");
            System.out.println("Current Fertilizer : " + seed.getFertilizer());
            System.out.println("Fertilizer needed to harvest : " + seed.getFertilizerNeeded() + " (" + seed.getFertilizerLimit() + ")");
            if(seed.isWithered() == false){
                System.out.println("Days till harvest : " + (seed.getDaysNeeded() - seed.getDays()));
            }
        }else{
            if(this.isPlowed){
                System.out.println("Plowed : Yes");
            }else{
                System.out.println("Plowed : No");
            }
            if(this.rock){
                System.out.println("Rock : Yes");
            }else{
                System.out.println("Rock : No");
            }
        }
    }

    /*
	Purpose: gets the value of rock in the tile. true if there's rock, false if not.
	Returns: boolean
	Pre-condition: N/A
    */
    public boolean isRock() {
        return rock;
    }

    /*
	Purpose: returns the seed.
	Returns: Crop
	Pre-condition: N/A
    */
    public Crop getSeed() {
        return seed;
    }

}
