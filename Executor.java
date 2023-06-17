import java.util.*;

public class Executor {
    // scanner is stored here as a static field so it is available to the execute methods
    public static Scanner scanner;

    static void initializeMemory() {
        Memory.globalMemory = new HashMap<String, CoreType>();
        Memory.localMemory = new Stack<HashMap<String, CoreType>>();
        Memory.heapMemory = new ArrayList<Integer>();
    }

    // read in from the scanner of .data
    public static int readIn() {
        int result = 0;
        if (scanner.currentToken() == Core.EOS) {
            System.out.println("ERROR: End of inputs.");
			System.exit(0);
        } else {
            result = scanner.getConst();
            scanner.nextToken();
        }

        return result;
    }


}   
