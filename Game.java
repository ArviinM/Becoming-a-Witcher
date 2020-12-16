import java.util.Scanner;
//Main Java File with the Main Method
public class Game {
    //main method
    public static void main (String args []){
        String name, start;
        int gameMode;
        boolean yn = true;
        boolean running = true;

        String line = "\n=========================================== \n";

        Scanner sc = new Scanner(System.in);
        MainMenu menu = new Menu();

        //Ask the user what his/her name.
        System.out.print("\nEnter your name: " + "\n> ");
        menu.setName(name = sc.nextLine());
        //Ask and checks the user what game mode he/she wants.
        while(yn){
            System.out.print("\nEnter 1 or 2 to select your game mode. " +
                    "\n1 - Story -- Becoming a Witcher " +
                    "\n2 - Survival -- The Trial of The Mountains (Continuation of Becoming a Witcher) " +
                    "\n> ");
            menu.setGameMode(gameMode = sc.nextInt());

            if(menu.getGameMode() == 1){
                System.out.print(line + "Initializing Story Game Mode! ..... " + line);
                yn = false;
                break;
            } else if (menu.getGameMode() == 2) {
                System.out.print(line + "Initializing Survival Game Mode! ..... " + line);
                yn = false;
                break;
            } else {
                System.out.println("Please try again!");
            }
        }
        //Ask the user to start.
        while(yn = true){
            System.out.print("\nEnter P to start playing, " + menu.getName() + "\n> ");
            start = sc.next();

            if(start.equalsIgnoreCase("p")){
                menu.start(start);
                yn = false;
                break;
            } else {
                System.out.println("Please try again!");
            }
        }

    }
}