package com.example.homeworktsu.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    String sakitxi;
    String sworiPasuxi;
    List<String> pasuxebi=new ArrayList<>();
    public Test(String sakitxi,
                String sworiPasuxi,
                List<String> pasuxebi){
        this.sakitxi=sakitxi;
        this.pasuxebi=pasuxebi;
        this.sworiPasuxi=sworiPasuxi;
    }

    public boolean sworiaPasuxi(String pasuxi){
        return pasuxi.equals(this.sworiPasuxi);
    }

    public void setPasuxebi(List<String> pasuxebi) {
        this.pasuxebi = pasuxebi;
    }

    public void setSakitxi(String sakitxi) {
        this.sakitxi = sakitxi;
    }

    public void setSworiPasuxi(String sworiPasuxi) {
        this.sworiPasuxi = sworiPasuxi;
    }

    public List<String> getPasuxebi() {
        return pasuxebi;
    }

    public String getSakitxi() {
        return sakitxi;
    }

    public String getSworiPasuxi() {
        return sworiPasuxi;
    }
}
