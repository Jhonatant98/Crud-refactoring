package co.com.sofka.crud.dominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<TodoDTO> list(){
     return UtilDTO.listTodoDTO(repository.findAll());
    }

    public TodoDTO save(TodoDTO todo){
        TodoDTO todoC = UtilDTO.convertTodoToTodoDTO(repository.save(UtilDTO.covertTodoDTOToTodo(todo)));
        return todoC;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public TodoDTO get(Long id){

        return UtilDTO.convertTodoToTodoDTO(repository.findById(id).orElseThrow());
    }

}
