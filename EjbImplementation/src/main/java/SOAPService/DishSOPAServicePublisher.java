package SOAPService;

import javax.xml.ws.Endpoint;

public class DishSOPAServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/dishService", new DishSOAP());
    }
}
