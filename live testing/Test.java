import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) {
String funnyStr = "south, long island";
funnyStr.replace("!"," ");
funnyStr.replace("the beach","");
funnyStr.replace(", long", "");
funnyStr.replace("wal","roc");
funnyStr.toUpperCase();
System.out.println(funnyStr);
}

}


