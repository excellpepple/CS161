/*
	Name: 
	Username: 
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Party {
    private Hero[] heroes = new Hero[3];

    public Party() {
        heroes[0] = null;
        heroes[1] = null;
        heroes[2] = null;
    }

    public void addHero(Hero hero, int index) {
        if (heroes[index] != null) {
            if (heroes[index].toString().compareToIgnoreCase(hero.toString()) == 0) {
                System.out.println(hero+ " is already in the party!");
            } else {
                heroes[index] = hero;
            }
        }
    }

    public void removeHero(int index) {
        heroes[index] = null;
    }

    public Hero getHero(int index) {
        return heroes[index];
    }

    public void gainExperience(int experience) {
        for (Hero hero : heroes) {
            hero.gainExperience(experience);
        }
    }

    @Override
    public String toString() {
        String output = "Party:\n";
        for (Hero hero : heroes) {
            if (hero != null) {
                output += hero.toString();
            }
        }
        return output;
    }
}
