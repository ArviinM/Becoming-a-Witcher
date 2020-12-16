class Menu implements MainMenu {
    public String name;
    public int gameMode;
    public String start;
    String line = "\n===========================================\n";

    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public int getGameMode(){
        return gameMode;
    }
    public void setGameMode(int newGameMode){
        this.gameMode = newGameMode;
    }

    public void start(String s){
        this.start = s;
        boolean yn = true;
        if(getGameMode() == 1){
            System.out.print(line + "Starting Story Game Mode! ..... " + line);
            // start story mode using story interface
            Story story = new StoryBase();
            story.startStory();
        } else if (getGameMode() == 2) {
            System.out.print(line + "Starting Survival Game Mode! ..... " + line);
            // start survival game mode using suvival interface
            Survival surv = new SurvivalBase();
            surv.startSurvival();
        } else {
            System.out.println("Please try again!");
        }
    }
}
