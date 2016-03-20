package com.zab.service;


	


	import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.dao.CustomerDao;
import com.shopping.model.CustomerPojo;

	
	@Path("/CustomerService")
	public class UserWeb {

		CustomerDao customerDao = new CustomerDao();

		   @GET
		   @Path("/user")
		   @Produces(MediaType.APPLICATION_JSON)
		   public CustomerPojo getUser(){
		      return  customerDao.retrieve();
		   }
		   
		 
		   
		   @GET
			@Path("/{customerid}/{customername}/{creditcardno}/{address}")
			public Response printMessage(@PathParam("customerid") int customerid, @PathParam("customername") String customername,@PathParam("creditcardno") int creditcardno, @PathParam("address") String address) {

			   CustomerPojo cust =new CustomerPojo();
			   cust.setCustomerid(customerid);
			   cust.setCustomername(customername);
			   cust.setCreditcardno(creditcardno);
			   cust.setAddress(address);
			 
				String result = "Your Web-Service Says: " +customerid + customername +creditcardno +address;
				

				return Response.status(200).entity(result).build();
		        
			}
		   }  
		


	

	