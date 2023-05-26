package com.production.bannermessage.Requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BannerMessageRequest {

    @NotNull
    private String env;

    @NotNull
    private String cguid;

    private String experimentName;

    @NotNull
    private Long setiId;

    @NotNull
    private Long variantId;
}

