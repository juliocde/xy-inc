package br.com.zup.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
 
import org.glassfish.jersey.client.ClientConfig;
 
public class ClientProductsDelete {
 
       public static void main(String args[]) {
                           
             ClientConfig clientConfig = new ClientConfig();
             
             Client client = ClientBuilder.newClient(clientConfig);
             
             WebTarget webTarget = client.target("http://localhost:8080/ZupServer");
             
             WebTarget resourceWebTarget = webTarget.path("rest");
             WebTarget deleteWebTarget = resourceWebTarget.path("products");
             WebTarget deleteWebTargetQuery = deleteWebTarget.queryParam("id", 1);
                           
             
             Invocation.Builder invocationBuilder = deleteWebTargetQuery.request();           
             Response response = invocationBuilder.delete();
             
             System.out.println(response.getStatus());
             
       }
     
}