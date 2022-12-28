package com.example.cvtheme.controllers;

import com.example.cvtheme.payload.requests.CommentRequest;
import com.example.cvtheme.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllComments(){
        return ResponseEntity.ok(Map.of("status", true, "message", "Comments found successfully", "data", commentService.findAllComment()));
    }

    @GetMapping(path = "{commentId}")
    public ResponseEntity<Map<String, Object>> findCommentById(@PathVariable("commentId") Long commentId){
        return ResponseEntity.ok(Map.of("status", true, "message", "Comment found successfully", "data", commentService.findCommentById(commentId)));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveComment(@RequestBody CommentRequest commentRequest){
        return ResponseEntity.ok(Map.of("status", true, "message", "Comment saved successfully", "data", commentService.saveComment(commentRequest)));
    }

    @PutMapping(path = "{commentId}")
    public ResponseEntity<Map<String, Object>> updateComment(@RequestBody CommentRequest commentRequest, @PathVariable("commentId") Long commentId){
        return ResponseEntity.ok(Map.of("status", true, "message", "Comment updated successfully", "data", commentService.updateComment(commentRequest, commentId)));
    }

    @DeleteMapping(path = "{commentId}")
    public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(Map.of("status", true, "message", "Comment deleted successfully"));
    }
}
