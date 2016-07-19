package br.com.zup.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.zup.model.Products;
 
 
public class ClientProductsGetById {
 
       public static void main(String args[]) {
                                        
             Client client = ClientBuilder.newClient();
             
             WebTarget webTarget = client.target("http://localhost:8080/ZupServer");
             
             WebTarget resourceWebTarget = webTarget.path("rest");
             WebTarget pathdWebTarget = resourceWebTarget.path("products");
             WebTarget pathdWebTargetQuery = pathdWebTarget.queryParam("id", 1);
                           
             
             Invocation.Builder invocationBuilder = pathdWebTargetQuery.request(MediaType.APPLICATION_JSON_TYPE);
             
             Response response = invocationBuilder.get();
             
             System.out.println(response.getStatus());
             Products products = response.readEntity(Products.class);
             
             System.out.println(products.getId());
             System.out.println(products.getName());
             System.out.println(products.getDescription());
             System.out.println(products.getPrice());
             System.out.println(products.getCategory());
             
       }   
}