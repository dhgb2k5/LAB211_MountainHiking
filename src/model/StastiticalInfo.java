package model;

public class StastiticalInfo {
    private String mountainCode;
    private int numOfStudent;
    private String totalCost;

    public StastiticalInfo() {}

    public StastiticalInfo(String mountainCode, int numOfStudent, String totalCost) {
        this.mountainCode = mountainCode;
        this.numOfStudent = numOfStudent;
        this.totalCost = totalCost;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }
    
    @Override
    public String toString() {
        return String.format("| %-11s| %-24d| %-12s|", mountainCode, numOfStudent, totalCost);
    }
}
