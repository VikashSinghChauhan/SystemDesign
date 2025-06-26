package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, User> users = new HashMap<>();
        Map<Integer, Question> questions = new HashMap<>();

        User user1 = new User(1, "vikash", "vikash.singh",0);
        Question q1 = new Question(1, "Que1", "How are you", user1);
        user1.askQuestion(q1);
        q1.addAnswer(new Answer(1, user1, q1, "I am fine"));

        questions.putIfAbsent(q1.getId(), q1);
        System.out.println(questions.toString());
    }
}