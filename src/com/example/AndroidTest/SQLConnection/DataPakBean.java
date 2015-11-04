package com.example.AndroidTest.SQLConnection;

import android.provider.ContactsContract;
import android.text.BoringLayout;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ranweizhi on 15/11/2.
 */
public class DataPakBean {

    private Integer Id;
    private Integer Month;
    private Integer Year;
    private String DataPakName;
    private String DataPakSpecifiedApp;
    private Double DataPakSum;
    private Double DataPakUsed;
    private String DataPakStart;
    private String DataPakEnd;
    private Boolean IsDataPakDaily;
    private Boolean IsDataPakMonthly;

    public void setId(String Id) {
        this.Id = Integer.parseInt(Id);
    }

    public void setMonth(String MonthBelongsTo) {
        this.Month = Integer.parseInt(MonthBelongsTo);
    }

    public void setYear(String YearBelongsTo) {
        this.Year = Integer.parseInt(YearBelongsTo);
    }

    public void setDataPakName (String DataPakName) {
        this.DataPakName = DataPakName;
    }

    public void setDataPakSpecifiedApp (String DataPakSpecifiedApp) {
        this.DataPakSpecifiedApp = DataPakSpecifiedApp;
    }

    public void setDataPakSum (String DataPakSum) {
        this.DataPakSum = Double.parseDouble(DataPakSum);
    }

    public void setDataPakUsed (String DataPakUsed) {
        this.DataPakUsed = Double.parseDouble(DataPakUsed);
    }

    public void setDataPakStart (String DataPakStart) {
        this.DataPakStart = DataPakStart;
    }

    public void setDataPakEnd (String DataPakEnd) {
        this.DataPakEnd = DataPakEnd;
    }

    public void setIsDataPakDaily (String IsDaily) {
        IsDataPakDaily = Boolean.parseBoolean(IsDaily);
    }

    public void setIsDataPakMonthly (String IsMonthly) {
        IsDataPakMonthly = Boolean.parseBoolean(IsMonthly);
    }


    public Integer getId() {
        return Id;
    }

    public Integer getMonth() {
        return Month;
    }

    public Integer getYear() {
        return Year;
    }

    public String getDataPakName() {
        return DataPakName;
    }

    public String getDataPakSpecifiedApp() {
        return DataPakSpecifiedApp;
    }

    public String getDataPakStart() {
        return DataPakStart;
    }

    public String getDataPakEnd() {
        return DataPakEnd;
    }

    public Double getDataPakSum() {
        return DataPakSum;
    }

    public Double getDataPakUsed() {
        return DataPakUsed;
    }

    public Boolean getIsDataPakDaily() {
        return IsDataPakDaily;
    }

    public Boolean getIsDataPakMonthly() {
        return IsDataPakMonthly;
    }

}
