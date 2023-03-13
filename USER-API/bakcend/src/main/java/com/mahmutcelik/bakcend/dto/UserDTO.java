package com.mahmutcelik.bakcend.dto;


public record UserDTO(
   String domain,
   String email,
   Integer experience,
   String name
) {
}