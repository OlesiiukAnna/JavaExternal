package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class Blade {

    @JsonProperty("material")
    private Material material;
    @JacksonXmlProperty(isAttribute = true)
    private int length;
    @JacksonXmlProperty(isAttribute = true)
    private int width;

    public Blade() {
    }

    public Blade(Material material, Material material1, int length, int width) {
        this.material = material1;
        this.length = length;
        this.width = width;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Blade{" +
                material +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
