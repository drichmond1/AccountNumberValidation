package com.interview.accountvalidations.model;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountValidationRequest {
    private String accountNumber;
    private List<String> providers;
}
