public class CoreType {
    Core type;
    Integer value;

    public CoreType(Core type) {
        this.type = type;

        // "When an integer variable is declared, it has initial value 0."
        if (type == Core.INTEGER) {
            this.value = 0;
        }
        
        //"When a record variable is declared, it is initially a null reference."
        else if (type == Core.RECORD) {
            this.value = null;
        }
    }
}
