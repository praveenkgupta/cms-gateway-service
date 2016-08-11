package com.flipkart.gatewayService.model;

import com.flipkart.gateway.constants.MetaDataKeys;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Map;

/**
 * Created by praveenkumar.g on 10/08/16.
 */
@Data
@NoArgsConstructor
public class GatewayRequest {
    private File file;
    private Map<MetaDataKeys, Object> metadata;

}
