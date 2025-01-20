package model;

import java.io.Serializable;

public class Mountain implements Serializable {

    private String mountainCode;
    private String mountain;
    private String province;
    private String description;

    public Mountain() {}
    
    public Mountain(String mountainCode, String mountain, String province, String description) {
        setMountainCode(mountainCode);
        this.mountain = mountain;
        this.province = province;
        this.description = description;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMoutain() {
        return mountain;
    }

    public void setMoutain(String moutain) {
        this.mountain = moutain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", mountainCode, mountain, province, description);
    }
}
