public class Gameplay {
    
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angle = new BlueAstronaut("Angle", 44, 2, 0);
        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut sus = new RedAstronaut("Suspicious Person", 20, "expert");

        liam.sabotage(bob);
        Player[] players = Player.getPlayers();

        liam.emergencyMeeting();




        System.out.println(angle.isFrozen());
        System.out.println(albert.isFrozen());
        
    }
}
