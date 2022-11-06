import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Tile {
    private boolean isPlowed;

    private boolean rock;

    private Crop seed;


    public Tile(){
        this.isPlowed = false;

        this.rock = false;

        this.seed = null;
    }

    public void Plow(Farmer farmer){
        if(this.isPlowed){
            System.out.println("<Failed> The tile is already plowed.");
        }else{
            this.isPlowed = true;
            System.out.println("<Success> The tile has been plowed.");
            farmer.setExperience(farmer.getExperience()+0.5);
        }
    }

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


    public void WitherChecker(){
        if(seed != null){
            if(this.seed.getDays() > this.seed.getDaysNeeded()){
                this.seed.setWithered(true);
            }else if(this.seed.getDaysNeeded() == this.seed.getDays() && this.seed.getWater() < this.seed.getWaterNeeded() || this.seed.getFertilizer() < this.seed.getFertilizerNeeded()){
                this.seed.setWithered(true);
            }
        }
    }

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

    public void SeedUpdate(Crop seed, Farmer farmer){
        seed.setWaterLimit(seed.getWaterLimit() + farmer.getWaterBonus());
        seed.setFertilizerLimit(seed.getFertilizerLimit() + farmer.getFertilizerBonus());
    }


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

    public boolean isRock() {
        return rock;
    }

    public Crop getSeed() {
        return seed;
    }

}
