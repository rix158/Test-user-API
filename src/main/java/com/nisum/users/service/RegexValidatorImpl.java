package com.nisum.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class RegexValidatorImpl implements RegexValidator {

    @Autowired
    private Environment env;

    public String readFileConf() throws IOException {

        String contentC;

        try {

            File file = ResourceUtils.getFile("file:./application.properties");
            contentC = new String(Files.readAllBytes(file.toPath()));

        } catch (IOException ex) {
            throw new IOException(ex);
        }
        return contentC;
    }

    public boolean emailPatternValidate(String email) {
        String regexPatternE = Objects.requireNonNull(env.getProperty("app.email.valid.regex"));

        return Pattern.compile(regexPatternE)
                .matcher(email)
                .matches();
    }

    public boolean passPatternValidate(String password) {
        String regexPatternP = Objects.requireNonNull(env.getProperty("app.pass.valid.regex"));

        return Pattern.compile(regexPatternP)
                .matcher(password)
                .matches();
    }
}
