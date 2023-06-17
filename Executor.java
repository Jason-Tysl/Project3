import java.util.*;

public class Executor {
    // scanner is stored here as a static field so it is available to the execute methods
    public static Scanner scanner;

    static void initializeMemory() {
        Memory.globalMemory = new HashMap<String, CoreType>();
        Memory.localMemory = new Stack<HashMap<String, CoreType>>();
        Memory.heapMemory = new ArrayList<Integer>();
    }

    public static int readIn() {
        return 0;
    }


}   
