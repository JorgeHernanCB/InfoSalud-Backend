package com.inforcol.infosalud.exceptions;

import com.inforcol.infosalud.controllers.HolaMundoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(HolaMundoController.class);

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
        logger.error("ERROR: " + message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}