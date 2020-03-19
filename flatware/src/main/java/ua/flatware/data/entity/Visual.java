package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Visual {

    @JsonProperty("active-part")
    private ActivePart activePart;
    @JsonProperty("handle")
    private Handle handle;

    public Visual() {
    }

    public Visual(ActivePart activePart, Handle handle) {
        this.activePart = activePart;
        this.handle = handle;
    }

    public ActivePart getActivePart() {
        return activePart;
    }

    public void setActivePart(ActivePart activePart) {
        this.activePart = activePart;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "Visual{" +
                activePart +
                ", " + handle +
                '}';
    }
}
