public class CoreType {
    Core type;
    Integer value;

    public CoreType(Core type) {
        this.type = type;
        if (type == Core.INTEGER || type == Core.RECORD) {
            this.value = 0;
        }
    }
}
