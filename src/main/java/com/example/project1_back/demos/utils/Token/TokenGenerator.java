package com.example.project1_back.demos.utils.Token;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {
    public String generate(String... strings);

    public String userTokenUtils(String username,String password);

    public boolean verify(String token);
}
