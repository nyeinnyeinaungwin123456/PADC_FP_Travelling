package com.padc.travelling.data.vos.restaurantVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class OperationTime {

    @SerializedName("start")
    private String start;

    @SerializedName("finish")
    private String finish;

    @SerializedName("off-day")
    private String[] offDay;

    public OperationTime() {
    }

    public OperationTime(String start, String finish, String[] offDay) {
        this.start = start;
        this.finish = finish;
        this.offDay = offDay;
    }

    public String getStart() {
        return start;
    }

    public String getFinish() {
        return finish;
    }

    public String[] getOffDay() {
        return offDay;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public void setOffDay(String[] offDay) {
        this.offDay = offDay;
    }
}
