package org.example.greenhouse;

import java.util.Objects;

public class Flower {
    private String name;
    private Soil soil;
    private String origin;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;
    private Multiplying multiplying;
    private int id;

    public Flower(int id, String name, Soil soil, String origin, VisualParameters visualParameters, GrowingTips growingTips, Multiplying multiplying) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
    }

    public Flower() {
        this.growingTips = new GrowingTips();
        this.visualParameters = new VisualParameters();
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Soil getSoil(){
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        Flower flower = (Flower) o;
        return getId() == flower.getId() && Objects.equals(getName(), flower.getName()) && getSoil() == flower.getSoil() && Objects.equals(getOrigin(), flower.getOrigin()) && Objects.equals(getVisualParameters(), flower.getVisualParameters()) && Objects.equals(getGrowingTips(), flower.getGrowingTips()) && getMultiplying() == flower.getMultiplying();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSoil(), getOrigin(), getVisualParameters(), getGrowingTips(), getMultiplying(), getId());
    }

    @Override
    public String toString() {
        return String.format("Id : %d\n" + "Name : %s\n" + "Soil : %s\n" + "Origin : %s\n" + "Multiplying : %s\n" + "%s\n" + "%s\n", id, name, soil, origin, multiplying, visualParameters, growingTips);
    }

}
