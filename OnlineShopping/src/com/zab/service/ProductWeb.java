package com.zab.service;


	

	import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.dao.ProductDao;
import com.shopping.model.ProductPojo;
		
		@Path("/ProductService")
		public class ProductWeb {

			ProductDao prodDao = new ProductDao();

			   @GET
			   @Path("/product")
			   @Produces(MediaType.APPLICATION_JSON)
			   public ProductPojo getProducts(){
			      return  prodDao.retrieve();
			   }
			   
			 
			   
			   @GET
				@Path("/{productid}/{productname}/{productamount}")
				public Response printMessage(@PathParam("productid") int productid, @PathParam("productname") String productname,@PathParam("productamount") int productamount) 
						 {

				   ProductPojo p =new ProductPojo();
				   p.setProductid(productid);
				   p.setProductname(productname);
				   p.setProductamount(productamount);
				  
				 
					String result = "Your Web-Service Says: " +productid + productname +productamount;
					

					return Response.status(200).entity(result).build();
			        
				}
		}
			


		

	
	


