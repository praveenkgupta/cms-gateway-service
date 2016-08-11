package com.flipkart.gatewayService.guice;

import com.flipkart.gateway.config.GatewayConfiguration;
import com.flipkart.gateway.guice.GatewayModule;
import com.flipkart.gatewayService.configuration.GatewayServiceConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;

/**
 * Created by praveenkumar.g on 10/08/16.
 */
public class GatewayServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new GatewayModule());
    }

    @Provides
    @Inject
    public GatewayConfiguration getGatewayConfiguration(GatewayServiceConfiguration gatewayServiceConfiguration) {
        return gatewayServiceConfiguration.getGatewayConfiguration();
    }
}
