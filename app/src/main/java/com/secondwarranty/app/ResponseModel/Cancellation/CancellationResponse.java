package com.secondwarranty.app.ResponseModel.Cancellation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CancellationResponse {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private Result result;

    public CancellationResponse(Integer success, String message, Result result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
