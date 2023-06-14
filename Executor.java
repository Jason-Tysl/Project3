import java.util.*;

public class Executor {
    // scanner is stored here as a static field so it is available to the execute methods
    public static Scanner scanner;

    static void initializeMemory() {
        Memory.globalMemory = new HashMap<String, Core>();
        Memory.localMemory = new Stack<HashMap<String, Core>>();
        Memory.heapMemory = new ArrayList<Integer>();
    }


}   
