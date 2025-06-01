package Logging1;

public enum LogLevel2 {

    ERROR(1),
    WARN(2),
    INFO(3),
    DEBUG(4);

    private int level;
    LogLevel2(int level ) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
