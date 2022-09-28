package com.mcdonalds.ecommerce.model.dto.request;

import com.mcdonalds.ecommerce.model.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddClientRequest {

    private Integer documentID;
    private Gender gender;
    private String nameComplete;
}
