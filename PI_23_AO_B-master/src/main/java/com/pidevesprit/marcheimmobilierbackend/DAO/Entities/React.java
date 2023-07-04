package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeReact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class React implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReact;
    @Enumerated(EnumType.STRING)
    private TypeReact typeReact;
    @Temporal(TemporalType.DATE)
    private Date dateReact;
    @JsonIgnore
    @ManyToOne
    private Commentaire comment;


}
