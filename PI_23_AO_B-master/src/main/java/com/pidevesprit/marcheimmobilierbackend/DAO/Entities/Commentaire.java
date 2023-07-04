package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;
    private String textCommentaire;
    @Temporal(TemporalType.DATE)
    private Date dateCommentaire;
    @JsonIgnore
    @ManyToOne
    private User utilisateur;
    @JsonIgnore

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<React> reactslist;

}
