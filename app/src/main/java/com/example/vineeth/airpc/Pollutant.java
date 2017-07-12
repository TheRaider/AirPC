package com.example.vineeth.airpc;

/**
 * Created by vinee_000 on 27-05-2017.
 */

public class Pollutant {
    String name,formula,unit;
    int amount;

    public Pollutant(String name, String formula, int amount, String unit) {
        this.name = name;
        this.formula = formula;
        this.unit = unit;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
