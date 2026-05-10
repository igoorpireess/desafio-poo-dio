package desafio.poo.model;

/**
 * ============================================================
 *  PILAR: ABSTRAÇÃO
 * ============================================================
 * Classe abstrata que modela o conceito genérico de "Conta".
 * Agrupa atributos e comportamentos comuns a TODOS os tipos de conta.
 * Não pode ser instanciada diretamente.
 *
 * ============================================================
 *  PILAR: ENCAPSULAMENTO
 * ============================================================
 * Atributos declarados como private/protected.
 * Estado interno protegido de acesso externo direto.
 */
public abstract class Conta {

    // Contador estático para gerar números de conta únicos
    private static int SEQUENCIAL = 1;
    public static final int AGENCIA_PADRAO = 1;

    // ===== Encapsulamento: atributos privados =====
    private final int agencia;
    private final int numero;
    private double saldo;
    private final Cliente titular;

    // ===== Abstração: construtor protegido =====
    protected Conta(Cliente titular) {
        this.titular = titular;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0.0;
    }

    // ===== Comportamentos comuns (implementados aqui) =====

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("  ❌ Valor inválido para depósito.");
            return;
        }
        this.saldo += valor;
        System.out.printf("  ✅ Depósito de R$ %.2f realizado.%n", valor);
    }

    public void transferir(double valor, Conta destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
        }
    }

    // ===== Abstração: método abstrato =====
    // Cada subclasse define sua PRÓPRIA regra de saque
    public abstract boolean sacar(double valor);

    // ===== Impressão de extrato — parte comum =====
    protected void imprimirInfosComuns() {
        System.out.printf("  Titular : %s%n", titular.getNome());
        System.out.printf("  CPF     : %s%n", titular.getCpf());
        System.out.printf("  Agência : %04d%n", agencia);
        System.out.printf("  Conta   : %06d%n", numero);
        System.out.printf("  Saldo   : R$ %.2f%n", saldo);
    }

    // Cada conta imprime seu próprio extrato
    public abstract void imprimirExtrato();

    // ===== Getters =====
    public int getAgencia() { return agencia; }
    public int getNumero()  { return numero; }
    public double getSaldo() { return saldo; }
    public Cliente getTitular() { return titular; }

    // Setter protegido — só subclasses podem alterar o saldo diretamente
    protected void setSaldo(double saldo) { this.saldo = saldo; }
}
