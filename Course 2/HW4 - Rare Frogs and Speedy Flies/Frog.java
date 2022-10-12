public class Frog {
    
    private static int DEFAULT_AGE = 5;
    private static double DEFAULT_TONGUE_SPEED = 5.0;

    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = new String("Rare Pepe");

    //constructors
    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, DEFAULT_AGE, tongueSpeed);
        int age = (int)(12*ageInYears);
        this.age = age;
    }

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        if ((age > 1) && (age < 7)) {
            isFroglet = true;
        }
        else {
            isFroglet = false;
        }
    }

    //methods
    private void grow() {
        age++;
        if (age <= 12) {
            tongueSpeed++;
        }
        else if (age > 30) {
            tongueSpeed--;
        }
        if (tongueSpeed <= 5) {
            tongueSpeed = 5;
        }

        if ((age > 1) && (age < 7)) {
            isFroglet = true;
        }
        else {
            isFroglet = false;
        }
    }

    public void grow(int months) {
        for (int i = 1; i <= months; i++) {
            age++;
            if (age <= 12) {
                tongueSpeed++;
            }
            else if (age > 30) {
                tongueSpeed--;
            }
            if (tongueSpeed <= 5) {
                tongueSpeed = 5;
            }
        }

        if ((age > 1) && (age < 7)) {
            isFroglet = true;
        }
        else {
            isFroglet = false;
        }
    }

    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        }
        if (tongueSpeed > fly.getSpeed()) {
            if (fly.getMass() >= 0.5*age) {
                grow();
            }
            fly.setMass(0);
        }
        else {
            fly.grow(1);
        }
    }

    public String toString() {
        if (isFroglet) {
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
        else {
            return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }
}
