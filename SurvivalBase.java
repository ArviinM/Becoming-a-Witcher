import java.util.Scanner;
import java.util.Random;
class SurvivalBase implements Survival {

    //Survival Objects
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Monsters mons = new Monsters();
    Bag bag = new Bag();

    String line = "\n===========================================\n";
    String monsters [] = {"Bear", "Panther", "Wraith", "Fiend", "Drowner"};
    String [] ingredients = {"forktail spinal fluid", "mantacore poison gland"};

    //Player Variables
    int playerHealth = 100;
    int playerMaxDmg = 100;
    int healthPotions = 5;
    int healthPotionHeal = 45;

    //Enemy Variables
    int enemyEncounter = 1;
    int maxEnemyHealth = 250;
    int enemyIngDropChance = 55;

    public void startSurvival() {
        title();
        about();
        help();
        Game();
    }

    public void title() {
        System.out.println(line + "\t\tThe Trial of The Mountains " +
                "\n\t(Continuation of Becoming a Witcher) ⚔" + line +
                "\nBased on the Witcher Books and the Original Game Witcher 3 🐺" +
                "\nMade with ♥ and ☕ by Arvin M. " +
                "\nhttps://arvinrhen.me || https://github.com/ArviinM" +
                "\nFirst time players should enter *help*. 🆘");
    }

    public void about(){
        System.out.println("\nWelcome to the Trial of the Mountains!" +
                "\nThis is the final trial to test if one can survive as a witcher. — and it is as simple as it sounds. Survive. " +
                "\nIn the Mountains. The Mountains, of course, that surround Kaer Morhen, or whichever corner of the world that the Witchers have been banished to. " +
                "\nIt is dangerous, and no matter how heightened your senses, or potent your potions, the Mountains and the creatures that surround you can kill you. " +
                "\nSurvive, and you just might have a chance at being a true monster-hunting mutant, just like Geralt of Rivia.");
    }

    public void help() {
        System.out.println("\nIn this game mode, you will be able to attack monsters, drink potions, brew potions and flee." +
                "\nThese are the commands that are not given but usable in every move:" +
                "\n*help* - Open up this help panel." +
                "\n*bag* - display all items in your bag." +
                "\n*brew* - you can brew a potion if you have one." +
                "\n");
    }

