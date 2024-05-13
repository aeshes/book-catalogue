package aoizora.model.book;

import aoizora.model.author.AuthorDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class BookDTO
{
    private Long id;

    private Long isbn;

    private String title;

    private List<AuthorDTO> authors;
}
