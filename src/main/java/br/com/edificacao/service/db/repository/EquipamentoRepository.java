package br.com.edificacao.service.db.repository;

import br.com.edificacao.service.db.repository.entity.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, String> {
}
