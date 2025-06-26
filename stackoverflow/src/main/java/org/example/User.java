package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Reputation.ANS;
import static org.example.Reputation.QUE;

public class User {
    int id;
    String username;
    String email;
    int reputation;
    List<Question> questionList;
    List<Answer> answerList;
    List<Comment> commentList;

    public User(int id, String username, String email, int reputation) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.reputation = reputation;
        this.questionList = new ArrayList<>();
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }

    public Question askQuestion(Question question){
        questionList.add(question);
        updateReputation(QUE.getVal());
        return question;
    }

    public void answerQuestion(Question question, String content)
    {
        Answer answer = new Answer(id, this, question, content);
        answerList.add(answer);
        question.addAnswer(answer);
        updateReputation(ANS.getVal());
    }


    public synchronized void updateReputation(int value)
    {
        this.reputation += value;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }
}
