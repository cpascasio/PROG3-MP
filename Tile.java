import java.util.ArrayList;

public class Tile {
    private boolean isPlowed;

    private boolean rock;

    private Crop seed;


    public Tile(){
        this.isPlowed = false;

        this.rock = false;

        this.seed = null;
    }

    public boolean Plow(Farmer farmer){
        if(this.isPlowed){
            System.out.println("<Failed> The tile is already plowed.");
            return false;
        }else{
            this.isPlowed = true;
            System.out.println("<Success> The tile has been plowed.");
            farmer.setExperience(farmer.getExperience()+0.5);
            return true;
        }
    }

    public boolean PlantSeed(Farmer farmer, Crop seed){
        var seedCost = seed.getCost() - farmer.getSeedDiscount();
        if(this.isPlowed && this.rock == false && seed != null && farmer.hasSufficientCoins(seedCost)){
            this.seed = seed;
            farmer.setObjectcoins(farmer.getObjectcoins()-seedCost);
            System.out.println("<Success> Seed is planted.");
            return true;
        }else if(this.isPlowed == false){
            System.out.println("<Failure> Tile is not plowed.");
            return false;
        }else if(this.rock){
            System.out.println("<Failure> Tile has rock.");
            return false;
        }else{
            System.out.println("<Failure> Not enough coins.");
            return false;
        }
    }

    public boolean Water(Farmer farmer){
        if(this.seed == null){
            System.out.println("<Failed> No seed is planted.");
            return false;
        }else{
            this.seed.setWater(seed.getWater()+1);
            farmer.setExperience(farmer.getExperience()+0.5);
            return true;
        }
    }

    public boolean Fertilize(Farmer farmer){
        if(this.seed != null && farmer.hasSufficientCoins(10)){
            if(seed.getFertilizer() < seed.getFertilizerLimit()){
                seed.setFertilizer(seed.getFertilizer()+1);
            }
            System.out.println("<Success> Plant fertilized.");
            farmer.setExperience(farmer.getExperience()+4);
            farmer.setObjectcoins(farmer.getObjectcoins()-10);
            return true;
        }else if(farmer.hasSufficientCoins(10) == false){
            System.out.println("<Failed> insufficient money");
            return false;
        }else{
            System.out.println("<Failed> no seed");
            return false;
        }
    }

    public boolean Pickaxe(Farmer farmer){
        if(this.isRock() && farmer.hasSufficientCoins(50)){
            this.rock = false;
            farmer.setExperience(farmer.getExperience()+15);
            farmer.setObjectcoins(farmer.getObjectcoins()-50);
            System.out.println("<Success> Rock is removed.");
            return true;
        }else if(this.isRock() == false && farmer.hasSufficientCoins(50)){
            System.out.println("<Failed> No rock on tile.");
            return false;
        }else{
            System.out.println("<Failed> Not enough coins.");
            return false;
        }
    }

    public boolean Shovel(Farmer farmer){
        if(this.seed != null && farmer.hasSufficientCoins(7) && seed.isWithered() == false){ // withered or not
            this.seed = null;
            this.isPlowed = false;
            farmer.setExperience(farmer.getExperience()+2);
            farmer.setObjectcoins(farmer.getObjectcoins()-7);
            System.out.println("<Success> Plant has been removed.");
            return true;
        }else if(this.rock == true || this.isPlowed == false && farmer.hasSufficientCoins(7)){
            System.out.println("<Success> Tile has been shoveled. ");
            farmer.setObjectcoins(farmer.getObjectcoins()-7);
            return true;
        }else{
            System.out.println("<Failed> Not enough coins.");
            return false;
        }
    }

    public void WitherChecker(){
            if(this.seed.getDays() > this.seed.getDaysNeeded()){
               this.seed.setWithered(true);
            }else if(this.seed.getDaysNeeded() == this.seed.getDays() && this.seed.getWater() < this.seed.getWaterNeeded() || this.seed.getFertilizer() < this.seed.getFertilizerNeeded()){
                this.seed.setWithered(true);
            }
    }

    public boolean isRock() {
        return rock;
    }



    public boolean isPlowed() {
        return isPlowed;
    }

    public void setPlowed(boolean plowed) {
        isPlowed = plowed;
    }

    public Crop getSeed() {
        return seed;
    }

    public void setSeed(Crop seed) {
        this.seed = seed;
    }
}
