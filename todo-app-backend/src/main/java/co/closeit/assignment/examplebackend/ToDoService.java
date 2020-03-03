package co.closeit.assignment.examplebackend;

import co.closeit.assignment.examplebackend.persistence.ToDoEntry;
import co.closeit.assignment.examplebackend.persistence.ToDoEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoEntryRepository repository;

    public List<ToDoEntry> findAll() {
        return repository.findAll();
    }

    public Optional<ToDoEntry> findById(Long id) {
        return repository.findById(id);
    }

    public ToDoEntry save(ToDoEntry toDoEntry) {
        return repository.save(toDoEntry);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
