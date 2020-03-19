package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Scoop {

    @JsonProperty("material")
    private Material material;
    @JacksonXmlProperty(isAttribute = true)
    private int volume;

    public Scoop() {
    }

    public Scoop(Material material, Material material1, int volume) {
        this.material = material1;
        this.volume = volume;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Scoop{" +
                material +
                ", volume=" + volume +
                '}';
    }
}
