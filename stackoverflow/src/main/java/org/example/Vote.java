package org.example;

public class Vote {
    User vote;
    VoteType type;

    public Vote(User vote, VoteType type) {
        this.vote = vote;
        this.type = type;
    }

    public User getVote() {
        return vote;
    }

    public VoteType getType() {
        return type;
    }
}
