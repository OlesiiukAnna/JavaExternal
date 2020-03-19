package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Material {

    private Steel steel;
    private Wood wood;

    public Material() {
    }

    public Material(Steel steel) {
        this.steel = steel;
    }

    public Material(Wood wood) {
        this.wood = wood;
    }

    public Steel getSteel() {
        return steel;
    }

    public void setSteel(Steel steel) {
        this.steel = steel;
    }

    public Wood getWood() {
        return wood;
    }

    public void setWood(Wood wood) {
        this.wood = wood;
    }

    @Override
    public String toString() {

        if (wood == null){
            return "Material{" +
                    steel +
                    '}';
        }else {
            return "Material{" +
                    wood +
                    '}';
        }

    }
}
