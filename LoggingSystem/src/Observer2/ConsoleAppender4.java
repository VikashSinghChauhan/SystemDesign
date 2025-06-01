package Observer2;

import Logging1.LogMessage1;

public class ConsoleAppender4 implements Observer2 {
    @Override
    public void write(LogMessage1 message) {
        System.out.println(message.getLogLevel() +" " + message.getTimestamp()+" "+ message.getMessage());
    }
}
