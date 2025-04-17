package com.example.restApi.Controllers;

import com.example.restApi.DTO.CommentDTO;
import com.example.restApi.Sevices.CommentService;
import com.example.restApi.model.CommentByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;
    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/addComment")
    public String addComment(@RequestBody CommentDTO commentDTO){
        commentDTO = commentService.checkCommentPath(commentDTO);
        return commentService.doComment(commentDTO);
    }
    @GetMapping("/allCommentByIdCourse")
    public List<List<CommentByUser>> allComment(@RequestParam("idcourse") Long idcourse){
        return commentService.getCommentByIdCourse(idcourse);
    }

}
