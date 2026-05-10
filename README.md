#  Desafio POO - DIO | Sistema Bancário em Java

Implementação do desafio de **Programação Orientada a Objetos** da [DIO](https://dio.me), utilizando **Java 17** com os 4 pilares da POO aplicados em um domínio de Sistema Bancário.

---

##  Os 4 Pilares da POO

### 1.  Abstração
A classe `Conta` é **abstrata** — modela o conceito genérico de uma conta bancária sem poder ser instanciada diretamente. Define o contrato que todas as contas devem seguir.

### 2.  Encapsulamento
Todos os atributos das classes (`Cliente`, `Conta`) são **privados**. O acesso e a modificação só ocorrem por meio de `getters` e `setters`, protegendo a integridade dos dados.

### 3.  Herança
`ContaCorrente` e `ContaPoupanca` **herdam** de `Conta` via `extends`, reaproveitando toda a lógica comum (depósito, transferência, dados do titular) e adicionando comportamentos específicos.

### 4.  Polimorfismo
Os métodos `sacar()` e `imprimirExtrato()` têm **comportamentos distintos** em cada subclasse:
- `ContaCorrente` → permite saque usando o limite (cheque especial)
- `ContaPoupanca` → só permite saque até o saldo disponível + rende juros mensais

---

##  Estrutura do Projeto

```
src/main/java/desafio/poo/
├── Main.java                  ← Ponto de entrada e simulação
├── model/
│   ├── Cliente.java           ← Encapsulamento
│   ├── Conta.java             ← Abstração + Encapsulamento
│   ├── ContaCorrente.java     ← Herança + Polimorfismo
│   └── ContaPoupanca.java     ← Herança + Polimorfismo
└── service/
    └── Banco.java             ← Gerencia contas com polimorfismo
```

---

##  Como Executar

### Com javac (sem Maven):
```bash
# Compilar
javac -d out $(find src -name "*.java")

# Executar
java -cp out desafio.poo.Main
```

### Com Maven:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="desafio.poo.Main"
```

---

##  Saída Esperada

```
╔══════════════════════════════════════════╗
║    DESAFIO POO - DIO  |  Banco Digital   ║
╚══════════════════════════════════════════╝

── Abrindo Contas ───────────────────────────
   Conta #000001 criada para Igor Pires
   Conta #000002 criada para Maria Silva
   Conta #000003 criada para Carlos Souza

── Depósitos ────────────────────────────────
   Depósito de R$ 2000,00 realizado.
  ...
```

---

##  Tecnologias

- **Java 17**
- **Maven 3.x**
- Paradigma: **Orientação a Objetos**

---

##  Autor

**Igor Luiz Pires**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?logo=linkedin)](https://linkedin.com)  
Desenvolvido como parte do Bootcamp da [DIO](https://dio.me) 🚀
