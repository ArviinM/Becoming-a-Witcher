import java.util.Scanner;
import java.util.Random;
class StoryBase implements Story {

    Scanner sc = new Scanner(System.in);
    Bag bag = new Bag();
    Random rand = new Random();

    String line = "\n===========================================\n";

    String bedchamber = "\nThe Bed Chamber " +
            "\nThis bed chamber, narrow and wind howling. It seems to have been cleaned everyday and neat." +
            "\nThe floor is smooth and the bed is comfy. There is a chest under your bed.";
    String field = "\nThe Training Field " +
            "\nThis training field has a lot of equipments where a witcher and a witcher apprentice can train." +
            "\nMaster Witcher Geralt is waiting for you, and wants to talk to you about the choice of being a witcher." +
            "\nYou also noticed an open barrel near the castle walls.";
    String forest = "\nThe Forest" +
            "\nIn the forest, you will be able to get the necessary ingredients for you to pass the Trial of the Grasses." +
            "\nIt lurks with monsters and other mutated animals. But thanks to the Master Witchers it is cleared everyday." +
            "\nNow its your turn to get the ingredients to become a witcher!";
    String [] ingredients = {"forktail spinal fluid", "mantacore poison gland" , "albino bruxa tongue", "bryonia", "ribleaf", "mandrake root"};
    int day = 1;
    boolean finished = false;

    public void startStory() {
       // boolean running = true;
        title();
        help();
        if(!finished)
            exposition();
        if(!finished)
            theChoice();
        if(!finished)
            theTrialGrasses();
    }

    public void title(){
        System.out.println(line + "\t\t\tBecoming a Witcher ⚔" + line +
                "\nBased on the Witcher Books and the Original Game Witcher 3 🐺" +
                "\nMade with ♥ and ☕ by Arvin M. " +
                "\nhttps://arvinrhen.me || https://github.com/ArviinM" +
                "\nFirst time players should enter *help*. 🆘");
    }

    public void help() {
        System.out.println("\nIn the game, there are only two (2) choices every path. " +
                "\nThese are the commands that are not given but usable in every move: " +
                "\n*help* - Open up this help panel. " +
                "\n*examine* - Look more closely at something -- learn more about it. " +
                "\n*look* - Look around the room -- repeat the description of everything you see." +
                "\n*bag* - display all items in your bag.");
    }

