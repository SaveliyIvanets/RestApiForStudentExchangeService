package com.example.restApi.Sevices;

import com.example.restApi.DTO.CommentDTO;
import com.example.restApi.Repository.CommentByUserRepository;
import com.example.restApi.model.CommentByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentService {
    private CommentByUserRepository commentByUserRepository;

    @Autowired
    public void setCommentByUserRepository(CommentByUserRepository commentByUserRepository) {
        this.commentByUserRepository = commentByUserRepository;
    }

    public String doComment(CommentDTO commentDTO) {
        CommentByUser commentByUser = new CommentByUser();
        commentByUser.setComment(commentDTO.getComment());
        commentByUser.setIduser(commentDTO.getIduser());
        commentByUser.setIdcourse(commentDTO.getIdcourse());
        commentByUserRepository.save(commentByUser);
        return "OK";
    }

    public String doCommentToAnotherComment(CommentDTO commentDTO) {
        CommentByUser commentByUser = new CommentByUser();
        commentByUser.setComment(commentDTO.getComment());
        commentByUser.setIduser(commentDTO.getIduser());
        commentByUser.setIdcourse(commentDTO.getIdcourse());
        CommentByUser anotherComment = commentByUserRepository.findById(commentDTO.getIdanswerto()).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        anotherComment.setIdanswerto(commentDTO.getIdanswerto());
        commentByUserRepository.save(commentByUser);
        return "OK";
    }

    public HashMap<Long, CommentByUser> CommentListToHashMap(List<CommentByUser> commentByUsers) {
        HashMap<Long, CommentByUser> commentHashMap = new HashMap<>();
        for (CommentByUser comment : commentByUsers) {
            commentHashMap.put(comment.getId(), comment);
        }
        return commentHashMap;

        /*public List<CommentDTO> getCommentListByComment(){

        }*/
       /* public List<List<CommentDTO>> getCommentByIdCourse (Long idCourse){
            List<List<CommentByUser>> commentsList = new ArrayList<>();
            List<CommentByUser> allComents = commentByUserRepository.findByIdcourse(idCourse).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        }*/


    }

}
