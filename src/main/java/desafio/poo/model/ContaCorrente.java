package desafio.poo.model;

/**
 * ============================================================
 *  PILAR: HERANÇA
 * ============================================================
 * ContaCorrente HERDA de Conta, reaproveitando toda a estrutura comum.
 * Adiciona: limite de cheque especial.
 *
 * ============================================================
 *  PILAR: POLIMORFISMO
 * ============================================================
 * Sobrescreve sacar() com regra específica:
 * permite sacar até (saldo + limite).
 */
public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(Cliente titular, double limite) {
        super(titular); // chama o construtor da superclasse
        this.limite = limite;
    }

    // ===== Polimorfismo: comportamento específico de saque =====
    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("  ❌ Valor de saque inválido.");
            return false;
        }
        double saldoDisponivel = getSaldo() + this.limite;
        if (valor > saldoDisponivel) {
            System.out.printf("  ❌ Saldo insuficiente! Disponível (com limite): R$ %.2f%n", saldoDisponivel);
            return false;
        }
        setSaldo(getSaldo() - valor);
        System.out.printf("  ✅ Saque de R$ %.2f realizado da Conta Corrente.%n", valor);
        return true;
    }

    // ===== Polimorfismo: extrato específico =====
    @Override
    public void imprimirExtrato() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       EXTRATO - CONTA CORRENTE           ║");
        System.out.println("╠══════════════════════════════════════════╣");
        super.imprimirInfosComuns();
        System.out.printf("  Limite  : R$ %.2f%n", this.limite);
        System.out.println("╚══════════════════════════════════════════╝");
    }

    public double getLimite() { return limite; }
    public void setLimite(double limite) { this.limite = limite; }
}
