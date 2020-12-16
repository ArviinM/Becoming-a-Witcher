interface MainMenu {
    public String getName();
    public void setName(String newName);
    public int getGameMode();
    public void setGameMode(int newGameMode);
    public void start(String s);
}

interface Story {
    public void startStory();
    public void title();
    public void help();
    public void exposition();
    public void theChoice();
    public void theTrialGrasses();
    public void endingGood();
    public void endingBad();
    public void endingQuit();
}

interface Survival {
    public void startSurvival();
    public void title();
    public void help();
    public void about();
    public void Game();
    public void victory();
    public void defeat();
}