package com.ebay.westafrica.services;

import com.ebay.westafrica.dtos.requests.LoginAuthorRequest;
import com.ebay.westafrica.dtos.requests.RegisterAuthorRequest;
import com.ebay.westafrica.dtos.responses.LoginAuthorResponse;
import com.ebay.westafrica.dtos.responses.LogoutAuthorResponse;
import com.ebay.westafrica.dtos.responses.RegisterAuthorResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    RegisterAuthorResponse registerAuthor(RegisterAuthorRequest registerAuthorRequest);

    LoginAuthorResponse loginAuthor(LoginAuthorRequest loginAuthorRequest);

    LogoutAuthorResponse logoutAuthor(LoginAuthorRequest loginAuthorRequest);
}
