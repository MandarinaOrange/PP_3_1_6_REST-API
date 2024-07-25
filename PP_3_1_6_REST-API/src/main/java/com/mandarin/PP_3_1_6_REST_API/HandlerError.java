package com.mandarin.PP_3_1_6_REST_API;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class HandlerError extends DefaultResponseErrorHandler {
    @Override
    protected void handleError(ClientHttpResponse response, HttpStatusCode code) {

    }
}
