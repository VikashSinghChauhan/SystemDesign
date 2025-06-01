package Logging1;


import Observer2.Subject1;

public class InfoHandler extends LogHandler3 {
    int level= LogLevel2.INFO.getLevel();

    @Override
    public void handle(LogMessage1 message, Subject1 loggerSubject)
    {
        if((this.level <= globalLevel) && (this.level == message.logLevel.getLevel())) {
            loggerSubject.notifyAllObserver(message);
        }
        else {
            if(nextHandler != null)
            {
                nextHandler.handle(message, loggerSubject);
            }
        }
    }

}
