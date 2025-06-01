package Logger3;

import Observer2.AppenderManager5;
import Observer2.Subject1;
import Logging1.*;


public class Logger {

    private static Logger logger;
    private static LogHandler3 handler;
    private static Subject1 subject;

    private Logger(){
    }

    public synchronized  static Logger getLogger(){
        if(logger == null)
        {
            //Thread-safe, Lazy-loaded Singleton
            logger = new Logger();

            //This design ensures handler and subject are created only once per JVM run, effectively singleton but nor truly.
            LogHandler3.setGlobalLevel(LogLevel2.DEBUG);
            handler = clientHandler();
            subject = AppenderManager5.create();
        }
        return logger;
    }

    public void info(String message){
        createLog(message, LogLevel2.INFO);
    }

    public void debug(String message)
    {
        createLog(message, LogLevel2.DEBUG);
    }

    public void warn(String message)
    {
        createLog(message, LogLevel2.WARN);
    }

    public void error(String message)
    {
        createLog(message, LogLevel2.ERROR);
    }

    private static void createLog(String message, LogLevel2 logLevel) {
        LogMessage1 msg1 = new LogMessage1(message, logLevel);
        handler.handle(msg1, subject);
    }

    private static LogHandler3 clientHandler() {
        LogHandler3 infoHandler = new InfoHandler();
        LogHandler3 debugHandler = new DebugHandler();
        LogHandler3 errorHandler = new ErrorHandler();
        LogHandler3 warnHandler = new WarnHandler();

        errorHandler.setNextHandler(warnHandler);
        warnHandler.setNextHandler(infoHandler);
        infoHandler.setNextHandler(debugHandler);


        return errorHandler;
    }
}
