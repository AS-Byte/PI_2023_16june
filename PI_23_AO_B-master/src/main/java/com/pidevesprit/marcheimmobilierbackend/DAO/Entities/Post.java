package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String titre;
    private String description;
    @JsonIgnore
    @OneToMany
    private List<React> listReact;
    @JsonIgnore
    @OneToMany
    private List<Commentaire> listCommentaire;
    @JsonIgnore
    @ManyToOne
    private User user;
}
