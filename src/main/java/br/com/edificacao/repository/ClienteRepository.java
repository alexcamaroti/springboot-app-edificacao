package br.com.edificacao.repository;

import br.com.edificacao.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

    List<ClienteEntity> findByTipoPessoa(String tipoPessoa);
}
