package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements  Votable, Commentable{
    int id;
    String content;
    User author;
    Question question;
    boolean isAccepted;
    Date creationDate;
    List<Comment> commentList;
    List<Vote> voteList;

    public Answer(int id, User author, Question question, String content) {
        this.id = id;
        this.author = author;
        this.question = question;
        this.content = content;
        this.creationDate = new Date();
        this.voteList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.isAccepted = false;
    }

    @Override
    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentList;
    }

    @Override
    public void vote(User voter, VoteType type) {
        voteList.add(new Vote(voter, type));
        author.updateReputation(10*(type == VoteType.UPVOTE?1:-1));
    }

    @Override
    public int getVoteCount() {
        return voteList.stream()
                .mapToInt(v->v.getType()==VoteType.UPVOTE ? 1 : -1)
                .sum();
    }

    public void markAsAccepted(){
        if(isAccepted){
            throw new IllegalStateException("This answer is alreay accepted");
        }
        isAccepted = true;
        author.updateReputation(15);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }
}
