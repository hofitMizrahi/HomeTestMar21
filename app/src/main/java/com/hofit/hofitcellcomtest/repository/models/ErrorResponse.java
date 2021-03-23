package com.hofit.hofitcellcomtest.repository.models;

public class ErrorResponse {
    private int responseCode;
    private String errorMessage;
    private String url;

    public ErrorResponse(int responseCode, String url) {
        this.responseCode = responseCode;
        this.url = url;

    }

    public ErrorResponse(){}

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(int responseCode, String errorMessage, String url) {
        this.responseCode = responseCode;
        this.errorMessage = errorMessage;
        this.url = url;
    }


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
