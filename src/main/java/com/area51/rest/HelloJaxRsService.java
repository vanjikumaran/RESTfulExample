

/**
 * Created with IntelliJ IDEA.
 * User: vanji
 * Date: 7/12/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */


package com.area51.rest;


import javax.net.ssl.SSLEngineResult;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


@Path("/hello")
public class HelloJaxRsService {

    @POST
    @Path("NoBodyNoContentType/{param}")
    public Response DoTest(@PathParam("param") String msg) {

        System.out.print("We have received everything");
        return Response.status(201).build();
    }

    @POST
    @Path("authenticate/{param}")
    public Response DoAuthenticate(@PathParam("param") String msg) {

        String output ="false";
        if (msg.equals("vanji")) {
            output = "true";
        } else if (msg.equals("urban"))  {
            output = "true";
        }

        System.out.println("system Authenticated Results: " + output);
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("post/{param}")
    public Response getPostMsg(@PathParam("param") String msg) {
        String output = "JAX-RS say Hello to: " + msg + "This is a post Message";
        System.out.println("System hit the POST");
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("world/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "JAX-RS say Hello to: " + msg;
        System.out.println("System hit the GET");
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("home/{param}")
    public Response getHomeMsg(@PathParam("param") String msg) {
        String output = "JAX-RS say Hello to: " + msg +" from home";
        System.out.println("System hit the GET");
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{param}")
    public Response getNoteMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;
        System.out.println("System hit the GET");
        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("context/people")
    public Response getPeopleDetail(){
        String output ="{\"objects\":[{\"nTSystemame\":\"structdata\",\"value\":\"24\"}]}";
        System.out.println("System hit the GET");
        return Response.status(200).type("application/json").entity(output).build();

    }

    @GET
    @Path("west/problem")
    public Response getWESTDetail(){
        String output = "{\"errorText\":\"\",\"errorCode\":\"0\",\"notFound\":\"false\",\"userID\":\"50713c5c-6a79-413e-9f97-00cdfada2a0c\",\"objects\":{\"name\":\"structdata\",\"value\":\"[{\\\"metaData\\\" : \\\"0.0.0.0\\\" , \\\"payloadData\\\" : \\\"pld\\\"}, {\\\"metaData\\\" : \\\"1.1.1.1\\\" , \\\"payloadData\\\" : \\\"pld2\\\"}]\",\"appName\":\"TestContextApp\",\"status\":\"A\",\"secondsToDie\":\"259161\"}}";
        return Response.status(200).type("application/json").entity(output).build();

    }


    @GET
    @Path("west2/problem2")
    public Response getWEST2Detail(){
        String output = "{\"westresponse\":{\"errorText\":\"\",\"errorCode\":\"0\",\"notFound\":\"false\",\"userID\":\"50713c5c-6a79-413e-9f97-00cdfada2a0c\",\"objects\":{\"name\":\"structdata\",\"value\":\"[{\\\"metaData\\\" : \\\"0.0.0.0\\\" , \\\"payloadData\\\" : \\\"pld\\\"}, {\\\"metaData\\\" : \\\"1.1.1.1\\\" , \\\"payloadData\\\" : \\\"pld2\\\"}]\",\"appName\":\"TestContextApp\",\"status\":\"A\",\"secondsToDie\":\"259161\"}}}";
        return Response.status(200).type("application/json").entity(output).build();

    }

    /**
     *
     * @return
     */
    @POST
    @Path("tracking/issues")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postTrackingIssue(InputStream incomingData){
        StringBuilder crunchifyBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                crunchifyBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received: " + crunchifyBuilder.toString());
        return Response.status(202).build();
    }



    /**
     *
     * @return
     */
    @POST
    @Path("tracking/issues2")
    public Response postTrackingIssue2(){
        System.out.println("Data Received two");
        return Response.status(202).build();
    }


    @PUT
    @Path("tracking/issues")
    public Response putTrackingIssues(){
        return Response.status(202).build();
    }
}
