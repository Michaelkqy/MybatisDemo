package com.huitu.api.samples;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by zhw on 2016/12/16.
 */
public class ApiApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public ApiApplication(){

        register(RequestContextFilter.class);

        //注册rest服务
        packages("com.huitu.api.samples");

        register(JacksonFeature.class);
        register(MultiPartFeature.class);

        EncodingFilter.enableFor(this, GZipEncoder.class);
    }
}