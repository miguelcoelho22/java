package br.com.alura.oficina.mecanima.barbeiro;

public record DadosListagemBarbeiro(Long id, String nome, String email, String telefone, Especialidade especialidade) {
    public DadosListagemBarbeiro(Barbeiro b) {
        this(b.getId(), b.getNome(), b.getEmail(), b.getTelefone(), b.getEspecialidade());
    }
}
