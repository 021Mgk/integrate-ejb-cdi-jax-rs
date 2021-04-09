package bean;

import com.sun.jersey.api.core.InjectParam;
import entity.Person;
import service.PersonService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.io.IOException;

@Named
@RequestScoped
@Path("/action")
public class Requestlet {
    @EJB
    private PersonService personService;

    //REQUEST
    @Path("/a")
    @GET
    @Produces("application/json")
    public void a(@InjectParam Person person, @Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException {
        System.out.println("ana a");
        personService.save(person);

        response.sendRedirect("/index.jsp");
    }

    //API
    @Path("/b")
    @GET
    @Produces("application/json")
    public Object b(@InjectParam Person person, @Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException {
        System.out.println("ana a");
        personService.save(person);
        return person;
    }
}
