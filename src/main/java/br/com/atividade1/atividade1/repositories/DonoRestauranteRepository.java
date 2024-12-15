package br.com.atividade1.atividade1.repositories;

import br.com.atividade1.atividade1.entities.Clientes;
import br.com.atividade1.atividade1.entities.DonoRestaurante;

public interface DonoRestauranteRepository {
    Integer salvarDonoRestaurante(DonoRestaurante donoRestaurante);
    Integer alterarDonoRestaurante(DonoRestaurante donoRestaurante, Long id);
    Integer deletarDonoRestaurante(Long id);
    Integer trocarSenhaDonoRestaurante(DonoRestaurante donoRestaurante);
}