    public void exposition() {
        System.out.println("\n\nYour eyes slowly opens. You see stone made for a medieval castle. " +
                "\nCandle lights everywhere. You stares at the ceiling trying to remember what happened to you. " +
                "\n\nYou are lying on the bed. Your head hurts. You slowly try to sit up. " +
                "\nYou see an old man in a witcher armor slowly lay you back in bed.");
        System.out.println(bedchamber);

        //2 choices to user
        while(true){
            System.out.print("\nWhat will you do?" +
                    "\n*talk* - to the old man and ask what happened to you. " +
                    "\n*leave* - you leave and try to get out. \n> ");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("talk")){
                //Witcher Vesemir will talk to the user
                System.out.println("\n[Vesemir: Ahh! Now you can talk. I am Master Witcher Vesemir, " +
                        "you are inside the Witcher Training School at Kaer Morhen Castle. " +
                        "\nCan you still remember why are you here?] \n\nYou said no, and your head still hurts. " +
                        "\n[Vesemir: Hmm, you should rest first child. I'll tell you everything tomorrow.] " +
                        "\n\nYou suddenly fallen asleep by the Vesemir's witcher spell.");
                break;
            } else if(input.equalsIgnoreCase("leave")){
                //Witcher Vesemir will not allow you to leave, instead talk to you.
                System.out.println("\nYou tried to get up and leave but suddenly the old man spoke. " +
                        "\n\n[Vesemir: Child, get back here you will get hurt! Can you remember why are you here?] " +
                        "\nYou said no, and asked where are you. " +
                        "\n\nVesemir: [I am Vesemir, a master witcher. " +
                        "You are inside the Witcher Training School at Kaer Morhen Castle.] " +
                        "\nYour head hurts and laydowns yourself in bed and slept.");
                break;
            } else if (input.equalsIgnoreCase("examine")) {
                System.out.println(bedchamber);
            } else if (input.equalsIgnoreCase("look")){
                if(!bag.hasItem(ingredients[2])){
                    System.out.println("\nYou look inside at the chest and found *albino bruxa tongue*.");
                    bag.addItem(ingredients[2]);
                    bag.displayItems();
                } else if (bag.hasItem(ingredients[2])){
                    System.out.println("\nChest is empty.");
                }
            } else if (input.equalsIgnoreCase("help")){
                help();
            } else if(input.equalsIgnoreCase("bag")){
                bag.displayItems();
            } else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public void theChoice() {
        System.out.println("\nThe next day..." +
                "\n\nYou woke up early in the morning getting prepared suiting up your apprentice armor. Your head still hurts." +
                "\nYou asked yourself why you are getting prepared, and suddenly remembers what happened to yourself. " +
                "\nYou were bullied by the other witcher apprentice and your head was stroked by a training sword. " +
                "\nYou walk down to the stairs from the bed chambers to the training field. You also saw Witcher Vesemir is busy doing alchemy work.");
        while(true){
            //two choices and another 2 choices, one will continue the game and one will end the game.
            System.out.print("\nWhat will you do?" +
                    "\n*talk* - to Master Witcher Geralt about the choice? " +
                    "\n*ignore* - and forgot about the choice. \n> ");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("talk")){
                System.out.println("\n[Geralt: Kid! How are you? Are you feeling alright now? I've already dealt the apprentices that bullied you." +
                        "\nDon't worry about them, those foolishness is not worthy to be a witcher.] " +
                        "\n\nYou said you are grateful to him, and ask Geralt what does it takes to be a Witcher?" +
                        "\n\n[Geralt: AGAIN?(shouted and annoyed then calms down) Alright kid, but this is the last time I will talk about this alright?]" +
                        "\nYou agreed and let him continue." +
                        "\n[Geralt: To become a witcher, it starts with your choice without hesitation and regrets to be a witcher." +
                        "\nYour choice is the importantn step to become one of us. One cannot progress unless they make the choice to do so." +
                        "\n\nNext is, The Trial of the Grasses is an impossibly painful and dangerous alchemical experiment that breaks down the body. " +
                        "\nWhoever is subjected to The Trial of the Grasses is strapped to a table and forced to drink a series of dangerous chemicals. " +
                        "\nOnce the chemicals break the body down, it can be mutated and built up stronger. " +
                        "\nWith “mutagenic mushrooms, herbs, and plant stimulants, the bodies of young apprentices developed superhuman speed and endurance." +
                        "\nTheir new body has immunity to most diseases, feline-like eyes, and heightened senses." +
                        "\n\nA witcher must get the ingredients necessary for the Trail of the Grasses. You must get you must acquire the following ingredients: " +
                        "\n1 forktail spinal fluid, \n1 mantacore poison gland, \n1 albino bruxa tongue, \n1 bryonia, \n1 ribleaf, and \n1 mandrake root." +
                        "\nThese ingredients are most likely to be found in the woods and in the forest." +
                        "\n\nThe last step to become a witcher is The Trial of of the Mountains." +
                        "\nThe Trial of the Mountains is the final trial to test if one can survive as a Witcher — and it is as simple as it sounds. Survive. " +
                        "\nIn the Mountains. The Mountains, of course, that surround Kaer Morhen, or whichever corner of the world that the Witchers have been banished to. " +
                        "\nIt is dangerous, and no matter how heightened your senses, or potent your potions, the Mountains and the creatures that surround you can kill you. " +
                        "\nSurvive, and you just might have a chance at being a true monster-hunting mutant]" +
                        "\n\nYou said it was a long and detailed explanation. You thanked him again." +
                        "\n\n[Geralt: Now kid, I ask you, do you want to be a witcher? Are you not afraid to die?]");
                while(true){
                    System.out.print("\nWhat is you choice?" +
                            "\n*yes* - be a witcher, help humanity, and start training. " +
                            "\n*no* - you are afraid and don't want to risk yourself for humanity." +
                            "\n(all other commands are disabled) \n> ");
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("yes")){
                        System.out.println("You said yes to Geralt, and Geralt appreciates you and gave you a *forktail spinal fluid*." +
                                "\n[Geralt: Now kid, I gave you this for you to start finding the other necessary ingredients.]" +
                                "\nYou agreed, and added the given ingredient to your bag, then head to the forest to prepare for The Trial of the Grasses.");
                        //add the item to the linkedlist.
                        bag.addItem("forktail spinal fluid");
                        break;
                    } else if(input.equalsIgnoreCase("no")){
                        System.out.println("Geralt is ashamed of you and all the other witchers. You left Kaer Morhen.");
                        endingQuit();
                        break;
                    } else {
                        System.out.println("Invalid command! Other commands are temporarily disabled for this part.");
                    }

                }
                break;
            } else if(input.equalsIgnoreCase("ignore")){
                System.out.println("\nYou ignored about the choice and forgot about it. " +
                        "\nYou trained instead but Geralt, Vesemir, and the other Witchers saw how incompetent you are and weak by not facing and accepting the truth." +
                        "\nThey kicked you out the Kaer Morhen by just yourself.");
                endingQuit();
                finished = true;
                break;
            } else if (input.equalsIgnoreCase("examine")) {
                System.out.println(field);
            } else if (input.equalsIgnoreCase("look")){
                //add the found item to bag
                if(!bag.hasItem(ingredients[1])){
                    System.out.println("You look inside the barrel and found 1 mantacore poison gland.");
                    bag.addItem(ingredients[1]);
                    bag.displayItems();
                } else if (bag.hasItem(ingredients[1])){
                    System.out.println("Barrel is empty.");
                }
            } else if (input.equalsIgnoreCase("help")){
                help();
            } else if(input.equalsIgnoreCase("bag")){
                bag.displayItems();
            } else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public void theTrialGrasses() {
        System.out.println("\nBefore leaving the castle, you came across to a sign board announcing that the Trial of the Grasses" +
                "\nstarts in 10 days. It is also announced that if a witcher apprentice fail to collect the necessary ingredients " +
                "\nwill be kicked out. You head out to the forest to start the first day of collecting the ingredients.");

        while(day <= 10){
            System.out.println("\nDay " + day + " of 10" +
                    "\nYou are only by yourself, other witcher apprentices are gathering or collecting somewhere in the forest." +
                    "\nYou are very optimistic on gathering all of the ingredients before the trial of the grasses.");
            System.out.println(forest);
            if(bag.hasAllItems()){
                if(!bag.hasItem(ingredients[0]))
                    if (rand.nextDouble() <= 0.30) { // <-- 30% of the probability.
                        System.out.println("\nOh look at that! You found a " + ingredients[0] + " fluid.");
                        bag.addItem(ingredients[0]);
                        bag.displayItems();
                    } else {
                        System.out.println("\nYou spent all day finding a " + ingredients[0] + "  in the woods, and found nothing." );
                    }
                if(!bag.hasItem(ingredients[1]))
                    if (rand.nextDouble() <= 0.70) { // <-- 70% of the probability.
                        System.out.println("\n-- You spent all day and gathered a *"+ ingredients[1] +"* successfully!");
                        bag.addItem(ingredients[1]);
                        bag.displayItems();
                    } else {
                        System.out.println("\n-- You spent all day finding a *" + ingredients[1] + "*  in the woods, and found nothing." );
                    }
                if(!bag.hasItem(ingredients[2]))
                    if (rand.nextDouble() <= 0.55) { // <-- 55% of the probability.
                        System.out.println("\n-- You saw something and gathered a *" + ingredients[2] + "* successfully!");
                        bag.addItem(ingredients[2]);
                        bag.displayItems();
                    } else {
                        System.out.println("\n-- You spent all day finding a *" + ingredients[2] + "*  in the woods, and found nothing." );
                    }
                if(!bag.hasItem(ingredients[3]))
                    if (rand.nextDouble() <= 0.30) { // <-- 30% of the probability.
                        System.out.println("\n-- You fell and saw a *" + ingredients[3] + "* successfully!");
                        bag.addItem(ingredients[3]);
                        bag.displayItems();
                    } else {
                        System.out.println("\n-- You spent all day finding a *" + ingredients[3] + "*  in the woods, and found nothing." );
                    }
                if(!bag.hasItem(ingredients[4]))
                    if (rand.nextDouble() <= 0.45) { // <-- 45% of the probability.
                        System.out.println("\n--YES! You gathered *" + ingredients[4] + "* successfully!");
                        bag.addItem(ingredients[4]);
                        bag.displayItems();
                    } else {
                        System.out.println("\n-- You spent all day finding a *" + ingredients[4] + "*  in the woods, and found nothing." );
                    }
                if(!bag.hasItem(ingredients[5]))
                    if (rand.nextDouble() <= 0.30) { // <-- 30% of the probability.
                        System.out.println("\n-- You gathered *" + ingredients[5] + "* successfully!");
                        bag.addItem(ingredients[5]);
                        bag.displayItems();
                    } else {
                        System.out.println("\n-- You spent all day finding a *" + ingredients[5] + "*  in the woods, and found nothing." );
                    }
                //else Debug
                    //System.out.println("Done test user now has all ingredients");
            } // debug else {
                //System.out.println("Done test user now has all ingredients 2");
            //}

            bag.displayItems();
            while (true){
                System.out.print("\nWhat would you do next?" +
                        "\n*continue* - to the next day" +
                        "\n*leave* - leave the forest and quit being a witcher." +
                        "\n> ");
                String input = sc.nextLine();
                if(input.equalsIgnoreCase("continue")){
                    if(!bag.hasAllItems()){
                        day = 11;
                        System.out.println("You successfully got all the items!...." +
                                "\n" + line + "\nTrial of the Grasses" +
                                "\nYou handed your items to Master Witcher Vesemir to prepare your potions and chemicals to drink. " +
                                "\nYou are now strapped to a table and prepared to drink the chemicals." +
                                "\n\n[Vesemir: Child, are you ready to become a witcher?]" +
                                "\nYou said yes." +
                                "\n\n[Vesemir: You are great, now drink this.]" +
                                "\nYou drink the chemicals....." +
                                "\nYou felt painfully hurt, your body begans to break down." +
                                "\n\nMaster Witcher Vesemir continued giving you a series of chemicals and potions." +
                                "\n\nYou screamed in pain! Asking for help." +
                                "\nVesemir forced you to drink more." +
                                "\nYou drinked and felt getting stronger." +
                                "\nYour body begins to mutate, your senses are getting stronger, your eyes began to change like a feline eyes." +
                                "\n\n[Vesemir: Boy, good job. You are now a witcher. You have now senses like us, and immunity to most diseases." +
                                "\nYou will live longer than an average person, welcome home.]");
                        endingGood();
                        bag.removeAllItems();
                        finished = true;
                    } else {
                        day++;
                    }
                    break;
                } else if (input.equalsIgnoreCase("leave")) {
                    System.out.println("You leave the forest, you lost your way to go to Kaer Morhen, you stumbled upon a Wraith." +
                            "\nYou don't have any swords but only armor. The Wraith instantly attacked you. Without the help of the other witchers." +
                            "\nSadly, you are now alone, you bled heavily, your head hurts, and you slowly become unconscious." +
                            "\n\nYou were found by the other witcher apprentices, but it was too late. Your body is heavily wounded and cannot be possibly healed." +
                            "\nThe Master Witcher presumed you dead.");
                    day = 11;
                    endingBad();
                    finished = true;
                    break;
                } else if (input.equalsIgnoreCase("examine")) {
                    System.out.println(forest);
                } else if (input.equalsIgnoreCase("look")){
                    System.out.println("Nothing to look at.");
                } else if (input.equalsIgnoreCase("help")){
                    help();
                } else if(input.equalsIgnoreCase("bag")){
                    bag.displayItems();
                } else {
                    System.out.println("Invalid Command!");
                }
            }


        }
    }

    public void endingGood() {
        System.out.println(line + "\t\t\tThe End! 😄 🎉" + line);
        System.out.println("Congrats! For completing the trials to become a Witcher." +
                "\nAnd thanks to you for playing this short game!" +
                "\n\nTo complete the game, you must restart the program and choose 2 for Survival. " +
                "\nIn this mode, you will be able to face the Trial of the Mountains. Which you will have flexibility" +
                "\nto heal up, to attack, get items from monster drops and chests, to brew potions, to fight monsters, " +
                "\nand pass the trial and become a Master Witcher." +
                "\n\nSee you there witcher! I believe in you! " +
                line + "\t\t\tBecoming a Witcher ⚔" + line +
                "\nBased on the Witcher Books and the Original Game Witcher 3 🐺" +
                "\nMade with ♥ and ☕ by Arvin M. " +
                "\n https://arvinrhen.me/ || https://github.com/ArviinM");

    }

    public void endingBad() {
        System.out.println(line + "\t\t\t\tThe End! 😥" + line);
        System.out.println("If you end up here, it means you chose a bad path the made you killed or maybe you did not collected the ingredients." +
                "\nYou can still restart the game to try again!" +
                "\nTry and try and it'll be worth it." +
                "\n\nBut if you prefer action, you can try the survival mode to jump into the Trial of the Mountains." +
                "\nIn this mode, you will be able to face the Trial of the Mountains. Which you will have flexibility" +
                "\nto heal up, to attack, get items from monster drops and chests, to brew potions, to fight monsters, " +
                "\nand pass the trial and become a Master Witcher." +
                "\n\nThank you Witcher for playing the game!" +
                line + "\t\t\tBecoming a Witcher ⚔" + line +
                "\nBased on the Witcher Books and the Original Game Witcher 3 🐺" +
                "\nMade with ♥ and ☕ by Arvin M. " +
                "\n https://arvinrhen.me || https://github.com/ArviinM");

    }

    public void endingQuit() {
        System.out.println(line + "\t\t\t\tThe End! 😥" + line +
                "\nYou can still restart the game to try again!" +
                "\nTry and try and it'll be worth it." +
                "\n\nBut if you prefer action, you can try the survival mode to jump into the Trial of the Mountains." +
                "\nIn this mode, you will be able to face the Trial of the Mountains. Which you will have flexibility" +
                "\nto heal up, to attack, get items from monster drops and chests, to brew potions, to fight monsters, " +
                "\nand pass the trial and become a Master Witcher." +
                "\n\nThank you Witcher for playing the game!" +
                line + "\t\t\tBecoming a Witcher ⚔" + line +
                "\nBased on the Witcher Books and the Original Game Witcher 3 🐺" +
                "\nMade with ♥ and ☕ by Arvin M. " +
                "\nhttps://arvinrhen.me || https://github.com/ArviinM");
    }
}