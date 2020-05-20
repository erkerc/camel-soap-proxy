package com.redworks.integration.examples;

import org.apache.camel.Exchange;

public class MySoapActionProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        String action = exchange.getIn().getHeader("SOAPAction", String.class);

        System.out.println(action);

        String newAction = action.replaceAll("[\n\r]", "").replaceAll(".*:(.*)Request .*", "$1");

        exchange.getIn().setHeader("SOAPAction", newAction);

    }

}
