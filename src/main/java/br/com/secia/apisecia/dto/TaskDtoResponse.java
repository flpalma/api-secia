package br.com.secia.apisecia.dto;

import br.com.secia.apisecia.model.Task;
import br.com.secia.apisecia.utils.PrioridadeEnum;
import br.com.secia.apisecia.utils.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class TaskDtoResponse {

    public TaskDtoResponse (Task task) {
        this.nomeCliente = task.getCliente().getNome();
        this.dataPrevisaoAtendimento = task.getDataPrevisaoAtendimento();
        this.prioridade = task.getPrioridade();
        this.descricao = task.getDescricao();
        this.status = task.getStatus();
        this.titulo = task.getTitulo();
    }

    private String titulo;
    private LocalDate dataPrevisaoAtendimento;
    private PrioridadeEnum prioridade;
    private StatusEnum status;
    private String nomeCliente;
    private String descricao;

    public static List<TaskDtoResponse> convert(List<Task> tasks) {
       return tasks.stream().map(TaskDtoResponse:: new).collect(Collectors.toList());
    }
}
