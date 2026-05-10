package desafio.poo;

import desafio.poo.model.Cliente;
import desafio.poo.model.Conta;
import desafio.poo.model.ContaCorrente;
import desafio.poo.model.ContaPoupanca;
import desafio.poo.service.Banco;

/**
 * ============================================================
 *  DESAFIO POO - DIO
 *  Sistema Bancário com os 4 Pilares da OOP em Java
 * ============================================================
 *
 *  ✅ ABSTRAÇÃO    → Classe abstrata Conta
 *  ✅ ENCAPSULAMENTO → Atributos privados + getters/setters
 *  ✅ HERANÇA      → ContaCorrente e ContaPoupanca extends Conta
 *  ✅ POLIMORFISMO → sacar() e imprimirExtrato() com comportamentos distintos
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║    DESAFIO POO - DIO  |  Banco Digital   ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        // ─── Criando o Banco ───────────────────────────────────────
        Banco banco = new Banco("Banco Digital DIO");

        // ─── Criando Clientes (ENCAPSULAMENTO) ────────────────────
        Cliente igor   = new Cliente("Igor Pires",   "111.111.111-11", "igor@email.com");
        Cliente maria  = new Cliente("Maria Silva",  "222.222.222-22", "maria@email.com");
        Cliente carlos = new Cliente("Carlos Souza", "333.333.333-33", "carlos@email.com");

        // ─── Criando Contas (HERANÇA + ABSTRAÇÃO) ─────────────────
        ContaCorrente ccIgor   = new ContaCorrente(igor, 1000.00);   // limite R$ 1.000
        ContaPoupanca cpMaria  = new ContaPoupanca(maria, 0.005);    // 0.5% a.m.
        ContaCorrente ccCarlos = new ContaCorrente(carlos, 500.00);

        System.out.println("── Abrindo Contas ───────────────────────────");
        banco.adicionarConta(ccIgor);
        banco.adicionarConta(cpMaria);
        banco.adicionarConta(ccCarlos);

        // ─── Operações (POLIMORFISMO em ação) ─────────────────────
        System.out.println("\n── Depósitos ────────────────────────────────");
        ccIgor.depositar(2000.00);
        cpMaria.depositar(5000.00);
        ccCarlos.depositar(300.00);

        System.out.println("\n── Saques ───────────────────────────────────");
        ccIgor.sacar(500.00);           // saque normal
        ccCarlos.sacar(700.00);         // usa cheque especial (saldo R$300 + limite R$500 = R$800 disponível)
        cpMaria.sacar(6000.00);         // ❌ sem limite — deve falhar

        System.out.println("\n── Rendimento de Juros (Poupança) ───────────");
        cpMaria.renderJuros();

        System.out.println("\n── Transferência ────────────────────────────");
        ccIgor.transferir(300.00, cpMaria); // Igor → Maria

        // ─── Extratos (POLIMORFISMO: cada conta formata o seu) ────
        banco.listarExtratos();
    }
}
