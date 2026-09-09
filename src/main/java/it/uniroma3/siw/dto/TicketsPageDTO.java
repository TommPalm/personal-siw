package it.uniroma3.siw.dto;


import java.util.List;

public class TicketsPageDTO {

    private CarDTO car;
    private List<TicketDTO> tickets;

    public TicketsPageDTO(CarDTO car, List<TicketDTO> tickets) {
        this.car = car;
        this.tickets = tickets;
    }

    public CarDTO getCar() {
        return car;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }
}
