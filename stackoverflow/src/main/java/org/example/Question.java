package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable{
    int id;
    String title;
    String content;
    User author;
    Date creationDate;
    List<Answer> answerList;
    List<Comment> commentList;
    List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(int id,String title, String content, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    public synchronized  void addAnswer(Answer answer){
        if(!answerList.contains(answer))
        {
            answerList.add(answer);
        }
    }

    public synchronized  void acceptAnswer(Answer answer)
    {
        this.acceptedAnswer = answer;
        answer.markAsAccepted();
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
        votes.add(new Vote(voter, type));
        author.updateReputation((type==VoteType.UPVOTE ? 1 : -1));
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(v->v.getType()==VoteType.UPVOTE?1:-1)
                .sum();
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }
}
