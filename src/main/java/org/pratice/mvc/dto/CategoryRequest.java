package org.pratice.mvc.dto;

import lombok.Builder;

@Builder
public record CategoryRequest (String title, String description){

}
