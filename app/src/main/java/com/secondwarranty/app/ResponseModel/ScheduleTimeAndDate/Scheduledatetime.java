package com.secondwarranty.app.ResponseModel.ScheduleTimeAndDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scheduledatetime {

    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("sequence_order_id")
    @Expose
    private String sequenceOrderId;
    @SerializedName("users_id")
    @Expose
    private Long usersId;
    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("min_charge")
    @Expose
    private String minCharge;
    @SerializedName("sub_category_id")
    @Expose
    private Long subCategoryId;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("category_id")
    @Expose
    private Long categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("order_step")
    @Expose
    private Integer orderStep;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("order_placed")
    @Expose
    private String orderPlaced;
    @SerializedName("order_assigned")
    @Expose
    private String orderAssigned;
    @SerializedName("payment_mode")
    @Expose
    private String paymentMode;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("creation_lat")
    @Expose
    private String creationLat;
    @SerializedName("creation_long")
    @Expose
    private String creationLong;
    @SerializedName("schedule_date")
    @Expose
    private String scheduleDate;
    @SerializedName("schedule_time")
    @Expose
    private String scheduleTime;
    @SerializedName("_id")
    @Expose
    private Id id;

    public Scheduledatetime(String orderId, String sequenceOrderId, Long usersId, String serviceType, String minCharge, Long subCategoryId, String subCategoryName, Long categoryId, String categoryName, Integer orderStep, String paymentStatus, String orderPlaced, String orderAssigned, String paymentMode, String orderStatus, String status, String deviceId, Integer creationDate, String creationLat, String creationLong, String scheduleDate, String scheduleTime, Id id) {
        this.orderId = orderId;
        this.sequenceOrderId = sequenceOrderId;
        this.usersId = usersId;
        this.serviceType = serviceType;
        this.minCharge = minCharge;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.orderStep = orderStep;
        this.paymentStatus = paymentStatus;
        this.orderPlaced = orderPlaced;
        this.orderAssigned = orderAssigned;
        this.paymentMode = paymentMode;
        this.orderStatus = orderStatus;
        this.status = status;
        this.deviceId = deviceId;
        this.creationDate = creationDate;
        this.creationLat = creationLat;
        this.creationLong = creationLong;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSequenceOrderId() {
        return sequenceOrderId;
    }

    public void setSequenceOrderId(String sequenceOrderId) {
        this.sequenceOrderId = sequenceOrderId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMinCharge() {
        return minCharge;
    }

    public void setMinCharge(String minCharge) {
        this.minCharge = minCharge;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(Integer orderStep) {
        this.orderStep = orderStep;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public String getOrderAssigned() {
        return orderAssigned;
    }

    public void setOrderAssigned(String orderAssigned) {
        this.orderAssigned = orderAssigned;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationLat() {
        return creationLat;
    }

    public void setCreationLat(String creationLat) {
        this.creationLat = creationLat;
    }

    public String getCreationLong() {
        return creationLong;
    }

    public void setCreationLong(String creationLong) {
        this.creationLong = creationLong;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
