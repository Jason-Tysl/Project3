import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Memory {
    static HashMap<String, CoreType> globalMemory;
    static Stack<HashMap<String, CoreType>> localMemory;
    static ArrayList<Integer> heapMemory;

    // allocate memory for a new identifier
    public static void allocate(String identifier, Core core) {
        // need coreType to know what to initialize the variable as (0 or null)
        CoreType coreType = new CoreType(core);

        // determine if it should go in the local memory or global memory
        if (!localMemory.isEmpty()) {
            // it's local, take off the top layer to add the initialized identifier
            HashMap<String, CoreType> topHashMap = localMemory.pop();
            topHashMap.put(identifier, coreType);
            // add the new map to the stack of local memory
            localMemory.add(topHashMap);
        } else {
            // it's global, initialize the identifier with coreType which gives it a value in the map
            globalMemory.put(identifier, coreType);
        }
    }


    public static CoreType findCoreTypeFromId(String identifier) {
        CoreType coreType = null;

        // search through local memory
        for (int i = 0; i < localMemory.size(); i++) {
            if (localMemory.get(i).containsKey(identifier)) {
                coreType = localMemory.get(i).get(identifier);
            }
        }

        // if it hasn't been found, search global memory
        if (coreType == null) {
            coreType = globalMemory.get(identifier);
        }

        return coreType;
    }
}
