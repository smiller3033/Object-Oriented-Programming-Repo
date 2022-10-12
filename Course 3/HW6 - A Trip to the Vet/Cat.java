public class Cat extends Pet {
    private static int DEFAULT_MICE_CAUGHT = 0;    

    private int miceCaught;

    //CONSTRUCTORS
    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_MICE_CAUGHT);
    }

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        }
        else {
            this.miceCaught = miceCaught;
        }
    }

    //METHODS
    public int getMiceCaught() {
        return this.miceCaught;
    }

    public void setMiceCaught(int miceCaught) {
        if (miceCaught < 0) {
            this.miceCaught = 0;
        }
        else {
            this.miceCaught = miceCaught;
        }
    }

    //total time to treat is in minutes
    public int treat() {
        super.heal();
        int time = -1;
        if (miceCaught < 4) {
            time = Math.round((super.getPainLevel()*2)/super.getHealth());
        }
        else if (miceCaught >= 4 && miceCaught <= 7) {
            time = Math.round(super.getPainLevel()/super.getHealth());
        }
        else if (miceCaught > 7) {
            time = Math.round(super.getPainLevel()/(super.getHealth()*2));
        }
        return time;
    }

    public void speak() {
        super.speak();
        String meowing = "";
        for (int i = 0; i < this.getMiceCaught(); i++) {
            meowing = meowing + "meow ";
        }
        meowing = meowing.strip()
        if (super.getPainLevel() > 5) {
            meowing = meowing.toUpperCase();
        }
        System.out.println(meowing);
    }

    public boolean equals(Object o) {
        result = false;
        if (super.equals(o)) {
            if (o instanceof Cat) {
                Cat c = (Cat) o;
                result = c.getMiceCaught() == this.getMiceCaught();
            }
        }
        return result;
    }
}
