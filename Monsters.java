import java.util.Scanner;
import java.util.Random;
class Monsters {

    String monsters [] = {"Bear", "Panther", "Wraith", "Fiend", "Drowner"};
    String monster;

    int monsterDmg = 50;

    Random rand = new Random();
    public void setMonster(String m){
        this.monster = m;
    }

    public int getMonsterDmg(){
        if (monster.equals(monsters[0])){
            monsterDmg = rand.nextInt(30);
            return monsterDmg;
        } else if (monster.equals(monsters[1])){
            monsterDmg = rand.nextInt(75);
            return monsterDmg;
        } else if (monster.equals(monsters[2])){
            monsterDmg = rand.nextInt(125);
            return monsterDmg;
        } else if (monster.equals(monsters[3])){
            monsterDmg = rand.nextInt(150);
            return monsterDmg;
        } else if (monster.equals(monsters[4])){
            monsterDmg = rand.nextInt(50);
            return monsterDmg;
        }

        return monsterDmg;
    }
}