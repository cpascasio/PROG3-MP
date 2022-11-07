/*
Name: Christan James C. Pascasio && Lawrence Mark Dural
Section : S21
References:
https://stackoverflow.com/questions/12806278/double-decimal-formatting-in-java
https://www.educative.io/answers/how-to-generate-random-numbers-in-java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MyFarm {

    public static Farmer f1 = new Farmer(); // The player's farmer level, experience, coins, and etc
    public static final Scanner userInput = new Scanner(System.in); // scanner for user input
    public static boolean Power = true; // True if the game is turned on, false if not
    public static ArrayList<Tile> tile = new ArrayList<Tile>(Arrays.asList(new Tile())); // The arraylist of tiles to plant on

    public static int day = 1; // Game days

    public static final ArrayList<Crop> seedList = new ArrayList<>(Arrays.asList(new Crop("Turnip", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5),
            new Crop("Carrot", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5),
            new Crop("Potato", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5),
            new Crop("Rose", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5),
            new Crop("Tulips", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5),
            new Crop("Sunflower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5),
            new Crop("Mango", 10, 7, 7, 4, 4, 5, 15, 20, 8, 25),
            new Crop("Apple", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25))); // the list of crops to be planted.


    /*
    Purpose: displays the Game status
    Returns: void
    Pre-condition: N/A
    */
    public static void displayGameStatus(){
        System.out.println("");
        System.out.println("Day : " + day);
        System.out.println("Farmer Level : " + f1.getLvl(f1.getExperience()));
        System.out.println("ObjectCoins : " + f1.getObjectcoins());
    }

    /*
    Purpose: displays the Main Menu
    Returns: void
    Pre-condition: N/A
    */
    public static void displayMainMenu(){
        System.out.println("");
        System.out.println("[MAIN MENU]");
        System.out.println("(1) Farm");
        System.out.println("(2) Farmer");
        System.out.println("(0) Quit Game");
    }

    /*
    Purpose: displays the Tile Menu
    Returns: void
    Pre-condition: N/A
    */
    public static void displayTileMenu(){
        System.out.println("");
        System.out.println("[TILE SELECT]");
        System.out.println("(0 - 49) Tiles");
        System.out.println("(50) Go Back");
    }

    /*
    Purpose: displays the Farming Menu
    Returns: void
    Pre-condition: N/A
    */
    public static void displayFarmingMenu(){
        System.out.println("");
        System.out.println("[FARMING MENU]");
        System.out.println("(1) Plant Seed");
        System.out.println("(2) Plow");
        System.out.println("(3) Water");
        System.out.println("(4) Fertilize - 10 ObjectCoins");
        System.out.println("(5) Pickaxe - 50 ObjectCoins");
        System.out.println("(6) Shovel - 7 ObjectCoins");
        System.out.println("(7) Next Day");
        System.out.println("(0) Go Back");
    }

    /*
    Purpose: displays the Farming Menu with Harvest Option
    Returns: void
    Pre-condition: N/A
    */
    public static void displayFarmingMenuHarvest(){
        System.out.println("");
        System.out.println("[FARMING MENU]");
        System.out.println("(1) Plant Seed");
        System.out.println("(2) Plow");
        System.out.println("(3) Water");
        System.out.println("(4) Fertilize");
        System.out.println("(5) Pickaxe");
        System.out.println("(6) Shovel");
        System.out.println("(7) Next Day");
        System.out.println("(8) Harvest");
        System.out.println("(0) Go Back");
    }

    /*
    Purpose: displays the Seed Menu or list of seeds
    Returns: void
    Pre-condition: N/A
    */
    public static void displaySeedMenu(){
        System.out.println("");
        System.out.println("[SEED MENU]");
        System.out.println("(1) Turnip - " + (seedList.get(0).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(2) Carrot - " + (seedList.get(1).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(3) Potato - " + (seedList.get(2).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(4) Rose - " + (seedList.get(3).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(5) Tulips - " + (seedList.get(4).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(6) Sunflower - " + (seedList.get(5).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(7) Mango - " + (seedList.get(6).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(8) Apple - " + (seedList.get(7).getCost() - f1.getSeedDiscount()) + " ObjectCoins");
        System.out.println("(0) Go Back");
    }

    /*
    Purpose: displays the Farmer Menu
    Returns: void
    Pre-condition: N/A
    */
    public static void displayFarmerMenu(){
        System.out.println("");
        System.out.println("[FARMER MENU]");
        System.out.println("(1) Level Up [Registered Farmer] - 200 ObjectCoins");
        System.out.println("(2) Level Up [Distinguished Farmer] - 300 ObjectCoins");
        System.out.println("(3) Level Up [Legendary Farmer] - 400 ObjectCoins");
        System.out.println("(0) Go Back");
    }

    /*
    Purpose: returns a new Crop instance of the seed parameter
    Returns: Crop
    @param: seed is a crop object that contains the seed attributes
    Pre-condition: the parameters contain valid values
    */
    public static Crop duplicateSeed(Crop seed){
        return new Crop(seed.getName(), seed.getDaysNeeded(), seed.getWaterNeeded(), seed.getWaterLimit(), seed.getFertilizerNeeded(), seed.getFertilizerLimit(), seed.getMinimumProduce(), seed.getMaximumProduce(), seed.getCost(), seed.getSellingPrice(), seed.getExperienceYield());
    }

    /*
    Purpose: increments the days attribute of the seed on each tile.
    Returns: void
    Pre-condition: N/A
    */
    public static void nextDay(){
        for(Tile t : tile){
            if(t.getSeed() != null){
                t.getSeed().setDays(t.getSeed().getDays()+1);
            }
        }
    }

    /*
    Purpose: Checks the seed of all tiles and sets their isWithered attribute to true or false depending on the WitherChecker method.
    Returns: void
    Pre-condition: N/A
    */
    public static void checkWithered(){
        int i = 0;
        for(Tile currTile : tile){
            if(currTile.WitherChecker(i)){
            }
            i++;
        }
    }

    /*
    Purpose: Checks all tiles and updates the water limit and fertilizer limit of the seed on each tile.
    Returns: void
    Pre-condition: N/A
    */
    public static void updateSeeds(){
        int seedIndex;
        for(Tile t : tile){
            if(t.getSeed() != null){
                seedIndex = findSeedIndex(t.getSeed().getName());
                if(seedIndex != -1){
                    t.SeedUpdate(seedList.get(seedIndex), f1);
                }
            }
        }
    }

    /*
    Purpose: Finds the index of the given name on the parameter, returns its index on seedList array.
    Returns: int
    @param: name is a string containing the name of the seed to find
    Pre-condition: N/A
    */
    public static int findSeedIndex(String name){
        int i = 0;
        for(Crop seed : seedList){
            if(seed.getName().equals(name)){
                return i;
            }
            i++;
        }
        return -1;
    }

    /*
    Purpose: Serves as the checker for the end conditions of the game. returns true if the end conditions/game over conditions are not met, false if end conditions are met.
    Returns: boolean
    Pre-condition: the parameters contain valid values
    */
    public static boolean endConditions(Tile tile){
        if(tile.getSeed() == null){
            return true;
        }else{
            if(tile.getSeed().isWithered() == false){
                return true;
            }else{
                return false;
            }
        }
    }

    /*
    Purpose: performs the game as a whole, contains the menus and the
    Returns: void
    Pre-condition: the parameters contain valid values
    */
    public static void performGame(){
        var menuSelect = 0;
        do{ // start of the Main Menu
            displayGameStatus();
            displayMainMenu();
            System.out.print("Choose action: ");
            menuSelect = userInput.nextInt(); // takes user input
            switch(menuSelect){ // Actions for Main Menu
                case 1: // Farm
                    var tileSelect = 0;
                    do{
                        //checkWithered(); //check if withered
                        displayGameStatus(); // display the game status
                        displayTileMenu(); // displays tile menu
                        System.out.print("Choose tile/action: ");
                        tileSelect = userInput.nextInt(); // takes user input
                        if(tileSelect == 0){
                            var tileAction = 0;
                            do{
                                if(tile.get(tileSelect).isHarvestable()){ // if the seed is ready to be harvested, enters this menu with harvest available as option.
                                    displayGameStatus(); // displays the game status
                                    tile.get(tileSelect).TileStatus();
                                    displayFarmingMenuHarvest(); // displays the farming menu with harvesst
                                    System.out.print("Choose action: ");
                                    tileAction = userInput.nextInt();
                                        switch(tileAction){
                                            case 0: // go back to previous menu
                                                System.out.println("Going back...");
                                                break;
                                            case 1: // plant seed
                                                var seedAction = 0;
                                                displayGameStatus(); // displays game status
                                                displaySeedMenu(); // displays the seed list menu
                                                System.out.print("Choose seed: ");
                                                seedAction = userInput.nextInt();
                                                if(seedAction > 0 && seedAction <= seedList.size()){
                                                    tile.get(tileSelect).PlantSeed(f1, duplicateSeed(seedList.get(seedAction-1))); // plants the seed
                                                }else if(seedAction == 0){
                                                    System.out.println("Going back...");
                                                }else{
                                                    System.out.println("Invalid command.");
                                                }
                                                break;
                                            case 2: // Plow tile
                                                tile.get(tileSelect).Plow(f1);
                                                break;
                                            case 3: // Water seed
                                                tile.get(tileSelect).Water(f1);
                                                break;
                                            case 4: // add Fertilizer to tile
                                                tile.get(tileSelect).Fertilize(f1);
                                                break;
                                            case 5: // Use Pickaxe on tile
                                                tile.get(tileSelect).Pickaxe(f1);
                                                break;
                                            case 6: // Shovel the tile
                                                tile.get(tileSelect).Shovel(f1);
                                                break;
                                            case 7: // Proceed to next day
                                                System.out.println("Proceeding to next day...");
                                                nextDay();
                                                day++;
                                                break;
                                            case 8: // Harvests the seed/plant
                                                tile.get(tileSelect).Harvest(f1);
                                                break;
                                            default:
                                                System.out.println("Invalid command.");
                                        }
                                }else{ // if the seed is not ready to be harvested. menu with not harvest option
                                    displayGameStatus(); // displays game status
                                    tile.get(tileSelect).TileStatus();
                                    displayFarmingMenu(); // displays farming menu without harvest
                                    System.out.print("Choose action: ");
                                    tileAction = userInput.nextInt(); // user input
                                    switch(tileAction){
                                        case 0: // go back to previous menu
                                            System.out.println("Going back...");
                                            break;
                                        case 1: // plant seed
                                            var seedAction = 0;
                                            displayGameStatus(); // displays game status
                                            displaySeedMenu(); // displays the seed list menu
                                            System.out.print("Choose seed: ");
                                            seedAction = userInput.nextInt(); // asks for user input
                                            if(seedAction > 0 && seedAction <= seedList.size()){
                                                tile.get(tileSelect).PlantSeed(f1, duplicateSeed(seedList.get(seedAction-1))); // plants the seed
                                            }else if(seedAction == 0){
                                                System.out.println("Going back...");
                                            }else{
                                                System.out.println("Invalid command.");
                                            }
                                            break;
                                        case 2: // Plow tile
                                            tile.get(tileSelect).Plow(f1);
                                            break;
                                        case 3: // Water seed
                                            tile.get(tileSelect).Water(f1);
                                            break;
                                        case 4: // add Fertilizer to tile
                                            tile.get(tileSelect).Fertilize(f1);
                                            break;
                                        case 5: // Use Pickaxe on tile
                                            tile.get(tileSelect).Pickaxe(f1);
                                            break;
                                        case 6: // Shovel the tile
                                            tile.get(tileSelect).Shovel(f1);
                                            break;
                                        case 7: // Proceed to next day
                                            System.out.println("Proceeding to next day...");
                                            nextDay(); // increments the days of all seeds planted.
                                            day++; // increments game day
                                            break;
                                        default:
                                            System.out.println("Invalid command.");
                                    }
                                }
                                checkWithered(); // check if seeds are withered
                            }while(tileAction != 0 && endConditions(tile.get(0)));
                        }else if(tileSelect == 50){
                            System.out.println("Going back...");
                        }else if(tileSelect > 0 && tileSelect < 50){
                            System.out.println("Only tile 1 is available for the demo.");
                        }else{
                            System.out.println("Invalid tile/action.");
                        }
                    }while(tileSelect != 50 && endConditions(tile.get(0)));
                    break;
                case 2:
                    var farmerSelect = 0;
                    do{
                        displayGameStatus(); // display game status
                        displayFarmerMenu(); // display farmer menu
                        System.out.print("Choose action: ");
                        farmerSelect = userInput.nextInt(); // asks for user input
                        switch(farmerSelect){
                            case 0: // go back to previous menu
                                System.out.println("Going back...");
                                break;
                            case 1: // level up to Registered Farmer
                                f1.LevelUpRegistered();
                                updateSeeds(); // updates the waterLimit and fertilizerLimit on all seeds based on farmer's benefits.
                                break;
                            case 2: // level up to Distinguished Farmer
                                f1.LevelUpDistinguished();
                                updateSeeds(); // updates the waterLimit and fertilizerLimit on all seeds based on farmer's benefits.
                                break;
                            case 3: // level up to Legendary Farmer
                                f1.LevelUpLegendary();
                                updateSeeds(); // updates the waterLimit and fertilizerLimit on all seeds based on farmer's benefits.
                                break;
                            default:
                                System.out.println("Invalid command.");
                        }
                    }while(farmerSelect != 0 && endConditions(tile.get(0)));
                    break;
                case 0: // quits the game
                    Power = false;
                    System.out.println("Quiting Game...");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }while(Power && endConditions(tile.get(0)));
    }

    public static void main(String[] args){
        // Start game
            performGame();
            userInput.close();
            System.out.println("GAME OVER!");
    }

}
