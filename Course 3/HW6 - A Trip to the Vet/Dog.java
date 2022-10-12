public class Dog extends Pet {
    private static double DEFAULT_DROOL_RATE = 5.0;

    private double droolRate;

    //CONSTRUCTORS
    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_DROOL_RATE)
    }

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        }
        else {
            this.droolRate = droolRate;
        }
    }

    //METHODS
    //getters and setters
    public double getDroolRate() {
        return this.droolRate;
    }

    public void setDroolRate(double droolRate) {
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        }
        else {
            this.droolRate = droolRate;
    }
    
    //total time to treat is in minutes
    public int treat() {
        super.heal();
        int time = -1;
        if (droolRate < 3.5) {
            time = Math.round((super.getPainLevel()*2)/super.getHealth());
        }
        else if (droolRate >= 3.5 && droolrate <= 7.5) {
            time = Math.round(super.getPainLevel()/super.getHealth());
        }
        else if (droolRate > 7.5) {
            time = Math.round(super.getPainLevel()/(super.getHealth()*2));
        }
        return time;
    }

    public void speak() {
        super.speak();
        String barking = "";
        for (int i = 0; i < super.getPainLevel(); i++) {
            barking = barking + "bark ";
        }
        barking = barking.strip()
        if (super.getPainLevel() > 5) {
            barking = barking.toUpperCase();
        }
        System.out.println(barking);
    }

    public boolean equals(Object o) {
        result = false;
        if (super.equals(o)) {
            if (o instanceof Dog) {
                Dog d = (Dog) o;
                result = d.getDroolRate() == this.getDroolRate();
            }
        }
        return result;
    }
}
