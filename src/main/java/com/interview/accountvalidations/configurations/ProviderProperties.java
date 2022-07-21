package com.interview.accountvalidations.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Data
@ConfigurationProperties(prefix = "providers")
public class ProviderProperties {
    private HashMap<String, String> urls;
}
