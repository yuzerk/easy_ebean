package personal.yuzerk.easy_ebean.xmlRpc.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlrpc.server.XmlRpcErrorLogger;

/**
 * @author yuzk
 * @date 2017/11/28
 */
public class MyXmlRpcErrorLogger extends XmlRpcErrorLogger {

    private static final Log log = LogFactory.getLog(XmlRpcErrorLogger.class);
    private boolean hasError = false;

    /**
     * Called to log the given error.
     */
    public void log(String pMessage, Throwable pThrowable) {
        hasError = true;
        if (pThrowable==null || pThrowable.getStackTrace()==null
                || pThrowable.getStackTrace().length<=0 || pThrowable.getMessage()==null) {
            log.error(pMessage + "\r\n" + getStackTrace());
        }
        else {
            log.error(pMessage, pThrowable);
        }
    }

    /**
     * Called to log the given error message.
     */
    public void log(String pMessage) {
        hasError = true;
        log.error(pMessage + "\r\n" + getStackTrace());
    }

    public boolean isHasError() {
        return hasError;
    }

    private String getStackTrace() {
        try {
            StackTraceElement[] stackElements = Thread.currentThread().getStackTrace();
            StringBuffer buf = new StringBuffer();
            if(stackElements != null) {
                for(int i = 0; i < stackElements.length; i++) {
                    buf.append(String.format("\tat %s.%s(%s:%d)\r\n", stackElements[i].getClassName(),
                            stackElements[i].getMethodName(), stackElements[i].getFileName(), stackElements[i].getLineNumber()));
                }
            }
            return buf.toString();
        }
        catch (Exception e) {
            log.error(e);
        }
        return null;
    }
}
