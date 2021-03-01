package co.com.sofka.crud.Web;

import co.com.sofka.crud.Persistencia.Todo;
import co.com.sofka.crud.dominio.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "todos")
    public Iterable<Todo> list(){
        return service.list();
    }
    
    @PostMapping(value = "todo")
    public ResponseEntity<Todo> save(@ModelAttribute @Valid Todo todo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(service.save(todo), HttpStatus.CREATED);
    }

    @PutMapping(value = "todo")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
