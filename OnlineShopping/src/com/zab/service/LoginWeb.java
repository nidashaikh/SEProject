package com.zab.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.dao.CustomerDao;
import com.shopping.model.CustomerPojo;

@Path("/LoginService")
public class LoginWeb {
	@GET
	@Path("/user/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJson(@PathParam("email") String email,@PathParam("password") String password) {

		final CustomerDao usr = new CustomerDao();

		return Response.status(200).entity(usr).build();

	}
	
	@GET
	@Path("/{email}/{password}")
	public Response printMessage(@PathParam("email") String email,@PathParam("password") String password ) {
		CustomerPojo cust =new CustomerPojo();
		cust.setEmail(email);
		cust.setPassword(password);

		String result = "Your Web-Service Says: " + email +password;
		

		return Response.status(200).entity(result).build();
        
	}
	

}

	


