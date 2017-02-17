package com.gyc.exception;

/**
 * @author yc.guo@zuche.com on 2017/2/17.
 */
public class MyException extends RuntimeException {

    public static final int NULL_DATA = -1;

    private int errorCode;
    private String errorMsg;
    private String url;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
