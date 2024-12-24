package my.reasolutions.rea_sys.exceptions.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

@Getter
public enum BusinessErrorCodes {

    NO_CODE(0, NOT_IMPLEMENTED, "No code"),
    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "New password does not match"),
    ACCOUNT_LOCKED(302, FORBIDDEN, "User account is locked"),
    ACCOUNT_DISABLED(303, FORBIDDEN, "User account disabled"),
    BAD_CREDENTIALS(304, FORBIDDEN, "Login email and / or password is incorrect"),
    DB_ERROR(305, BAD_REQUEST, "Database error (User exist)"),
    ;

    private final int code;
    private final String description;
    private final HttpStatus httpStatusCode;

    BusinessErrorCodes(
            int code,
            HttpStatus httpStatusCode,
            String description
            ) {
        this.code = code;
        this.description = description;
        this.httpStatusCode = httpStatusCode;
    }
}
