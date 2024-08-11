package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.Author;
import com.ebay.westafrica.data.repositories.AuthorRepository;
import com.ebay.westafrica.dtos.requests.LoginAuthorRequest;
import com.ebay.westafrica.dtos.requests.RegisterAuthorRequest;
import com.ebay.westafrica.dtos.responses.LoginAuthorResponse;
import com.ebay.westafrica.dtos.responses.LogoutAuthorResponse;
import com.ebay.westafrica.dtos.responses.RegisterAuthorResponse;
import com.ebay.westafrica.exceptions.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    private boolean setLoggedOn;

    @Override
    public RegisterAuthorResponse registerAuthor(RegisterAuthorRequest registerAuthorRequest){
        Author author = new Author();
        author.setAuthorId("34");
        author.setFirstName(registerAuthorRequest.getFirstName());
        author.setLastName(registerAuthorRequest.getLastName());
        author.setEmail(registerAuthorRequest.getEmail());
        author.setPassword(registerAuthorRequest.getPassword());
        authorRepository.save(author);

        RegisterAuthorResponse registerAuthorResponse = new RegisterAuthorResponse();
        registerAuthorResponse.setMessage("Successfully registered as an Author");
        return registerAuthorResponse;
    }

    @Override
    public LoginAuthorResponse loginAuthor(LoginAuthorRequest loginAuthorRequest){
        for(Author author : authorRepository.findAll()) {
            if (Objects.equals(author.getEmail(), loginAuthorRequest.getEmail())) {
                if (Objects.equals(author.getPassword(), (loginAuthorRequest.getPassword()))) {
                setLoggedOn = true;
                authorRepository.save(author);
                }else {
                    throw new IllegalArgumentException("Author Email or Password is Incorrect, Retry Again");
                }
            }
        }
        LoginAuthorResponse loginAuthorResponse = new LoginAuthorResponse();
        loginAuthorResponse.setMessage("Author successfully logged in");
        return loginAuthorResponse;
    }

    @Override
    public LogoutAuthorResponse logoutAuthor(LoginAuthorRequest loginAuthorRequest) {
        for(Author author : authorRepository.findAll()) {
            if (Objects.equals(author.getEmail(), (loginAuthorRequest.getEmail()))) {
                if (Objects.equals(author.getPassword(),(loginAuthorRequest.getPassword()))) {
                    setLoggedOn = false;
                    authorRepository.save(author);
                }
            }
        }

        LogoutAuthorResponse logoutAuthorResponse = new LogoutAuthorResponse();
        logoutAuthorResponse.setMessage("Author successfully logged out");
        return logoutAuthorResponse;
    }
}
