package Logging1;


import Observer2.Subject1;

public abstract class LogHandler3 {

    static int globalLevel= LogLevel2.INFO.getLevel();
    LogHandler3 nextHandler;
    int level= LogLevel2.DEBUG.getLevel();


    static public void setGlobalLevel(LogLevel2 logLevel) {
        globalLevel = logLevel.getLevel();
    }

    public void setNextHandler(LogHandler3 nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(LogMessage1 message, Subject1 loggerSubject);
}
