package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

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

public class CategorieMeubles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorieMeuble;
    private String libelle;
    @OneToMany(mappedBy = "meubleCategory", cascade = CascadeType.ALL)
    private List<Meuble> meubleList;

    @OneToMany(mappedBy = "categoriePrincipale", cascade = CascadeType.ALL)
    private List<CategorieMeubles> sousCategories;
    @ManyToOne
    private CategorieMeubles categoriePrincipale;

}
