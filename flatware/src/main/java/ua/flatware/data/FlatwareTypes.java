package ua.flatware.data;

public enum FlatwareTypes {
    KNIFE("Knife"),
    FORK("Fork"),
    SPOON("Spoon");

    private String type;

    private FlatwareTypes(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
