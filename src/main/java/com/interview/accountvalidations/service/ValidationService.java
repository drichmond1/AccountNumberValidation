package com.interview.accountvalidations.service;

import com.interview.accountvalidations.configurations.ProviderProperties;
import com.interview.accountvalidations.exceptions.InvalidInputException;
import com.interview.accountvalidations.model.AccountValidationRequest;
import com.interview.accountvalidations.model.ProviderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ValidationService {

    @Autowired
   private ProviderService providerService;
   @Autowired
   private ProviderProperties providerProperties;


    public List<ProviderResponse> validate(AccountValidationRequest accountValidationRequest) throws InvalidInputException {

        Map<String, String> providerUrls = providerProperties.getUrls();
        List<ProviderResponse> response = new ArrayList<>();
        if(accountValidationRequest.getProviders() != null && !accountValidationRequest.getProviders().isEmpty()){
            for(String provider : accountValidationRequest.getProviders()){
                String url = providerUrls.get(provider);
                if(url == null){
                    throw new InvalidInputException("invalid provider provided");
                }
               boolean isValid = providerService.validate(providerUrls.get(provider), accountValidationRequest.getAccountNumber());
               response.add(new ProviderResponse(provider, isValid));
            }
        }

        else{
            for(String provider : providerUrls.keySet()){
                boolean isValid = providerService.validate(providerUrls.get(provider), accountValidationRequest.getAccountNumber());
                response.add(new ProviderResponse(provider, isValid));
          }
        }

    return response;
    }
}
