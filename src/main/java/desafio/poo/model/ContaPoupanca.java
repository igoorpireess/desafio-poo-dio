package desafio.poo.model;

/**
 * ============================================================
 *  PILAR: HERANÇA
 * ============================================================
 * ContaPoupanca HERDA de Conta.
 * Adiciona: taxa de rendimento mensal.
 *
 * ============================================================
 *  PILAR: POLIMORFISMO
 * ============================================================
 * Sobrescreve sacar() com regra específica:
 * só pode sacar até o saldo disponível (sem cheque especial).
 */
public class ContaPoupanca extends Conta {

    private double taxaRendimento; // ex: 0.005 = 0.5% ao mês

    public ContaPoupanca(Cliente titular, double taxaRendimento) {
        super(titular);
        this.taxaRendimento = taxaRendimento;
    }

    // ===== Polimorfismo: comportamento específico de saque =====
    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("  ❌ Valor de saque inválido.");
            return false;
        }
        if (valor > getSaldo()) {
            System.out.printf("  ❌ Saldo insuficiente! Saldo atual: R$ %.2f%n", getSaldo());
            return false;
        }
        setSaldo(getSaldo() - valor);
        System.out.printf("  ✅ Saque de R$ %.2f realizado da Conta Poupança.%n", valor);
        return true;
    }

    /**
     * Aplica rendimento mensal sobre o saldo atual.
     */
    public void renderJuros() {
        double rendimento = getSaldo() * taxaRendimento;
        setSaldo(getSaldo() + rendimento);
        System.out.printf("  💰 Rendimento de R$ %.2f aplicado (%.2f%% a.m.)%n",
                rendimento, taxaRendimento * 100);
    }

    // ===== Polimorfismo: extrato específico =====
    @Override
    public void imprimirExtrato() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       EXTRATO - CONTA POUPANÇA           ║");
        System.out.println("╠══════════════════════════════════════════╣");
        super.imprimirInfosComuns();
        System.out.printf("  Rendim. : %.2f%% a.m.%n", taxaRendimento * 100);
        System.out.println("╚══════════════════════════════════════════╝");
    }

    public double getTaxaRendimento() { return taxaRendimento; }
    public void setTaxaRendimento(double taxaRendimento) { this.taxaRendimento = taxaRendimento; }
}
