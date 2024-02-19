package academy.atl.newsletters.repository;

import academy.atl.newsletters.models.Lead;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmailRepository {
    @PersistenceContext
    private EntityManager baseDeDatos; //conexión con la base de datos

    @Transactional
    public void guardarEmail(String emailDelUsuario) {
        String consultaSql = "INSERT INTO lead (email) VALUES (:paramEmail)";
        baseDeDatos.createNativeQuery(consultaSql)
                .setParameter("paramEmail", emailDelUsuario)
                .executeUpdate();
    }
    @Transactional
    public void eliminarEmail(String email) {
        String consultaSql = "DELETE FROM Lead WHERE email = :parametroEmail";
        baseDeDatos.createQuery(consultaSql)
                .setParameter("parametroEmail", email)
                .executeUpdate();
    }

    @Transactional
    public List<Lead> listarTodosLosEmails() {
        String consultaHql = "FROM Lead";
        return baseDeDatos.createQuery(consultaHql, Lead.class)
                .getResultList();
    }
}
