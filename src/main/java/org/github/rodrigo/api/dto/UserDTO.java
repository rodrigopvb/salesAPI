package org.github.rodrigo.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
}

