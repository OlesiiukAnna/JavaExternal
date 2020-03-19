package ua.flatware.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivePart {

    private Blade blade;
    private Prong prong;
    private Scoop scoop;

    public ActivePart() {
    }

    public ActivePart(Blade blade) {
        this.blade = blade;
    }

    public ActivePart(Prong prong) {
        this.prong = prong;
    }

    public ActivePart(Scoop scoop) {
        this.scoop = scoop;
    }

    public Blade getBlade() {
        return blade;
    }

    public void setBlade(Blade blade) {
        this.blade = blade;
    }

    public Prong getProng() {
        return prong;
    }

    public void setProng(Prong prong) {
        this.prong = prong;
    }

    public Scoop getScoop() {
        return scoop;
    }

    public void setScoop(Scoop scoop) {
        this.scoop = scoop;
    }

    @Override
    public String toString() {

        if (blade != null) {
            return "ActivePart{" +
                    blade +
                    '}';
        } else if (prong != null) {
            return "ActivePart{" +
                    prong +
                    '}';
        } else {
            return "ActivePart{" +
                    scoop +
                    '}';
        }

    }
}
