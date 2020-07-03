package org.sid.cinema.web;

import lombok.Data;
import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name = "id") Long id) throws Exception{
        Film f = filmRepository.findById(id).get();
        String photo = f.getPhoto();
        File file = new File(
                "/home/joseline/Documents/WEB/cinema/src/main/resources/static/images/" + photo);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
    @PostMapping("/payerTickets")
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
        List<Ticket> listTickets = new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket ->{
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReserve(true);
            ticketRepository.save(ticket);
            listTickets.add(ticket);
        } );
        return listTickets;
    }
}
@Data
class  TicketForm{
    private String nomClient;
    private List<Long> tickets = new ArrayList<>();
}
