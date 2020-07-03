package org.sid.cinema.dao;

import org.sid.cinema.entities.Categorie;
import org.sid.cinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource //Toute les methodes herite de JPARepo sont accessible via une api Rest
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
