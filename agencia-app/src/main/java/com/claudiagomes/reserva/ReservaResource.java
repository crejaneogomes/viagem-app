package com.claudiagomes.reserva;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/reserva")
public class ReservaResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Reserva> get() {
    return Reserva.listAll();
  }

  @POST
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response newReserva(Reserva reserva) {
    reserva.id = null;
    Reserva.persist(reserva);
    return Response.status(Status.CREATED).entity(reserva).build();
  }
}
