package com.interview.accountvalidations.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("isValid")
    private boolean isValid;
}
