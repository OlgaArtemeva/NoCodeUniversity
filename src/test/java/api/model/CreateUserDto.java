package api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserDto {
    String full_name;
    String email;
    String password;
    Object generate_magic_link;
    Object Magic_link;
}
