package br.com.zup.server;

import java.sql.SQLException;
 

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
 

import br.com.zup.database.Connect;
import br.com.zup.model.Products;

/**
 * Classe REST Products com metodos GET, POST, PUT e DELETE.
 * Foram criados 3 metodos GET: um para retorno do tipo texto/html, os outros dois com retorno em JSON.
 * @author Julio Escobar
 * @since 19/07/2016
 */
 
@Path("/products")
public class RestProducts {
	
 
	   //Metodo responsavel por listar um produto por id, em formato texto/html.
       @GET
       @Produces(MediaType.TEXT_HTML)
       public String getProductsHTML(@QueryParam("id") int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             Connect connect = new Connect();
             Products products = connect.getProductsById(id);
             connect.closeConnection();
             return "<HTML><BODY>" + products.getName() + "</BODY></HTML>";
       }
 
       //Metodo responsavel por listar um produto por id.
       @GET
       @Produces(MediaType.APPLICATION_JSON)
       public Products getProductsById(@QueryParam("id") int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             Connect connect = new Connect();
             Products products = connect.getProductsById(id);
             connect.closeConnection();
             return products;
       }
       
       //Metodo responsavel por listar todos os produtos.
       @GET
       @Produces(MediaType.APPLICATION_JSON)
       public Products getProducts() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             Connect connect = new Connect();
             Products products = connect.getProducts();
             connect.closeConnection();
             return products;
       }
       
       //Metodo responsavel por criar um produto.
       @POST
       public Response createProducts(Products products) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             Connect connect = new Connect();
             connect.insertProducts(products);
             connect.closeConnection();
             return Response.status(Status.OK).build();
       
       }
       //Metodo responsavel por deletar um produto.
       @DELETE
       public Response deleteProducts(@QueryParam("id") int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             Connect connect = new Connect();
             connect.deleteProducts(id);
             connect.closeConnection();
             return Response.status(Status.OK).build();
       }
       
       //Metodo responsavel por editar um produto.
       @PUT
       public Response editProducts(Products products) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             Connect connect = new Connect();
             connect.editProducts(products);
             connect.closeConnection();
             return Response.status(Status.OK).build();
       }
}