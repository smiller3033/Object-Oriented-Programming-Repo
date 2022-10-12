import java.util.*;
public class RedAstronaut extends Player implements Impostor {

    private static int DEFAULT_SUS_LEVEL = 15;
    private static String DEFAULT_SKILL = "experienced";
    private String skill;

    //constructors
    public RedAstronaut(String name) {
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_SKILL);
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    //methods
    public void emergencyMeeting() {
        if (isFrozen()) { //checks if player is frozen
            return;
        }

        //orders the most sus players in descending order
        Player[] players = getPlayers();
        Arrays.sort(players);
        for (int i = 0; i < players.length / 2; i++) {
            Player temp = players[i];
            players[i] = players[players.length - 1 - i];
            players[players.length - 1 - i] = temp;
        }

        for (Player player : players) {
            System.out.println(player.getName());
            System.out.println(player.getSusLevel());
        }

        for (int i = 0; i < players.length; i++) {
            if (players[i].isFrozen()) {
                continue;
            }
            else if (this.equals(players[i])) {
                continue;
            }
            else if (players[i].getSusLevel() == players[i+1].getSusLevel()) {
                continue;
            }
            else {
                players[i].setFrozen(true);
                break;
            }
        }
        gameOver();
    }
    public void freeze(Player p) {
        //checks if the inputted player is an impostor, is the inputted player is frozen or if the acting player is frozen
        if (p instanceof Impostor || p.isFrozen() || this.isFrozen()) {
            return;
        }
        //successful freezing
        if (this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
            gameOver();
            return;
        }
        //unsuccessful freezing
        else {
            this.setSusLevel(getSusLevel() * 2);
            gameOver();
            return;
        }

    }

    public void sabotage(Player p) {
        //checks if the inputted player is an impostor, is the inputted player is frozen or if the acting player is frozen
        if (p instanceof Impostor || p.isFrozen() || this.isFrozen()) {
            return;
        }

        if (this.getSusLevel() < 20) {
            int newSus = (int)(p.getSusLevel() * 1.5);
            p.setSusLevel(newSus);
        }
        else {
            int newSus = (int)(p.getSusLevel() * 1.25);
            p.setSusLevel(newSus);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut player = (RedAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.skill == player.skill;
        }
        return false;
    }

    public String toString() {
        String msg = super.toString();
        msg = msg + " I am an " + this.skill + " player!";
        if (this.getSusLevel() > 15) {
            msg = msg.toUpperCase();
        }
        return msg;
    }

}
