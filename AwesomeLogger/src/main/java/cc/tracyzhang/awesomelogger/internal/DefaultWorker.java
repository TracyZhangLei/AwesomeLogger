package cc.tracyzhang.awesomelogger.internal;

/**
 * Author:      lei zhang
 * Date:        15/12/11
 * Description:
 */
public class DefaultWorker extends AbsALoggerWorker {
    @Override
    public void logContent(int level, String tag, Object obj) {
        log(level,tag,obj.toString());
    }
}
