package com.interview.accountvalidations.controller;

import com.interview.accountvalidations.exceptions.InvalidInputException;
import com.interview.accountvalidations.model.AccountValidationRequest;
import com.interview.accountvalidations.model.ServiceResponse;
import com.interview.accountvalidations.service.ValidationService;
import com.interview.accountvalidations.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("v1/accounts")
public class AccountValidationController {

    @Autowired
    ValidationService validationService;

    @PostMapping("/validate")
    public ServiceResponse validateAccounts(@RequestBody AccountValidationRequest accountValidationRequest) throws InvalidInputException {
       if(!Validator.isValidRequest(accountValidationRequest)) {
           throw new InvalidInputException("account Number required");
       }
       else{
           return new ServiceResponse(validationService.validate(accountValidationRequest));
       }
    }
}
