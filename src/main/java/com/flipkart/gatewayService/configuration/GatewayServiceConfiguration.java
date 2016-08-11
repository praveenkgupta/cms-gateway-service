package com.flipkart.gatewayService.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.gateway.config.GatewayConfiguration;
import io.dropwizard.Configuration;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by praveenkumar.g on 10/08/16.
 */
@Data
@NoArgsConstructor
public class GatewayServiceConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    private String appName;

    @JsonProperty
    private GatewayConfiguration gatewayConfiguration;
}
