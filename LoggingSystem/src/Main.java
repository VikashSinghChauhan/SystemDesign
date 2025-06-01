import Logger3.Logger;


public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger();
        logger.info("info message is here");
        logger.debug("debug message is there");
        logger.error("top priority message");

    }

}