package co.closeit.assignment.examplebackend;

import co.closeit.assignment.examplebackend.persistence.ToDoEntry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todo")
@Slf4j
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDoEntry>> findAll() {
        return ResponseEntity.ok(toDoService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ToDoEntry toDoEntry) {
        return ResponseEntity.ok(toDoService.save(toDoEntry));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoEntry> findById(@PathVariable Long id) {
        Optional<ToDoEntry> toDoEntry = toDoService.findById(id);
        if (!toDoEntry.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(toDoEntry.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoEntry> update(@PathVariable Long id, @Valid @RequestBody ToDoEntry toDoEntry) {
        if (!toDoService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        if (toDoEntry.getId() == null) {
            toDoEntry.setId(id);
        }
        return ResponseEntity.ok(toDoService.save(toDoEntry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!toDoService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        toDoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
