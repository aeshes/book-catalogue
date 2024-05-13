package aoizora.model.author;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthorDTO
{
    private Long id;

    private String firstName;

    private String lastName;
}
