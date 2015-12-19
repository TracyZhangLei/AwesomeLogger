package cc.tracyzhang.awesomelogger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cc.tracyzhang.awesomelogger.internal.ALoggerFactory;
import cc.tracyzhang.awesomelogger.internal.ALoggerUtil;


/**
 * Author:      lei zhang
 * Date:        15/12/10
 * Description:
 */
public class ALogger {

    public static boolean D = true;

    public static int MaxLineStrSize = 4000;
    private static int topStrUnit = 80;
    private static String topLeftBorderStrChar = "╔";
    private static String bottomLeftBorderStrChar = "╚";
    private static String topBorderStrChar = "═";
    private static String leftBorderStrChar = "║";
    private static String topBorderStr = topLeftBorderStrChar+ ALoggerUtil.multiStr(topStrUnit, topBorderStrChar);
    private static String bottomBorderStr = bottomLeftBorderStrChar+ ALoggerUtil.multiStr(topStrUnit, topBorderStrChar);
    private static String leftBorderStr = ALoggerUtil.multiStr(1, leftBorderStrChar);

    private static String perPaddingStr = ALoggerUtil.multiStr(2, " ");

    public static String getPerPaddingStr() {
        return perPaddingStr;
    }

    public static void setPerPaddingStr(String perPaddingStr) {
        ALogger.perPaddingStr = perPaddingStr;
    }

    public static String getTopBorderStr() {
        return topBorderStr;
    }

    public static String getLeftBorderStr() {
        return leftBorderStr;
    }

    public static String getBottomBorderStr() {
        return bottomBorderStr;
    }

    private static ExecutorService es = Executors.newSingleThreadExecutor();

    public static void d(final String tag,final Object obj){
        if(D){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    ALoggerFactory.getWorker(obj).d(tag, obj);
                }
            });
        }
    }

    public static void i(final String tag,final Object obj){
        if(D){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    ALoggerFactory.getWorker(obj).i(tag, obj);
                }
            });
        }
    }

    public static void w(final String tag,final Object obj){
        if(D){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    ALoggerFactory.getWorker(obj).w(tag, obj);
                }
            });
        }
    }

    public static void e(final String tag,final Object obj){
        if(D){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    ALoggerFactory.getWorker(obj).e(tag, obj);
                }
            });
        }
    }

}
