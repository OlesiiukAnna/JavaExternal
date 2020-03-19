package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Steel {

    @JsonProperty("material-type")
    private String materialType;

    public Steel() {
    }

    public Steel(String materialType) {
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
        return "Steel{" +
                materialType +
                '}';
    }
}
