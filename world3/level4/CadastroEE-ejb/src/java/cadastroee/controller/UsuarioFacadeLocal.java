package cadastroee.controller;

import cadastroee.model.Usuario;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuarios);

    void edit(Usuario usuarios);

    void remove(Usuario usuarios);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
}
