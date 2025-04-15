package com.example.restApi.Sevices;

import com.example.restApi.DTO.CommentDTO;
import com.example.restApi.Repository.CommentByUserRepository;
import com.example.restApi.model.CommentByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Collections;
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
        commentByUser.setIdanswerto(commentDTO.getIdanswerto());
        commentByUserRepository.save(commentByUser);
        return commentByUser.getId().toString();
    }


    public HashMap<Long, CommentByUser> CommentListToHashMap(List<CommentByUser> commentByUsers) {
        HashMap<Long, CommentByUser> commentHashMap = new HashMap<>();
        for (CommentByUser comment : commentByUsers) {
            commentHashMap.put(comment.getId(), comment);
        }
        return commentHashMap;
    }
    public List<List<CommentByUser>> getCommentByIdCourse(Long idCourse) {

        List<Long> visitedCommentList = new ArrayList<>();
        List<List<CommentByUser>> returnCommentList = new ArrayList<>();
        List<CommentByUser> allComents = commentByUserRepository.findByIdcourse(idCourse).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        HashMap<Long, CommentByUser> commentHashMap = CommentListToHashMap(commentByUserRepository.findByIdcourse(idCourse).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404))));
        Collections.reverse(allComents);


        for(CommentByUser comment : allComents){
            List<CommentByUser> commentList = new ArrayList<>();
            if(visitedCommentList.contains(comment.getId())){
                continue;
            }
            while(comment.getIdanswerto() != null){
                commentList.add(comment);
                visitedCommentList.add(comment.getId());
                comment = commentHashMap.get(comment.getIdanswerto());
            }
            commentList.add(comment);
            visitedCommentList.add(comment.getId());
            Collections.reverse(commentList);

            returnCommentList.add(commentList);
            Collections.reverse(returnCommentList);
        }
        return returnCommentList;



    }


}


