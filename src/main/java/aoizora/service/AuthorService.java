package aoizora.service;

import aoizora.domain.author.Author;
import aoizora.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll()
    {
        return authorRepository.findAll();
    }

    public Author save(String firstName, String lastName)
    {
        var author = new Author();

        author.setFirstName(firstName);
        author.setLastName(lastName);

        return authorRepository.save(author);
    }
}
