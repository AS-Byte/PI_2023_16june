package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ICommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private ICommentaireService commentRest;

    /*@GetMapping("/allCommentaire")
    @ResponseBody
    public List<Commentaire> getAllCommentaire() { 
        return commentRest.getAllCommentaire();
    }
    @GetMapping("/commentaire/{commentaire_id}")
    @ResponseBody
    public Commentaire getCommentaire(@PathVariable("commentaire_id") Long commentaireId) {
        return commentRest.getCommentaire(commentaireId);
    }
    @PostMapping("/addCommentaire")
    @ResponseBody
    public Commentaire addAnnonce(@RequestBody Commentaire cm) {
        return commentRest.addCommentaire(cm);
    }
    
    @DeleteMapping("/deleteCommentaire/{commentaire_id}")
    @ResponseBody
    public void deleteAnnonce(@PathVariable("commentaire_id") Long commentaireId) {
        commentRest.deleteCommentaire(commentaireId);
    }

  
    @PutMapping("/updateCommentaire")
    @ResponseBody
    public Commentaire updateCommentaire(@RequestBody Commentaire commentaire) {
        return commentRest.updateCommentaire(commentaire);
    }*/
}
