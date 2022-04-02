package com.nisum.users.service;

import java.io.IOException;

public interface RegexValidator {

    boolean emailPatternValidate(String email);
    boolean passPatternValidate(String password);
}
