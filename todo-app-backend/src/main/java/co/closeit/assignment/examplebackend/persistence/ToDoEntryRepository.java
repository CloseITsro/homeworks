package co.closeit.assignment.examplebackend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoEntryRepository extends JpaRepository<ToDoEntry, Long> {
}
