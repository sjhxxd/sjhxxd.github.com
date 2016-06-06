package bishe.utils;

/**
 * Created by sjh on 16/5/22.
 */
public class ExtReturn {
    private  String state;
    private  String msg;
    private  Object object;




    public ExtReturn(String state, String msg, Object object) {
        this.msg = msg;
        this.state = state;
        this.object=object;


    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
