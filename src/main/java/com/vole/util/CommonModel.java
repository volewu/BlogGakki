package com.vole.util;

/**
 * 编写者： vole
 * Time： 2018/6/4.15:25
 * 内容：
 */
public class CommonModel {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccess(){
        setCode(0);
        setMsg("success");
    }

    public void setFail(){
        setCode(1);
        setMsg("fail");
    }
}
