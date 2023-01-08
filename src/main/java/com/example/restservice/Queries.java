package com.example.restservice;

public class Queries {

    private int total;
    private int remaining;
    private int quota = 1000;
    private int value;
    private int excess;


    public Queries(){
    }

    public void add(int value){
        this.total += value;
        this.remaining = quota - total;
        if(remaining < quota ){
            excess = total - quota;
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getExcess() {
        return excess;
    }

    public void setExcess(int excess) {
        this.excess = excess;
    }
}