    public void Game(){
        System.out.println("\nYou now headed to the mountains." +
                "\nThe path is dark, winds howling, you hear rain drops, sky is getting dark.");

        ContinueGame:
        while (enemyEncounter <= 10) {
            String enemy = monsters[rand.nextInt(monsters.length)];
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            System.out.print(line + "A " + enemy + " monster is on your way! Be careful!" + line);
            mons.setMonster(enemy);

            while(enemyHealth > 0) {
                System.out.println("\nYour HP: " + playerHealth);
                System.out.println(enemy + "'s HP: " + enemyHealth);

                while (true){
                    System.out.print("\nWhat would you like to do?" +
                            "\n*attack* - attack the enemy!" +
                            "\n*use potion* - use your health potion!" +
                            "\n*flee* - flee from the enemy!" +
                            "\n> ");

                    String input = sc.nextLine();
                    if(input.equalsIgnoreCase("attack")){
                        int damageDealt = rand.nextInt(playerMaxDmg);
                        int damageTaken = mons.getMonsterDmg();

                        enemyHealth -= damageDealt;
                        playerHealth -= damageTaken;

                        System.out.println("\nYou struck the " + enemy + " for " + damageDealt + " damage!");
                        System.out.println("You receive " + damageTaken + " in retaliation");

                        if(playerHealth < 1){
                            System.out.println("\nYou have taken much damage, sad to say that you are weak and not worthy to be a Witcher.");
                            enemyEncounter = 11;
                            enemyHealth = 0;
                            break;
                        }
                        break;
                    } else if (input.equalsIgnoreCase("use potion")) {
                        if(healthPotions >= 1){
                            playerHealth += healthPotionHeal;
                            healthPotions--;
                            System.out.println("\nYou drink a healt potion, healing yourself for " + healthPotionHeal +
                                    "\nYour now have " + playerHealth + " HP." +
                                    "\nYou only have " + healthPotions + " health potions left." );
                        } else {
                            System.out.println("You have no potions left!");
                        }
                    } else if (input.equalsIgnoreCase("flee")){
                        System.out.println("\nYou flee away from the " + enemy + "!");
                        continue ContinueGame;
                    } else if (input.equalsIgnoreCase("help")){
                        help();
                    } else if (input.equalsIgnoreCase("bag")){
                        bag.displayItems();
                    } else if (input.equalsIgnoreCase("brew")){
                        if(!bag.hasAllBrewItems()){
                            System.out.println("You successfully brewed a health potion!");
                            healthPotions++;
                            System.out.println("You now have " + healthPotions + " health potions left.");
                            bag.removeAllItems();
                        } else {
                            System.out.println("You don't have all the necessary ingredient to brew a health potion!");
                        }
                    } else {
                        System.out.println("Invalid command!");
                    }
                }
            }

            if(playerHealth <= 0){
                defeat();
                break;
            }

            System.out.println(line + "\n" + enemy + " was defeated! " +
                    "\nYou have " + playerHealth + " HP left.");
            //random drop chance for ingredients to brew.
            if(rand.nextInt(100) < enemyIngDropChance){
                if(!bag.hasItem(ingredients[0])) {
                    System.out.println("The " + enemy + " dropped a " + ingredients[0] + "!" +
                            "\nThis is useful to brew a health potion!");
                    bag.addItem(ingredients[0]);
                    bag.displayItems();
                } else if(!bag.hasItem(ingredients[1])){
                    System.out.println("The " + enemy + " dropped a " + ingredients[1] + "!" +
                            "\nThis is useful to brew a health potion!");
                    bag.addItem(ingredients[1]);
                    bag.displayItems();
                }
            }

            while(true){
                System.out.print(line + "What would you like to do now?" +
                        "\n*continue* - to fight to survive and be a witcher?" +
                        "\n*leave* - leave the mountains, and try again when you are ready?" +
                        "\n(all other commands are disabled) \n> ");

                String input = sc.nextLine();
                if(input.equalsIgnoreCase("continue")){
                    if(enemyEncounter < 10){
                        System.out.println("You continue going deeper in the Mountains! Good Luck Witcher!");
                    } else if (enemyEncounter == 10) {
                        victory();
                    }
                    enemyEncounter++;
                    break;
                } else if(input.equalsIgnoreCase("leave")){
                    System.out.println("You exit the mountains, and the other witchers felt ashamed at you but still they encourage you to fight again." +
                            "\nYou refused for now and will fight again when you are ready.");
                    //defeat
                    defeat();
                    enemyEncounter = 11;
                    break;
                } else {
                    System.out.println("Invalid command!");
                }
            }
        }
    }

    public void victory(){
        System.out.println(line + "\t\t\tVictory! 😄 🎉" + line +
                "\nYou survived with a " + playerHealth + " HP remaining! " +
                "\nCongrats! For completing this trial to become a Master Witcher." +
                "\nAnd thank you for playing this game! You are amazing!" +
                "\nYep, it is very hard! Now you know what it takes to become a Witcher!" +
                "\n\nSee you again Master Witcher!\n" +
                line + "\t\tThe Trial of The Mountains " +
                "\n\t(Continuation of Becoming a Witcher) ⚔" + line +
                "\nBased on the Witcher Books and the Original Game Witcher 3 🐺" +
                "\nMade with ♥ and ☕ by Arvin M. " +
                "\nhttps://arvinrhen.me/ || https://github.com/ArviinM");

    }

    public void defeat(){
        System.out.println(line + "\t\t\tDefeat! 😢" + line +
                "\nNooo! You have been defeated. Hey Witcher! Stand again, and fight!" +
                "\nYep, it is very hard! Now you know what it takes to become a Witcher!" +
                "\n\nRestart the program to play again! 😊\n" +
                line + "\t\tThe Trial of The Mountains " +
                "\n\t(Continuation of Becoming a Witcher) ⚔" + line +
                "\nBased on the Witcher Books and the Original Game Witcher 3 🐺" +
                "\nMade with ♥ and ☕ by Arvin M. " +
                "\nhttps://arvinrhen.me/ || https://github.com/ArviinM");
    }
}