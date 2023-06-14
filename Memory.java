import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Memory {
    static HashMap<String, Core> globalMemory;
    static Stack<HashMap<String, Core>> localMemory;
    static ArrayList<Integer> heapMemory;
}
