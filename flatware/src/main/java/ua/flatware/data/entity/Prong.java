package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Prong {

    @JsonProperty("material")
    private Material material;
    @JacksonXmlProperty(isAttribute = true)
    private int length;
    @JacksonXmlProperty(isAttribute = true)
    private int quantity;

    public Prong() {
    }

    public Prong(Material material, Material material1, int length, int quantity) {
        this.material = material1;
        this.length = length;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Prong{" +
                material +
                ", length=" + length +
                ", quantity=" + quantity +
                '}';
    }
}
