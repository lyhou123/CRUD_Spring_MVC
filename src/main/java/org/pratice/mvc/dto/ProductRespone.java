package org.pratice.mvc.dto;

import lombok.Builder;

@Builder
public record ProductRespone
        (int id,String title, String description, float price, String imageUrl){

}
