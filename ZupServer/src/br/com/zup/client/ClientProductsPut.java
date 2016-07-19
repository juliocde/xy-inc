package br.com.zup.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import br.com.zup.model.Products;
 
public class ClientProductsPut {
       public static void main(String args[]) {
             
             Products products = new Products();
             products.setId(1);
             products.setName("Produto 1");
             products.setDescription("Teste Produto 1");
             products.setPrice(12.5);
             products.setCategory("Categoria 1");
             
             Client client = ClientBuilder.newClient();
             
             WebTarget webTarget = client.target("http://localhost:8080/ZupServer");
             WebTarget resourceWebTarget = webTarget.path("rest");
             
             WebTarget deleteWeb = resourceWebTarget.path("products");
             Invocation.Builder deleteInvocationBuilder = deleteWeb.request();
             Response putResponse = deleteInvocationBuilder.put(Entity.entity(products, MediaType.APPLICATION_JSON_TYPE));
 
             System.out.println(putResponse.getStatus());
             System.out.println(putResponse.readEntity(String.class));
             
       }
       
}