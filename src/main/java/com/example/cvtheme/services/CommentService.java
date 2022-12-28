package com.example.cvtheme.services;

import com.example.cvtheme.entities.Comment;
import com.example.cvtheme.payload.requests.CommentRequest;
import com.example.cvtheme.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * @return List<Comment>
     */
    public List<Comment> findAllComment(){
        return (List<Comment>)commentRepository.findAll();
    }

    /**
     * @param commentId
     * @return Comment
     */
    public Comment findCommentById(Long commentId){
        return commentRepository.findById(commentId).orElse(null);
    }

    /**
     * @param commentRequest
     * @return Comment
     */
    public Comment saveComment(CommentRequest commentRequest){
        Comment comment = new Comment();
        comment.setCommentType(commentRequest.getType());
        comment.setCmeId(commentRequest.getCmeId());
        comment.setMessage(commentRequest.getContent());
        comment.setMotivationLetterId(commentRequest.getLetterId());
        comment.setResumeId(commentRequest.getCvId());
        return commentRepository.save(comment);

    }

    /**
     * @param commentRequest
     * @param commentId
     * @return
     */

    @Transactional
    public Comment updateComment(CommentRequest commentRequest, Long commentId){
        Comment comment = findCommentById(commentId);
        if (comment != null){
            if (commentRequest.getContent() != null) {
                comment.setMessage(commentRequest.getContent());
            }
            if (commentRequest.getType() != null) {
                comment.setCommentType(commentRequest.getType());
            }
            if (commentRequest.getCvId() != null) {
                comment.setResumeId(commentRequest.getCvId());
            }
            if (commentRequest.getLetterId() != null) {
                comment.setMotivationLetterId(commentRequest.getLetterId());
            }
            if (commentRequest.getCmeId() != null) {
                comment.setCmeId(commentRequest.getCmeId());
            }

        }
        return comment;
    }
    /**
     * @param commentId
     */
    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }
}
