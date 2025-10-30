package com.pengli.designPattern.creational.builderPattern.multiObject;

public class Table {

    private final String height;
    private final String width;
    private final String legs;
    private final String color;
    private final String material;

    private Table(TableBuilder builder) {
        this.height = builder.heigth;
        this.width = builder.width;
        this.legs = builder.legs;
        this.color = builder.color;
        this.material = builder.material;
    }


    public String getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }

    public String getLegs() {
        return legs;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Table{" +
                "heigth='" + height + '\'' +
                ", width='" + width + '\'' +
                ", legs='" + legs + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    public static class TableBuilder {


        public String heigth;
        public String width;
        public String legs;
        public String color;
        public String material;


        public TableBuilder() {
            this.heigth = "100cm";
            this.width = "100cm";
            this.legs = "4";
            this.color = "red";
            this.material = "wood";
        }

        public TableBuilder setHeigth(String heigth) {
            this.heigth = heigth;
            return this;
        }

        public TableBuilder setWidth(String width) {
            this.width = width;
            return this;
        }

        public TableBuilder setLegs(String legs) {
            this.legs = legs;
            return this;
        }

        public TableBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public TableBuilder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Table build() {
            return new Table(this);
        }


    }

}
