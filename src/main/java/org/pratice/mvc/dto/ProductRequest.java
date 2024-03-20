package org.pratice.mvc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
public record ProductRequest(
        String title, String description, float price, String imageUrl
) {
}
