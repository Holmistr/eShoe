package com.issuetracker.importer.reader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Jirka
 * Date: 11.12.13
 * Time: 12:22
 * To change this template use File | Settings | File Templates.
 */
public class RestReader {

    public String read(String requestUrl) {
        Client client = ClientBuilder.newClient();
        //TODO: handle more bugs
        String myURL = requestUrl;
        URL url = null;
        try {
            url = new URL(myURL);
        } catch (MalformedURLException e) {
            //TODO: change this
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        URI uri = null;
        try {
            uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
        } catch (URISyntaxException e) {
            //TODO: change this
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        WebTarget resourceTarget = client.target(uri.toString());
        Invocation invocation = resourceTarget.request("application/json").buildGet();

        String response = invocation.invoke(String.class);

        return response;
    }
}