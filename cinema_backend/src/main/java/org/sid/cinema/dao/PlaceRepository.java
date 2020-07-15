package org.sid.cinema.dao;

import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.Place;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@RepositoryRestResource
@CrossOrigin("*")
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
