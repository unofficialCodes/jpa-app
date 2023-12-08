package org.jpa.app.inheritance.mappedSuperClass.entities;

import jakarta.persistence.Entity;

@Entity
public class ElectronicDevice extends Product {

    private long voltage;

    public long getVoltage() {
        return voltage;
    }

    public void setVoltage(long voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "voltage=" + voltage +
                ", id=" + id +
                '}';
    }
}
