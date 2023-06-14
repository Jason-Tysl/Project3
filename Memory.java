import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Memory {
    static HashMap<String, CoreType> globalMemory;
    static Stack<HashMap<String, CoreType>> localMemory;
    static ArrayList<Integer> heapMemory;
}
