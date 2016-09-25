package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class OperatingTimeVO {

    @SerializedName("start")
    private String start;

    @SerializedName("finish")
    private String finish;

    @SerializedName("off-day")
    private String[] offDay;

    public OperatingTimeVO() {
    }

    public OperatingTimeVO(String start, String finish, String[] offDay) {
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
}
