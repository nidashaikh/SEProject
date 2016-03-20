package com.zab.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.dao.CartDao;
import com.shopping.model.CartPojo;


@Path("/CartService")
public class CartWeb {
	CartDao cartDao = new CartDao();

	   @GET
	   @Path("/cart")
	   @Produces(MediaType.APPLICATION_JSON)
	   public CartPojo getProducts(){
	      return  cartDao.retrieve();
	   }
	   
	 
	   
	   @GET
		@Path("/{cart_no}/{customerid}/{productid}")
		public Response printMessage(@PathParam("cart_no") int cart_no, @PathParam("customerid") int customerid,@PathParam("productid") int productid) 
				 {

		   CartPojo c =new CartPojo();
		   c.setCart_no(cart_no);
		   c.setCustomerid(customerid);
		   c.setProductid(productid);
		  
		 
			String result = "Your Web-Service Says: " +cart_no + customerid +productid;
			

			return Response.status(200).entity(result).build();
	        
		}

}
