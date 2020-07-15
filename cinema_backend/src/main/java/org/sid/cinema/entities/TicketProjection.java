package org.sid.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj", types = {org.sid.cinema.entities.Ticket.class})
public interface TicketProjection {
    public Long getId();
    public String getNomClient();
    public double getPrix();
    public Integer getCodePayment();
    public boolean getReserve();
    public Place getPlace();
}
