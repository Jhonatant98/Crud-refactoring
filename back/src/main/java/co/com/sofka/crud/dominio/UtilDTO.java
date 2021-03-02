package co.com.sofka.crud.dominio;

import co.com.sofka.crud.Persistencia.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UtilDTO {

    public static TodoDTO convertTodoToTodoDTO(Todo todo){
        return new TodoDTO(todo.getId(), todo.getName(), todo.isCompleted(), todo.getGroupListId());
    }

    public static Todo covertTodoDTOToTodo(TodoDTO todoDTO){
        Todo todo = new Todo();
        todo.setId(todoDTO.getId());
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());
        todo.setGroupListId(todoDTO.getGroupListId());
        return  todo;
    }

    public static  Iterable<TodoDTO> listTodoDTO(Iterable<Todo> listTodo){
        List<TodoDTO> listDTO = new ArrayList<>();
        //java 7
        /*
        for(Todo todo: listTodo){
            TodoDTO auxDTO = new TodoDTO();
              auxDTO.setId(todo.getId());
              auxDTO.setName(todo.getName());
              auxDTO.setCompleted(todo.isCompleted());
              auxDTO.setGroupListId(todo.getGroupListId());
              listDTO.add(auxDTO);
        }
         */

        //java 8 (lambas referencia a metodo)
        List<Todo> list =(List) listTodo;
        listDTO = list.stream().map(UtilDTO::convertTodoToTodoDTO).collect(Collectors.toList());
        return listDTO;
    }

}
