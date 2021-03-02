package co.com.sofka.crud.Web;

import co.com.sofka.crud.Persistencia.Todo;
import co.com.sofka.crud.dominio.TodoDTO;
import co.com.sofka.crud.dominio.TodoService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/todos")
    public Iterable<TodoDTO> list(){
        return service.list();
    }
    
    @PostMapping(value = "/todo")
    public TodoDTO save(@RequestBody TodoDTO todo){
        if(todo.getName().equals("")){
            return null;
        }
        return service.save(todo);
    }

    @PutMapping(value = "/todo")
    public TodoDTO update(@RequestBody TodoDTO todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/{id}/todo")
    public TodoDTO get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
