package cc.tracyzhang.awesomelogger.internal;


import cc.tracyzhang.awesomelogger.ALogger;

/**
 * Author:      lei zhang
 * Date:        15/12/10
 * Description:
 */
public class StringWorker extends AbsALoggerWorker {

    @Override
    public void logContent(int level, String tag, Object obj) {
        String content = obj.toString();
        int interruptTimes = content.length()/ ALogger.MaxLineStrSize;
        int start = 0;
        for(int i=0;i<interruptTimes;i++){
            start = i* ALogger.MaxLineStrSize;
            StringBuilder cSB = new StringBuilder();
            cSB.append(ALogger.getLeftBorderStr()).append(ALogger.getPerPaddingStr()).append(content.substring(start, start + ALogger.MaxLineStrSize));
            log(level,tag, cSB.toString());
        }
        StringBuilder cSB = new StringBuilder();
        cSB.append(ALogger.getLeftBorderStr()).append(ALogger.getPerPaddingStr()).append(content.substring(interruptTimes* ALogger.MaxLineStrSize));
        log(level,tag, cSB.toString());
    }

}
