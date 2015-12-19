package cc.tracyzhang.awesomelogger.internal;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Author:      lei zhang
 * Date:        15/12/10
 * Description:
 */
public class ALoggerFactory {

    static AbsALoggerWorker nullWorker;
    static AbsALoggerWorker stringWorker;
    static AbsALoggerWorker defaultWorker;
    static AbsALoggerWorker jsonWorker;

    static {
        nullWorker = new NullWorker();
        stringWorker = new StringWorker();
        defaultWorker = new DefaultWorker();
        jsonWorker = new JsonWorker();
    }

    public static AbsALoggerWorker getWorker(Object obj){
        if(null == obj){
            return nullWorker;
        }else if(obj instanceof String) {
            if(obj.toString().startsWith("{")){
                try {
                    new JSONObject(obj.toString());
                    return jsonWorker;
                }catch (JSONException e){
                    Log.e("ALoggerFactory",e.toString());
                }
            }
            return stringWorker;
        }else if(obj instanceof JSONObject){
            return jsonWorker;
        }
        return defaultWorker;
    }

}
