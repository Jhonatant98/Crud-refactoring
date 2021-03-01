package co.com.sofka.crud.dominio;

import co.com.sofka.crud.Persistencia.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}
