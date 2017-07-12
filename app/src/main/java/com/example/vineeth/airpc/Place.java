package com.example.vineeth.airpc;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by vinee_000 on 30-05-2017.
 */

public class Place {
    private String name;
    private int amountOfCo,amountOfNo,amountOfNo2,amountOfO3,amountOfFineParticles,amountOfCoarseParticles;
    private LatLng latLng;
    private String condition ; // Good , Moderate , Unhealthy , Offline;
    private Long  imgRes;

    public Long getImgRes() {
        return imgRes;
    }

    public void setImgRes(Long imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfCo() {
        return amountOfCo;
    }

    public void setAmountOfCo(int amountOfCo) {
        this.amountOfCo = amountOfCo;
    }

    public int getAmountOfNo() {
        return amountOfNo;
    }

    public void setAmountOfNo(int amountOfNo) {
        this.amountOfNo = amountOfNo;
    }

    public int getAmountOfNo2() {
        return amountOfNo2;
    }

    public void setAmountOfNo2(int amountOfNo2) {
        this.amountOfNo2 = amountOfNo2;
    }

    public int getAmountOfO3() {
        return amountOfO3;
    }

    public void setAmountOfO3(int amountOfO3) {
        this.amountOfO3 = amountOfO3;
    }

    public int getAmountOfFineParticles() {
        return amountOfFineParticles;
    }

    public void setAmountOfFineParticles(int amountOfFineParticles) {
        this.amountOfFineParticles = amountOfFineParticles;
    }

    public int getAmountOfCoarseParticles() {
        return amountOfCoarseParticles;
    }

    public void setAmountOfCoarseParticles(int amountOfCoarseParticles) {
        this.amountOfCoarseParticles = amountOfCoarseParticles;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


}
