public class Farmer {

    private String name; // Stores the title/rank name of the Farmer
    private double experience; // the experience of the farmer
    private int bonusEarnings; // the bonus earnings for harvesting
    private int seedDiscount; // amount of seed cost discount
    private int waterBonus; // the water limit bonus
    private int fertilizerBonus; // the fertilizer limit bonus
    private double Objectcoins; // the money of the farmer

    public Farmer(){

        this.name = "Farmer";

        this.bonusEarnings = 0;

        this.seedDiscount = 0;

        this.waterBonus = 0;

        this.fertilizerBonus = 0;

        this.experience = 0;

        this.Objectcoins = 100;

    }


    /*
	Purpose: checks if the player has enough coins compared to cost. returns true if player Objectcoins is greater than cost, false if not.
	Returns: boolean
	@param : cost is an int containing the amount to be paid
	Pre-condition: the parameters contain valid values
    */
    public boolean hasSufficientCoins(int cost){
        if(this.Objectcoins >= cost){
            return true;
        }else{
            return false;
        }
    }

    /*
	Purpose: converts the experience of the player to level. returns the converted level.
	Returns: int
	@param : exp is a double containing the exp to be converted
	Pre-condition: the parameters contain valid values
    */
    public int getLvl(double exp){
        return (int)exp / 100;
    }

    /*
	Purpose: Checks if the player meets the requirement to level up. Levels up the player to Registered Farmer.
	Returns: void
	Pre-condition: the parameters contain valid values
    */
    public void LevelUpRegistered(){
        if(getLvl(this.experience) >= 5 && this.name.equals("Farmer") && this.Objectcoins >= 200){
            System.out.println("<Success> Leveled up to Registered Farmer. ");
            System.out.println("<Update> ObjectCoins : " + this.getObjectcoins() + " - (200)");
            this.name = "Registered Farmer";
            this.bonusEarnings = 1;
            this.seedDiscount = 1;
            this.Objectcoins -= 200;
            System.out.println("<Success> Leveled up to Registered Farmer. ");
        }else{
            System.out.println("<Failure> Failed to level up.");
        }
    }

    /*
	Purpose: Checks if the player meets the requirement to level up. Levels up the player to Distinguished Farmer.
	Returns: void
	Pre-condition: the parameters contain valid values
    */
    public void LevelUpDistinguished(){
        if(getLvl(this.experience) >= 10 && this.name.equals("Registered Farmer") && this.Objectcoins >= 300){
            System.out.println("<Success> Leveled up to Distinguished Farmer. ");
            System.out.println("<Update> ObjectCoins : " + this.getObjectcoins() + " - (300)");
            this.name = "Distinguished Farmer";
            this.bonusEarnings = 2;
            this.seedDiscount = 2;
            this.waterBonus = 1;
            this.Objectcoins -= 300;
        }else{
            System.out.println("<Failure> Failed to level up.");
        }
    }

    /*
	Purpose: Checks if the player meets the requirement to level up. Levels up the player to Legendary Farmer.
	Returns: void
	Pre-condition: the parameters contain valid values
    */
    public void LevelUpLegendary(){
        if(getLvl(this.experience) >= 15 && this.name.equals("Distinguished Farmer") && this.Objectcoins >= 400){
            System.out.println("<Success> Leveled up to Legendary Farmer. ");
            System.out.println("<Update> ObjectCoins : " + this.getObjectcoins() + " - (400)");
            this.name = "Legendary Farmer";
            this.bonusEarnings = 4;
            this.seedDiscount = 3;
            this.waterBonus = 2;
            this.fertilizerBonus = 1;
            this.Objectcoins -= 400;
        }else{
            System.out.println("<Failure> Failed to level up.");
        }
    }

    public int getWaterBonus() {
        return waterBonus;
    }

    public int getFertilizerBonus() {
        return fertilizerBonus;
    }

    public int getSeedDiscount() {
        return seedDiscount;
    }

    public void setObjectcoins(double objectcoins) {
        Objectcoins = objectcoins;
    }

    public double getObjectcoins() {
        return Objectcoins;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getExperience() {
        return experience;
    }

    public int getBonusEarnings() {
        return bonusEarnings;
    }
}

