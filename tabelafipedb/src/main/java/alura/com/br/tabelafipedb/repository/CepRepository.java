package alura.com.br.tabelafipedb.repository;

import alura.com.br.tabelafipedb.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CepRepository extends JpaRepository<Cep, Long> {

    @Query("SELECT c FROM Cep c WHERE c.uf ILIKE %:estado%")
    List<Cep> filtrarPorEstados(String estado);
}
