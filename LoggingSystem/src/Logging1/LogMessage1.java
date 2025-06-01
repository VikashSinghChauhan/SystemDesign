package Logging1;

public class LogMessage1 {
    String message;
    LogLevel2 logLevel;
    long timestamp;

    public LogMessage1(String message, LogLevel2 logLevel) {
        this.message = message;
        this.logLevel = logLevel;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public LogLevel2 getLogLevel() {
        return logLevel;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "LogMessage1{" +
                "message='" + message + '\'' +
                ", logLevel=" + logLevel +
                ", timestamp=" + timestamp +
                '}';
    }
}
