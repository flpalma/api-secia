package br.com.secia.apisecia.repository;

import br.com.secia.apisecia.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "select count(1) " +
            " from tb_task t " +
            " inner join tb_user u on t.usuario_codigo = u.codigo " +
            " where " +
            " t.prioridade like :type " +
            " and u.login like :email ", nativeQuery = true)
    Integer countTasks(@Param(value = "type") String type, @Param(value = "email") String email);

    @Query(value = "select count(1) " +
            " from tb_task t " +
            " where " +
            " t.prioridade like :type ", nativeQuery = true)
    Integer countTasks(@Param(value = "type") String type);

}
