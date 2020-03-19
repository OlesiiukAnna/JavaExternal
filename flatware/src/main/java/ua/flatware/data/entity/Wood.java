package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wood {

    @JsonProperty("material-type")
    private String materialType;

    public Wood() {
    }

    public Wood(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "Wood{" +
                materialType +
                '}';
    }
}
