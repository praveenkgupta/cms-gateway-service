package com.flipkart.gatewayService;

import com.flipkart.gatewayService.configuration.GatewayServiceConfiguration;
import com.flipkart.gatewayService.guice.GatewayServiceModule;
import com.flipkart.gatewayService.health.GatewayHealthCheck;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by praveenkumar.g on 10/08/16.
 */
public class GatewayApplication extends Application<GatewayServiceConfiguration> {
    private static final GuiceBundle<GatewayServiceConfiguration> guiceBundle = GuiceBundle.<GatewayServiceConfiguration>newBuilder()
            .setConfigClass(GatewayServiceConfiguration.class)
            .addModule(new GatewayServiceModule())
            .enableAutoConfig("com.flipkart.gatewayService")
            .build(Stage.DEVELOPMENT);

    @Override
    public void initialize(Bootstrap<GatewayServiceConfiguration> bootstrap) {
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(GatewayServiceConfiguration gatewayServiceConfiguration, Environment environment) throws Exception {
        GatewayHealthCheck gatewayHealthCheck = new GatewayHealthCheck();
        environment.healthChecks().register("AppHealthCheck", gatewayHealthCheck);
    }

    public static void main(String[] args) throws Exception {
        new GatewayApplication().run(args);
    }
}
