package api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EndPoint {
    CREATE_USER("/v1/api/users"),
    DELETE_USER("/v1/api/users/{email}");
    private final String value;
}
