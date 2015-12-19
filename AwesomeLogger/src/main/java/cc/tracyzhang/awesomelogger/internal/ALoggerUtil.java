package cc.tracyzhang.awesomelogger.internal;

/**
 * Author:      lei zhang
 * Date:        15/12/10
 * Description:
 */
public class ALoggerUtil {

    public static String multiStr(int count,String str){
        if(null == str || str.equals("") || count<=0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++)
            sb.append(str);
        return sb.toString();
    }

}
