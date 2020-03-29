package br.com.secia.apisecia.repository;

import br.com.secia.apisecia.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
