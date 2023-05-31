package api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EndPoint {
    CREATE_USER("/v1/api/users"),
    DELETE_USER("/v1/api/users/johnr@gmail.com");

    private final String value;
}
