package cc.tracyzhang.awesomelogger.internal;
/**
 * Author:      lei zhang
 * Date:        15/12/13
 * Description:
 */
public abstract class AbsWorkerTemplate {
    protected void logTop(int level,String tag,Object obj){}
    protected void logContent(int level,String tag,Object obj){}
    protected void logBottom(int level,String tag,Object obj){}
}
