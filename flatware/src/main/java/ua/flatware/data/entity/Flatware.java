package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement
public class Flatware {

    @JsonProperty("ware")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Ware> flatware = new ArrayList<>();

    public Flatware() {
    }

    public Flatware(List<Ware> flatware) {
        this.flatware = flatware;
    }

    public List<Ware> getFlatware() {
        return flatware;
    }

    public void setFlatware(List<Ware> flatware) {
        this.flatware = flatware;
    }

    @Override
    public String toString() {
        return "Flatware{" +
                "flatware=" + flatware +
                '}';
    }
}
