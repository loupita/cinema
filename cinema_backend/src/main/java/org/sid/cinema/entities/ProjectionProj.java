package org.sid.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Projection(name = "P1", types = {org.sid.cinema.entities.Projection.class})
public interface ProjectionProj {
    public Long getId();
    public double getPrix();
    public Date getDateProjection();

    public Salle getSalle();
    public Film getFilm();
    public Seance getSeance();
    public Collection<Ticket> getTickets();
}
