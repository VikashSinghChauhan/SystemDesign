package Observer2;


import Logging1.LogMessage1;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender3 implements Observer2 {

    private final String filePath;

    public FileAppender3(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(LogMessage1 message) {

        try(FileWriter fileWriter = new FileWriter(filePath, true)){
            fileWriter.write(message.getLogLevel() +" " + message.getTimestamp()+" "+ message.getMessage()+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
