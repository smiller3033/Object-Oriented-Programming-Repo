public class Fly{

    public static double DEFAULT_MASS = 5.0;
    public static double DEFAULT_SPEED = 10.0;
    private double mass;
    private double speed;

    //constructors
    public Fly() {
        this(DEFAULT_MASS);
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    //METHODS
    //setters and getters
    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    //other methods

    public String toString() {
        if (mass == 0) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
        }
        else {
            return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }

    public void grow(int addMass) {
        for (int i = 1; i <= addMass; i++) {
            mass++;
            if (mass > 20) {
                speed = speed - 0.5;
            }
            else if (mass <= 20) {
                speed = speed + 1.0;
            }        
        }
    }

    public boolean isDead() {
        boolean result = false;
        if (speed == 0) {
            result = true;
        }
        return result;
    }
}
