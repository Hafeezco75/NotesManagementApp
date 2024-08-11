package com.ebay.westafrica.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    boolean message;
    Object userResponse;
}
