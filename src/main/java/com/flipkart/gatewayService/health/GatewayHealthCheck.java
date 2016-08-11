package com.flipkart.gatewayService.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by praveenkumar.g on 10/08/16.
 */
public class GatewayHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
