package com.pengli.designPattern.creational.builderPattern.multiObject;

public class Chair {

    private String type;
    private String color;
    private String material;
    private int legs;
    private boolean hasBackrest;


    private Chair(ChairBuilder builder) {
        this.type = builder.type;
        this.color = builder.color;
        this.material = builder.material;
        this.legs = builder.legs;
        this.hasBackrest = builder.hasBackrest;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public int getLegs() {
        return legs;
    }

    public boolean isHasBackrest() {
        return hasBackrest;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", legs=" + legs +
                ", hasBackrest=" + hasBackrest +
                '}';
    }


    public static class ChairBuilder {

        public String type;
        public String color;
        public String material;
        public int legs;
        public boolean hasBackrest;

        public ChairBuilder() {
            this.type = "Normal";
            this.color = "Black";
            this.material = "Wood";
            this.legs = 4;
            this.hasBackrest = false;
        }

        public ChairBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ChairBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public ChairBuilder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public ChairBuilder setLegs(int legs) {
            this.legs = legs;
            return this;
        }

        public ChairBuilder setHasBackrest(boolean hasBackrest) {
            this.hasBackrest = hasBackrest;
            return this;
        }

        public Chair build() {
            return new Chair(this);
        }
    }
}
