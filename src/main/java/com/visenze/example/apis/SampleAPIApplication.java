package com.visenze.example.apis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.visenze.example.apis.resources.HusbandResource;
import com.visenze.example.apis.resources.StoreResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class SampleAPIApplication extends Application<SampleAPIConfiguration> {
    public static void main(String[] args) throws Exception {
        new SampleAPIApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<SampleAPIConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
        initJsonMapper(bootstrap);
    }


    private void initJsonMapper(Bootstrap<SampleAPIConfiguration> bootstrap) {
        // reset objectMapper
        ObjectMapper mapper = bootstrap.getObjectMapper();
        // set output style of properties
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // set ignore properties which exist in JSON but not in Java beans
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // set to display readable date time instead of number only timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public void run(SampleAPIConfiguration configuration, Environment environment) {
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new HusbandResource());
        environment.jersey().register(new StoreResource());
    }
}
