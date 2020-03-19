package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Ware {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String type;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String origin;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Visual visual;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private boolean value;

    public Ware() {
    }

    public Ware(String type, String origin, Visual visual, boolean value) {
        this.type = type;
        this.origin = origin;
        this.visual = visual;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Visual getVisual() {
        return visual;
    }

    public void setVisual(Visual visual) {
        this.visual = visual;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                ", " + visual +
                ", value=" + value +
                '}';
    }
}
