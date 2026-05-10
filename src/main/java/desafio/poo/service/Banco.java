package desafio.poo.service;

import desafio.poo.model.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ============================================================
 *  PILAR: ABSTRAÇÃO + POLIMORFISMO
 * ============================================================
 * Banco gerencia uma lista de Contas (tipo genérico/abstrato).
 * Usa polimorfismo para tratar ContaCorrente e ContaPoupanca
 * da mesma forma onde possível.
 */
public class Banco {

    private final String nome;
    private final List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.printf("  🏦 Conta #%06d criada para %s%n",
                conta.getNumero(), conta.getTitular().getNome());
    }

    public Optional<Conta> buscarPorNumero(int numero) {
        return contas.stream()
                .filter(c -> c.getNumero() == numero)
                .findFirst();
    }

    /**
     * POLIMORFISMO em ação: chama imprimirExtrato() em todas as contas.
     * Cada conta imprime seu próprio formato sem o banco saber o tipo.
     */
    public void listarExtratos() {
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("  BANCO " + nome.toUpperCase() + " — EXTRATOS GERAIS");
        System.out.println("════════════════════════════════════════════");
        contas.forEach(Conta::imprimirExtrato);
    }

    public String getNome() { return nome; }
    public List<Conta> getContas() { return contas; }
}
