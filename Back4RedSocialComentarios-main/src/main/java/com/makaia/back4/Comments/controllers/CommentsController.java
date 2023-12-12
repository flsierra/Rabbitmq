package com.makaia.back4.Comments.controllers;

import com.makaia.back4.Comments.services.CommentService;
import com.makaia.back4.Comments.dtos.CrearCommentsDTO;
import com.makaia.back4.Comments.entities.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentsController {
    private CommentService service;


    @Autowired
    public CommentsController(CommentService service) {
        this.service = service;
    }



  @PostMapping()
    public Comentario crearComentario(@RequestBody CrearCommentsDTO dtocom) {
        return this.service.crearComent(dtocom);
    }

    @GetMapping()
    public List<Comentario> listarComentarios(){
        return  this.service.listar();
    }


}
