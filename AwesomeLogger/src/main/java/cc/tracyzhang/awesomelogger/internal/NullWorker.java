package cc.tracyzhang.awesomelogger.internal;

/**
 * Author:      lei zhang
 * Date:        15/12/10
 * Description:
 */
public class NullWorker extends AbsALoggerWorker {

    @Override
    public void logContent(int level, String tag, Object obj) {
        log(level,tag,"null");
    }
}