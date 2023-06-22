package enums;

import com.github.javafaker.Faker;
import lombok.*;

import java.io.File;


@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
public class Document {
    public String documentName;
    public String documentSource;
}
