package com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id {

    @SerializedName("$id")
    @Expose
    private String $id;

    public Id(String $id) {
        this.$id = $id;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }
}
