package com.interview.accountvalidations.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ProviderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Random random;

    public boolean validate(String url, String accountNumber) {

       // ResponseEntity<ProviderResponse> res = restTemplate.postForEntity(url, new ProviderRequest(accountNumber), ProviderResponse.class);
       // return res.getBody().isValid();
        return random.nextBoolean();
    }
}
