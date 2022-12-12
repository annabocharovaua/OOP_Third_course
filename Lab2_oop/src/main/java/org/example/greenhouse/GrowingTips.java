package org.example.greenhouse;

import java.util.Objects;

public class GrowingTips {
    private int temperature;
    private boolean isLighting;
    private int waterAmount;

    public GrowingTips(int temperature, boolean isLighting, int waterAmount){
        this.temperature = temperature;
        this.isLighting = isLighting;
        this.waterAmount = waterAmount;
    }
    public GrowingTips(){
        this.temperature=0;
        this.isLighting = false;
        this.waterAmount = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrowingTips)) return false;
        GrowingTips that = (GrowingTips) o;
        return getTemperature() == that.getTemperature() && getLighting() == that.getLighting() && getWaterAmount() == that.getWaterAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTemperature(), getLighting(), getWaterAmount());
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Boolean getLighting() {
        return isLighting;
    }

    public void setLighting(Boolean isLighting) {
        this.isLighting = isLighting;
    }

    public int getWaterAmount() {
        return waterAmount;
    }


    public void setWaterAmount(Integer waterAmount) {
        this.waterAmount = waterAmount;
    }




    @Override
    public String toString() {
        return String.format("Temperature : %d\n" + "Adequately illuminated: %s\n" + "Water amount : %d", temperature, isLighting, waterAmount);
    }
}
