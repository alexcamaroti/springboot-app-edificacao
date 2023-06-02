package br.com.edificacao.service.db.repository;

import br.com.edificacao.service.db.repository.entity.ClienteEntity;
import br.com.edificacao.service.db.repository.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, String> {
}
