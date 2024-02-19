package academy.atl.newsletters.validators;

public class EmailValidator {
    public boolean esValido(String email) {
        //Comprobar varias cosas que debe contener el email
        if (!email.contains("@")){ // Si no contiene
            return false;
        }
        if (!email.contains(".")){
            return false;
        }
        if (email.endsWith("@")){ // Termina con @ no es valido
            return false;
        }
        if (email.contains(" ")){ // Si contiene espacios en blanco
            return false;
        }
        if (email.length() > 255){ // No debe pasar de esta longitud
            return false;
        }
        return true; //si nunguna se cumpla entonces esta bien
    }
}
