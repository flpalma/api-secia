package br.com.secia.apisecia.service;

import br.com.secia.apisecia.dto.PrioritiesDto;
import br.com.secia.apisecia.dto.TaskDto;
import br.com.secia.apisecia.model.Client;
import br.com.secia.apisecia.model.Task;
import br.com.secia.apisecia.model.User;
import br.com.secia.apisecia.repository.ClientRepository;
import br.com.secia.apisecia.repository.TaskRepository;
import br.com.secia.apisecia.repository.UserRepository;
import br.com.secia.apisecia.utils.PrioridadeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;


    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(TaskDto taskDto) {
        Task task = convertTaskDTO(taskDto);
        return taskRepository.save(task);
    }

    private Task convertTaskDTO(TaskDto taskDto) {
        User user  = userRepository.findByLogin(taskDto.getUsuario());
        Client cliente = clientRepository.findByCodigo(taskDto.getCliente());

        Task task = new Task();
        task.setDescricao(taskDto.getDescricao());
        task.setUsuario(user);
        task.setTitulo(taskDto.getTitulo());
        task.setCliente(cliente);
        task.setPrioridade(taskDto.getPrioridade());
        task.setDataPrevisaoAtendimento(taskDto.getDataPrevisaoAtendimento());
        task.setData(LocalDate.now());
        return task;
    }

    public PrioritiesDto findPriorities(String email) {
        Integer quantidadeUrgente;
        Integer quantidadeAlta;
        Integer quantidadeMedia;
        Integer quantidadeBaixa;
        if(email != null && !email.isEmpty()) {
            quantidadeUrgente = taskRepository.countTasks(PrioridadeEnum.URGENTE.getValor(), email);
            quantidadeAlta = taskRepository.countTasks(PrioridadeEnum.ALTA.getValor(), email);
            quantidadeMedia = taskRepository.countTasks(PrioridadeEnum.MEDIA.getValor(), email);
            quantidadeBaixa = taskRepository.countTasks(PrioridadeEnum.BAIXA.getValor(), email);
        } else {
            quantidadeUrgente = taskRepository.countTasks(PrioridadeEnum.URGENTE.getValor());
            quantidadeAlta = taskRepository.countTasks(PrioridadeEnum.ALTA.getValor());
            quantidadeMedia = taskRepository.countTasks(PrioridadeEnum.MEDIA.getValor());
            quantidadeBaixa = taskRepository.countTasks(PrioridadeEnum.BAIXA.getValor());
        }
        return new PrioritiesDto(quantidadeUrgente, quantidadeAlta, quantidadeMedia, quantidadeBaixa);
    }

}
