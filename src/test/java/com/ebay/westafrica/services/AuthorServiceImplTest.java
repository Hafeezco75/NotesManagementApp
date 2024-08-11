package com.ebay.westafrica.services;

import com.ebay.westafrica.dtos.requests.LoginAuthorRequest;
import com.ebay.westafrica.dtos.requests.RegisterAuthorRequest;
import com.ebay.westafrica.dtos.responses.LoginAuthorResponse;
import com.ebay.westafrica.dtos.responses.LogoutAuthorResponse;
import com.ebay.westafrica.dtos.responses.RegisterAuthorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AuthorServiceImplTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void testThatAuthorCanBeRegistered() {
        RegisterAuthorRequest registerAuthorRequest = new RegisterAuthorRequest();
        registerAuthorRequest.setId("24");
        registerAuthorRequest.setFirstName("Micheal");
        registerAuthorRequest.setLastName("Jiggle");
        registerAuthorRequest.setEmail("michealjiggle@doe.com");
        registerAuthorRequest.setPassword("12456Hag");
        RegisterAuthorResponse registerAuthorResponse = authorService.registerAuthor(registerAuthorRequest);
        assertThat(registerAuthorResponse.getMessage()).isEqualTo("Successfully registered as an Author");
    }

    @Test
    public void testThatAuthorCanLogin() {
        LoginAuthorRequest loginAuthorRequest = new LoginAuthorRequest();
        loginAuthorRequest.setEmail("michealjiggle@doe.com");
        loginAuthorRequest.setPassword("12456Hag");
        LoginAuthorResponse loginAuthorResponse = authorService.loginAuthor(loginAuthorRequest);
        assertThat(loginAuthorResponse).isNotNull();
        assertThat(loginAuthorResponse.getMessage()).isEqualTo("Author successfully logged in");
    }

    @Test
    public void testThatAuthorCanLogout() {
        LoginAuthorRequest loginAuthorRequest = new LoginAuthorRequest();
        loginAuthorRequest.setEmail("michealjiggle@doe.com");
        loginAuthorRequest.setPassword("12456Hag");
        LogoutAuthorResponse logoutAuthorResponse = authorService.logoutAuthor(loginAuthorRequest);
        assertThat(logoutAuthorResponse).isNotNull();
        assertThat(logoutAuthorResponse.getMessage()).isEqualTo("Author successfully logged out");
    }

    @Test
    public void testThatAuthorEmailAndPasswordCannotBeNull() {

    }
}
