package net.guz.flowersmanagerapi.security.awt.exception;

import javax.xml.bind.ValidationException;

public class JwtValidationException extends ValidationException {
    public JwtValidationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtValidationException(String msg) {
        super(msg);
    }
}
