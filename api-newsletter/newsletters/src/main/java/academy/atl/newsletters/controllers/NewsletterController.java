package academy.atl.newsletters.controllers;

import academy.atl.newsletters.models.Lead;
import academy.atl.newsletters.repository.EmailRepository;
import academy.atl.newsletters.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsletterController {
    @Autowired
    private EmailRepository repositorioDeEmail;
    @PostMapping("/api/newsletter")
    public String registrar(@RequestBody Lead lead) {
        String email = lead.getEmail();
        EmailValidator emailValidator = new EmailValidator();
        //Si esta función nos devuelve falso
        if (!emailValidator.esValido(email)) {
            return "El email no es valido";
        }
        repositorioDeEmail.guardarEmail(email);
        //si es verdadero
        return "Email guardado: " + email;
    }


    @PostMapping("/api/newsletter/unsuscribe")
    public String eliminar(@RequestBody Lead lead) {
        EmailValidator emailValidator = new EmailValidator();
        repositorioDeEmail.eliminarEmail(lead.getEmail());
        return "Email borrado: " + lead.getEmail();
    }

    @GetMapping("/api/newsletter")
    public List<Lead> listadoDeTodoLosEmail(Lead lead) {
        return repositorioDeEmail.listarTodosLosEmails();
    }

}
