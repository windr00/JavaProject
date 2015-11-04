package com.example.AndroidTest.SQLConnection;

/**
 * Created by ranweizhi on 15/11/2.
 */
public class FolderViewDataBean {

    private Integer Id ;
    private Integer Year;
    private Integer Month;
    private Integer DataPakAmount;

    public void setId (String Id) {
        this.Id = Integer.parseInt(Id);
    }

    public void setYear(String Year) {
        this.Year = Integer.parseInt(Year);
    }

    public void setMonth(String Month) {
        this.Month = Integer.parseInt(Month);
    }

    public void setDataPakAmount (String DataPakAmount) {
        this.DataPakAmount = Integer.parseInt(DataPakAmount);
    }

    public Integer getId() {
        return Id;
    }

    public Integer getYear() {
        return Year;
    }

    public Integer getMonth() {
        return Month;
    }

    public Integer getDataPakAmount() {
        return DataPakAmount;
    }
}
