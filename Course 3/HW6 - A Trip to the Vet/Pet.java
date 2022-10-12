public class Pet {
    private String name;
    private double health;
    private int painLevel;

    //CONSTRUCTOR
    public Pet(String name, double health, int painLevel) {
        this.name = name;
        //logic for health
        if (health < 0) {
            this.health = 0;
        }
        else if (health > 1) {
            this.health = 1.0;
        }
        else {
            this.health = health;
        }
        //logic for painLevel
        if (painLevel < 1) {
            this.painLevel = 1;
        }
        else if (painLevel > 10) {
            this.painLevel = 10;
        }
        else {
            this.painLevel = painLevel;
        }
    }

    //METHODS
    //getters and setters
    public String getName() {
        return this.name;
    }

    public double getHealth() {
        return this.health;
    }

    public int getPainLevel() {
        return this.painLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        if (health < 0) {
            this.health = 0;
        }
        else if (health > 1) {
            this.health = 1.0;
        }
        else {
            this.health = health;
    }

    public void setPainLevel(int painLevel) {
        if (painLevel < 1) {
            this.painLevel = 1;
        }
        else if (painLevel > 10) {
            this.painLevel = 10;
        }
        else {
            this.painLevel = painLevel;
    }

    //abstract method
    abstract int treat();

    public void speak() {
        String result = "Hello! My name is" + this.name;
        if (this.painLevel > 5) {
            result = result.toUpperCase();
        }
        System.out.println(result);
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Pet) {
            Pet p = (Pet) o;
            result = p.getName().equals(this.name);
        }
        return result;
    }

    private void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
}
