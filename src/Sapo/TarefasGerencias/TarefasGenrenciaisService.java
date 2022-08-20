package Sapo.TarefasGerencias;

import Sapo.Tarefas.TarefasService;

public class TarefasGenrenciaisService extends TarefasService{

    private final TarefasGerenciaisRepository tarefasGerenciaisRepository;

    public TarefasGenrenciaisService(){
        this.tarefasGerenciaisRepository = new TarefasGerenciaisRepository();
    }
    public String cadastrarTarefaGerencial(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
        // add a habilidade de gestão
        TarefaGerenciais tarefaGerenciais = new TarefaGerenciais(atividadeId,nome, habilidades,idTarefas, geraTarefaId(atividadeId, nome));
        tarefasGerenciaisRepository.salvaTarefaGerencial(tarefaGerenciais);
        return  tarefaGerenciais.getIdTarefa();
    }

    public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        tarefasGerenciaisRepository.getTarefaGerencial(idTarefaGerencial).addTarefa(idTarefa);
    }

    public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        tarefasGerenciaisRepository.getTarefaGerencial(idTarefaGerencial).removeTarefa(idTarefa);
    }

    public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
        return tarefasGerenciaisRepository.getTarefaGerencial(idTarefaGerencial).contarTodasTarefas();
    }
}
