package aoizora.controller;

import aoizora.converter.AuthorConverter;
import aoizora.model.author.AuthorDTO;
import aoizora.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/author")
@Controller
public class AuthorController
{
    private final AuthorService authorService;

    private final AuthorConverter authorConverter;

    public AuthorController(AuthorService authorService, AuthorConverter authorConverter)
    {
        this.authorService = authorService;
        this.authorConverter = authorConverter;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorDTO>> getAll()
    {
        return ResponseEntity.ok(authorConverter.convert(authorService.getAll()));
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO author)
    {
        return ResponseEntity.ok(authorConverter.convert(authorService.save(author.getFirstName(), author.getLastName())));
    }
}
