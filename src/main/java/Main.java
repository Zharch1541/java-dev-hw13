import entity.Client;
import entity.Planet;
import entity.Ticket;
import services.ClientCrudService;
import services.PlanetCrudService;
import services.TicketCrudService;

public class Main {
    public static void main(String[] args) {
        TicketCrudService ticketService = new TicketCrudService();
        ticketService.createTicket(prepareTicket(4L, "PLU", "SAT"));
    }

    private static Client prepareClient(String name) {
        Client client = new Client();
        client.setName(name);
        return client;
    }

    private static Client clientToDelete(Long id, String name) {
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        return client;
    }

    private static Planet preparePlanet(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);
        return planet;
    }

    private static Planet planetToDelete(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);
        return planet;
    }

    private static Ticket prepareTicket(Long clientId, String fromPlanetId, String toPlanetId) {

        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        Ticket ticket = new Ticket();

        Client client = clientService.getClientById(clientId);
        Planet fromPlanet = planetService.getPlanetById(fromPlanetId);
        Planet toPlanet = planetService.getPlanetById(toPlanetId);

        if (client != null && fromPlanet != null && toPlanet != null) {
            ticket.setClient(client);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);
        } else {
            throw new IllegalArgumentException("One or more entities were not found.");
        }
        return ticket;
    }
}
