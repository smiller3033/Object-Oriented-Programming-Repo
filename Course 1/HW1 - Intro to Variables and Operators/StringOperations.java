public class StringOperations {
    public static void main(String[] args) {
    //TODO: Start your code after this line
        //part a
        String name = "Stephen";
        System.out.println(name);
        //part b
        name = name.replace("S", "A");
        name = name.replace("n", "Z");
        System.out.println(name);
        //part c
        String webAddress = "www.gatech.edu";
        System.out.println(webAddress);
        //part d
        String webName = webAddress.substring(4,10);
        webName = webName + "1331";
        System.out.println(webName);
    }
}
