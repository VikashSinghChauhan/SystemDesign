package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackOverflow {

    static StackOverflow instance;
    Map<Integer, User> users;
    Map<Integer, Question> questions;
    Map<Integer, Answer> answers;

    private StackOverflow(){
       users = new HashMap<>();
       questions = new HashMap<>();
       answers = new HashMap<>();
    }

    public static StackOverflow getInstnce(){
        if(instance!=null)return instance;

        instance = new StackOverflow();
        return instance;
    }

    public User createUser(String username, String email){
        int id = users.size() +1;
        User user = new User(id, username, email,0);
        users.put(id, user);
        return user;
    }

    public Question askQuestion(User user, String title, String content)
    {
        Question question = user.askQuestion(new Question(1, title, content, user));
        questions.put(question.getId(), question);
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content){
        Answer answer = new Answer(1, user, question, content);
        answers.put(answer.getId(), answer);
        return answer;
    }




    public User getUsers(int id) {
        return users.get(id);
    }

    public Question getQuestions(int id) {
        return questions.get(id);
    }

    public  Answer getAnswers(int id) {
        return answers.get(id);
    }
}
