package com.ij34.cloud;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultFallbackProviderImpl implements FallbackFactory<Response> {

    @Override
    public Response create(Throwable cause) {
        return Response.error(cause.getMessage());
    }
}