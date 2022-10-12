public class Pond {
    public static void main(String args[]) {
        //create frogs
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog pee = new Frog("Pee");

        //create flies
        Fly fly1 = new Fly(1.0, 3.0);
        Fly fly2 = new Fly(6.0);
        Fly fly3 = new Fly(2.0, 4.0);

        //performing operations
        peepo.setSpecies("1331 Frogs");
        System.out.println(peepo.toString());
        peepo.eat(fly2);
        System.out.println(fly2.toString());
        peepo.grow(8);
        peepo.eat(fly2);
        System.out.println(fly2.toString());
        System.out.println(peepo.toString());
        System.out.println(pee.toString());
        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}
