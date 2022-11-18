package cn.nicholasld.survey.result;

public class JsonResult {
    private int code;
    private Object data;

    public JsonResult(int serviceStatus, Object data) {
        this.code = serviceStatus;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
