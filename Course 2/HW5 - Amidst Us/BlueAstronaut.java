import java.util.*;
public class BlueAstronaut extends Player implements Crewmate {
    
    private static int DEFAULT_SUS_LEVEL = 15;
    private static int DEFAULT_NUM_TASKS = 6;
    private static int DEFAULT_TASK_SPEED = 10;    

    private int numTasks;
    private int taskSpeed;

    //constructors
    public BlueAstronaut(String name) {
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
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

        for (int i = 0; i < players.length; i++) {
            if (players[i].isFrozen()) {
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

    public void completeTask() {
        if (isFrozen()) {
            return;
        }

        if (taskSpeed > 20) {
            for (int i = 0; i < 2; i++) {
                numTasks--;
                if (numTasks == 0) {
                    System.out.println("I have completed all my tasks");
                    setSusLevel((int)(getSusLevel() * 0.5));
                }
            }
        }
        else {
            numTasks--;
            if (numTasks == 0) {
                System.out.println("I have completed all my tasks");
                    setSusLevel((int)(getSusLevel() * 0.5));
            }
        }
        //checks if numTasks is less than zero
        if (numTasks < 0) {
            numTasks = 0;
            return;
        }

        
    }

    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.numTasks == player.numTasks && this.taskSpeed == player.taskSpeed;
        }
        return false;
    }

    public String toString() {
        String msg = super.toString();
        msg = msg + " I have " + this.numTasks + " left over.";
        if (this.getSusLevel() > 15) {
            msg = msg.toUpperCase();
        }
        return msg;
    }
}
