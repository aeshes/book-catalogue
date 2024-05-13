package aoizora.converter;

import aoizora.domain.author.Author;
import aoizora.model.author.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter implements Converter<Author, AuthorDTO>
{
    @Override
    public AuthorDTO convert(Author source) {
        var target = new AuthorDTO();

        target.setId(source.getId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());

        return target;
    }
}
