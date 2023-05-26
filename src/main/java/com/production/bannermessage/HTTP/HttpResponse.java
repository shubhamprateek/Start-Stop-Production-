package com.production.bannermessage.HTTP;

import java.util.List;
import lombok.Data;

@Data

public class HttpResponse {
    private long statusCode;
    private String message;
    private List<String> validation;
}