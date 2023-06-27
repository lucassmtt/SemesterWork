package model.dao;

import model.entities.Aula;

public interface AulaDao
{
    void inserirAula(Aula aula);
    void apagarAulaPorId(Integer ID);
    void atualizarAula(Aula aula);
    void buscarAulaPorId(Integer ID);
    Aula buscarAulaPorIdTransformarEmObjAula(Integer ID);
    void buscarTodasAulas();
    boolean verSeTemAulaEmDiaEspecifico(Integer ID_aula, String diaSemana);
    boolean verSeTemSalaCadastradaAulaEmQueDia(Integer ID_sala, String diaSemana);
    boolean verSeTemTurmaCadastradaEmUmDiaEspecifico(Integer ID_turma, String diaSemana);

}
