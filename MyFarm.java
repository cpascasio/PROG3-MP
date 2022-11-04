import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MyFarm {

    public static Farmer f1 = new Farmer();

    public static final Scanner userInput = new Scanner(System.in);
    public static boolean Power = true;

    //public static int day = 0;
    public static ArrayList<Tile> tile = new ArrayList<Tile>(Arrays.asList(new Tile()));

    public static final ArrayList<Crop> seedList = new ArrayList<Crop>(Arrays.asList(new Crop("Turnip", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5),
            new Crop("Carrot", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5),
            new Crop("Potato", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5),
            new Crop("Rose", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5),
            new Crop("Tulips", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5),
            new Crop("Sunflower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5),
            new Crop("Mango", 10, 7, 7, 4, 4, 5, 15, 20, 8, 25),
            new Crop("Apple", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25)));



    public static void displayMainMenu(){
        System.out.println("[MAIN MENU]");
        System.out.println("(1) Farm");
        System.out.println("(2) Farmer");
        System.out.println("(0) Quit Game");
    }

    public static void displayTileMenu(){
        System.out.println("[TILE SELECT]");
        System.out.println("(0 - 49) Tiles");
        System.out.println("(50) Next Day");
        System.out.println("(51) Go Back");
    }

    public static void displayFarmingMenu(){
        System.out.println("[FARMING MENU]");
        System.out.println("(1) Plant Seed");
        System.out.println("(2) Plow");
        System.out.println("(3) Water");
        System.out.println("(4) Fertilize");
        System.out.println("(5) Pickaxe");
        System.out.println("(6) Shovel");
        System.out.println("(7) Next Day");
        System.out.println("(0) Go Back");
    }

    public static void displaySeedMenu(){
        System.out.println("[SEED MENU]");
        System.out.println("(1) Turnip");
        System.out.println("(2) Carrot");
        System.out.println("(3) Potato");
        System.out.println("(4) Rose");
        System.out.println("(5) Tulips");
        System.out.println("(6) Sunflower");
        System.out.println("(7) Mango");
        System.out.println("(8) Apple");
        System.out.println("(0) Go Back");
    }

    public static void displayFarmerMenu(){
        System.out.println("[FARMER MENU]");
        System.out.println("(1) Level Up - Registered Farmer");
        System.out.println("(2) Level Up - Distinguished Farmer");
        System.out.println("(3) Level Up - Legendary Farmer");
        System.out.println("(0) Go Back");
    }

    public static void nextDay(){
        for(Tile t : tile){
            if(t.getSeed() != null){
                t.getSeed().setDays(t.getSeed().getDays()+1);
            }
        }
    }

    public static void checkWithered(){
        for(Tile currTile : tile){
            currTile.WitherChecker();
        }
    }

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

    public static boolean endConditions(){
        int plantCounter = 0;
        for(Tile t : tile){
            if(t.getSeed().isWithered() == false){
                plantCounter++;
            }
        }
        if(plantCounter == 0 && f1.getObjectcoins() < 5-f1.getSeedDiscount()){
            return false;
        }else{
            return true;
        }
    }

    public static void performGame(){
        //var tileSelect = userInput.nextInt();

        var menuSelect = 0;
        do{
            displayMainMenu();
            System.out.print("Choose action: ");
            menuSelect = userInput.nextInt();
            switch(menuSelect){
                case 1: // Farm
                    var tileSelect = 0;
                    do{
                        checkWithered();//check if withered
                        displayTileMenu();
                        System.out.print("Choose tile/action: ");
                        tileSelect = userInput.nextInt();
                        if(tileSelect == 0){
                            //tileSelect-=1;
                            var tileAction = 0;
                            do{
                                checkWithered();
                                displayFarmingMenu();
                                System.out.print("Choose action: ");
                                // print actions
                                tileAction = userInput.nextInt();
                                switch(tileAction){
                                    case 0:
                                        System.out.println("Going back...");
                                        break;
                                    case 1: // plant seed
                                        var seedAction = 0;
                                        do {
                                            displaySeedMenu();
                                            System.out.println("Choose seed: ");
                                            // print seed list
                                            seedAction = userInput.nextInt();
                                            if(seedAction > 0 && seedAction <= seedList.size()){
                                                tile.get(tileSelect).PlantSeed(f1, seedList.get(seedAction-1));
                                            }else if(seedAction == 0){
                                                System.out.println("Going back...");
                                            }else{
                                                System.out.println("Invalid command.");
                                            }
                                        }while(seedAction != 0);
                                    case 2:
                                        tile.get(tileSelect).Plow(f1);
                                        break;
                                    case 3:
                                        tile.get(tileSelect).Water(f1);
                                        break;
                                    case 4:
                                        tile.get(tileSelect).Fertilize(f1);
                                        break;
                                    case 5:
                                        tile.get(tileSelect).Pickaxe(f1);
                                        break;
                                    case 6:
                                        tile.get(tileSelect).Shovel(f1);
                                        break;
                                    case 7:
                                        //Harvest
                                        break;
                                    case 8:
                                        System.out.println("Proceeding to next day...");
                                        nextDay();
                                        break;
                                    default:
                                        System.out.println("Invalid command.");
                                }
                            }while(tileAction != 0);
                            //tileSelect += 1;
                        }else if(tileSelect == 50){
                            System.out.println("Proceeding to next day...");
                            nextDay();
                        }else if(tileSelect == 51){
                            System.out.println("Going back...");
                        }else if(tileSelect > 0 && tileSelect < 50){
                            System.out.println("Only tile 1 is available for the demo.");
                        }else{
                            System.out.println("Invalid tile/action.");
                        }

                    }while(tileSelect != 0);
                    break;
                case 2:
                    var farmerSelect = 0;
                    do{
                        displayFarmerMenu();
                        System.out.print("Choose action: ");
                        farmerSelect = userInput.nextInt();
                        //print menu
                        switch(farmerSelect){
                            case 0:
                                System.out.println("Going back...");
                                break;
                            case 1:
                                f1.LevelUpRegistered();
                                updateSeeds();
                                break;
                            case 2:
                                f1.LevelUpDistinguished();
                                updateSeeds();
                                break;
                            case 3:
                                f1.LevelUpLegendary();
                                updateSeeds();
                                break;
                            default:
                                System.out.println("Invalid command.");
                        }
                    }while(farmerSelect != 0);
                    break;
                case 0:
                    Power = false;
                    System.out.println("Quiting Game...");
                default:
                    System.out.println("Invalid command.");
            }
        }while(Power && endConditions());

    }

    public static void main(String[] args){
        // Start game
        while(Power){ // gagawin palang yung end conditions

            performGame();

            //day++;
        }


    }

}
