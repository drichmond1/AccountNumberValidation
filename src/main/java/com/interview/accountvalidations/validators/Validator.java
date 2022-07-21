package com.interview.accountvalidations.validators;

import com.interview.accountvalidations.model.AccountValidationRequest;

public class Validator {
    public static boolean isValidRequest(AccountValidationRequest accountValidationRequest){
        return accountValidationRequest.getAccountNumber() != null
                && accountValidationRequest.getAccountNumber().length() > 0;
    }
}
