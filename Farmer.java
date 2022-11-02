public class Farmer {

    private String name;
    private double experience;
    private int bonusEarnings;
    private int seedDiscount;
    private int waterBonus;
    private int fertilizerBonus;

    private int Objectcoins;

    public Farmer(){

        this.name = "Farmer";

        this.bonusEarnings = 0;

        this.seedDiscount = 0;

        this.waterBonus = 0;

        this.fertilizerBonus = 0;

        this.experience = 0;

        this.Objectcoins = 100;

    }


    public boolean hasSufficientCoins(int cost){
        if(this.Objectcoins >= cost){
            return true;
        }else{
            return false;
        }
    }

    public void updateSeed(Crop seed){
        //seed.
    }

    public int getLvl(double exp){
        return (int)exp / 100;
    }

    //duplicate for other levels
    public boolean LevelUpRegistered(){
        if(getLvl(this.experience) >= 5 && this.name == "Farmer" && this.Objectcoins >= 200){
            this.name = "Registered Farmer";
            this.bonusEarnings = 1;
            this.seedDiscount = 1;
            this.Objectcoins -= 200;
            System.out.println("<Success> Leveled up to Registered Farmer. ");
            return true;
        }else{
            System.out.println("<Failure> Failed to level up.");
            return false;
        }
    }

    public boolean LevelUpDistinguished(){
        if(getLvl(this.experience) >= 10 && this.name == "Registered Farmer" && this.Objectcoins >= 300){
            this.name = "Distinguished Farmer";
            this.bonusEarnings = 2;
            this.seedDiscount = 2;
            this.waterBonus = 1;
            this.Objectcoins -= 300;
            System.out.println("<Success> Leveled up to Distinguished Farmer. ");
            return true;
        }else{
            System.out.println("<Failure> Failed to level up.");
            return false;
        }
    }

    public boolean LevelUpLegendary(){
        if(getLvl(this.experience) >= 15 && this.name == "Distinguished Farmer" && this.Objectcoins >= 400){
            this.name = "Legendary Farmer";
            this.bonusEarnings = 4;
            this.seedDiscount = 3;
            this.waterBonus = 2;
            this.fertilizerBonus = 1;
            this.Objectcoins -= 400;
            System.out.println("<Success> Leveled up to Legendary Farmer. ");
            return true;
        }else{
            System.out.println("<Failure> Failed to level up.");
            return false;
        }
    }

    public int getSeedDiscount() {
        return seedDiscount;
    }

    public void setObjectcoins(int objectcoins) {
        Objectcoins = objectcoins;
    }

    public int getObjectcoins() {
        return Objectcoins;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getExperience() {
        return experience;
    }
}

