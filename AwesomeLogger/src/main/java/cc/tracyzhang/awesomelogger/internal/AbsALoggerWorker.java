package cc.tracyzhang.awesomelogger.internal;

import android.util.Log;

import java.util.concurrent.Semaphore;

import cc.tracyzhang.awesomelogger.ALogger;

/**
 * Author:      lei zhang
 * Date:        15/12/10
 * Description:
 */
public abstract class AbsALoggerWorker extends AbsWorkerTemplate {

    private static Semaphore LOCK = new Semaphore(1);

    public final void d(String tag, Object obj) {
        logChain(Log.DEBUG, tag, obj);
    }

    public final void i(String tag, Object obj) {
        logChain(Log.INFO, tag, obj);
    }

    public final void w(String tag, Object obj) {
        logChain(Log.WARN, tag, obj);
    }

    public final void e(String tag, Object obj) {
        logChain(Log.ERROR, tag, obj);
    }

    protected static final void log(int level, String tag, String msg) {
        try {
            LOCK.acquire();
        }catch (Exception e){}
        switch(level){
            case Log.DEBUG:
                Log.d(tag,msg);
                break;
            case Log.INFO:
                Log.i(tag,msg);
                break;
            case Log.WARN:
                Log.w(tag,msg);
                break;
            case Log.ERROR:
                Log.e(tag,msg);
                break;
            default:
                LOCK.release();
                throw new IllegalArgumentException("unsupported log level!!!");
        }
        LOCK.release();
    }

    @Override
    protected final void logTop(int level, String tag, Object obj) {
        log(level, tag, obj.toString());
    }

    @Override
    protected final void logBottom(int level, String tag, Object obj) {
        log(level, tag, obj.toString());
    }

    protected void logChain(int level, String tag, Object obj) {
        logTop(level, tag, ALogger.getTopBorderStr());
        logContent(level, tag, obj);
        logBottom(level, tag, ALogger.getBottomBorderStr());
    }

}
