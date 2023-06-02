package br.com.edificacao.repository;

import br.com.edificacao.repository.entity.ClienteEntity;
import br.com.edificacao.repository.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, String> {

    List<EnderecoEntity> findByCodigoClienteIn(List<String> codigoCliente);
}
