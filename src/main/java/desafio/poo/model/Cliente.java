package desafio.poo.model;

/**
 * ============================================================
 *  PILAR: ENCAPSULAMENTO
 * ============================================================
 * Representa o cliente do banco.
 * Atributos privados, acessados apenas via getters/setters.
 */
public class Cliente {

    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // ----- Getters -----
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    // ----- Setters -----
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Cliente{nome='%s', cpf='%s', email='%s'}", nome, cpf, email);
    }
}
