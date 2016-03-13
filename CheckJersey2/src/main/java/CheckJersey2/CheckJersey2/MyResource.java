package CheckJersey2.CheckJersey2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
	@GET
	@Path("/{param}/{param2}")
	
	public String printMessage(@PathParam("param") String username,@PathParam("param2") String pass) {

		String result = "Your Web-Service Says: " + username+pass;
		if(username.equalsIgnoreCase("nida")&&pass.equalsIgnoreCase("123"))
		{
			System.out.println("successful login");
			return "Succesful login";
		}
		else
		{
			System.out.println("not a user");
		}
		return ""+result;
//		return Response.status(200).entity(result).build();

	}

}
