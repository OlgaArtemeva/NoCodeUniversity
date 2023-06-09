package api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {
    String full_name;
    String email;
    String password;
    Boolean generate_magic_link;
}
