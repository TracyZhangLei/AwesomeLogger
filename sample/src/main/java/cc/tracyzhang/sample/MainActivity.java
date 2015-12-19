package cc.tracyzhang.sample;

import android.app.Activity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import cc.tracyzhang.awesomelogger.ALogger;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ALogger.d("notice", "AwesomeLogger is available!");
        JSONObject obj = new JSONObject();
        try {
            obj.put("name", "Lei Zhang");
            obj.put("email","fkingu007@gmail.com");
            obj.put("github","tracyzhanglei");
            obj.put("blog","www.tracyzhang.cc");
            ALogger.i("Author Info",obj);
        }catch(JSONException e){
        }
    }

}
