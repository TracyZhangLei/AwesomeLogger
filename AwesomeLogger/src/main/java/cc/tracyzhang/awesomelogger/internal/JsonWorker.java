package cc.tracyzhang.awesomelogger.internal;


import cc.tracyzhang.awesomelogger.ALogger;

/**
 * Author:      lei zhang
 * Date:        15/12/11
 * Description:
 */
public class JsonWorker extends AbsALoggerWorker {

    @Override
    public void logContent(int level, String tag, Object obj) {
        String formatedStr = format(obj.toString());
        String[] strs = formatedStr.split("\n");
        for(String s:strs){
            StringBuilder cSB = new StringBuilder();
            cSB.append(ALogger.getLeftBorderStr()).append(s.length() > ALogger.MaxLineStrSize?s.substring(0,ALogger.MaxLineStrSize):s);
            log(level,tag, cSB.toString());
        }
    }

    /**
     * 得到格式化json数据
     */
    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int i=0;i<jsonStr.length();i++){
            char c = jsonStr.charAt(i);
            if(level>0&&'\n'==jsonForMatStr.charAt(jsonForMatStr.length()-1)){
                jsonForMatStr.append(ALoggerUtil.multiStr(level, ALogger.getPerPaddingStr()));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c+"\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c+"\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(ALoggerUtil.multiStr(level, ALogger.getPerPaddingStr()));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }

}
