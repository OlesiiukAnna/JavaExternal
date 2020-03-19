package ua.flatware.data.entity;

public class Handle {

    private Material material;

    public Handle() {
    }

    public Handle(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Handle{" +
                material +
                '}';
    }
}
