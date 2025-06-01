package Observer2;


public class AppenderManager5 {

    public static Subject1 create(){
        Subject1 subject  = new Subject1();
        //subject.getMap().put(LogLevel2.INFO.getLevel(), new ArrayList<>((Collection) new ConsoleAppender4()));
        subject.addObserver( new FileAppender3("logs.txt"));
        subject.addObserver(new ConsoleAppender4());
        return subject;
    }
}
