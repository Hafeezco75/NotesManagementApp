package com.ebay.westafrica.web;

import com.ebay.westafrica.dtos.requests.LoginAuthorRequest;
import com.ebay.westafrica.dtos.requests.RegisterAuthorRequest;
import com.ebay.westafrica.dtos.responses.ApiResponse;
import com.ebay.westafrica.dtos.responses.LoginAuthorResponse;
import com.ebay.westafrica.dtos.responses.LogoutAuthorResponse;
import com.ebay.westafrica.dtos.responses.RegisterAuthorResponse;
import com.ebay.westafrica.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;


    @PostMapping("/registerAuthor")
    public ResponseEntity<?> registerAuthor(RegisterAuthorRequest registerAuthorRequest) {
        try {
            RegisterAuthorResponse registerAuthorResponse = authorService.registerAuthor(registerAuthorRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerAuthorResponse), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/loginAuthor")
    public ResponseEntity<?> loginAuthor(@RequestBody LoginAuthorRequest loginAuthorRequest) {
        try {
            LoginAuthorResponse loginAuthorResponse = authorService.loginAuthor(loginAuthorRequest);
            return new ResponseEntity<>(new ApiResponse(true, loginAuthorResponse), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/logoutAuthor")
    public ResponseEntity<?> logoutAuthor(@RequestBody LoginAuthorRequest loginAuthorRequest) {
        try {
            LogoutAuthorResponse logoutAuthorResponse = authorService.logoutAuthor(loginAuthorRequest);
            return new ResponseEntity<>(new ApiResponse(true, logoutAuthorResponse), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }
}
