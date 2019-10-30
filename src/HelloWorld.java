import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main (String args[])
    {
        System.out.println("This is my first java program after long time.");
        List list = new ArrayList<>();
        list.add("abcd");
        System.out.println(list.get(0));
    }
}
