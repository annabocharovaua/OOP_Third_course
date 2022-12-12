package org.example.greenhouse;

import java.util.Objects;

public class VisualParameters {
    private String stemColor;
    private String leavesColor;
    private double averageSize;

    public VisualParameters(String stemColor, String leavesColor, double averageSize) {
        this.stemColor = stemColor;
        this.leavesColor = leavesColor;
        this.averageSize = averageSize;
    }

    public  VisualParameters() {
        this.stemColor = new String();
        this.leavesColor = new String();
        this.averageSize = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisualParameters)) return false;
        VisualParameters that = (VisualParameters) o;
        return Double.compare(that.getAverageSize(), getAverageSize()) == 0 && Objects.equals(getStemColor(), that.getStemColor()) && Objects.equals(getLeavesColor(), that.getLeavesColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStemColor(), getLeavesColor(), getAverageSize());
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor (String leavesColor) {
       this.leavesColor = leavesColor;
    }

    public double getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(double averageSize) {
        this.averageSize = averageSize;
    }

    @Override
    public String toString() {
        return String.format("Stem color : %s\n" + "Leaves color : %s\n" + "Average size : %f", stemColor, leavesColor, averageSize);
    }
}
