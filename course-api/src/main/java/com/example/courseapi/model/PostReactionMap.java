package com.example.courseapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostReactionMap {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="post-id",referencedColumnName = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name="reaction_id",referencedColumnName = "reactionId")
    private Reaction reaction;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
