import java.util.Scanner;

public class BancoDigital {
  private Scanner scanner = new Scanner(System.in);
  private String nome;
  private String senha;
  private boolean estaAutorizado = false;
  private double dinheiro = 0;

  public BancoDigital() {
    System.out.println("-- Bem-vindo ao banco digital, digite seu nome --");
    this.nome = scanner.nextLine();
    System.out.println("-- Agora sua senha --");
    this.senha = scanner.nextLine();

    boolean estaLogado = this.logar(nome, senha);

    if (estaLogado) {
      estaAutorizado = true;
    } else {
      System.out.println("Usuario ou senha incorretos");
    }
  }

  private boolean logar(String nome, String senha) {
    Autenticacao autenticacao = new Autenticacao();
    return autenticacao.autenticar(nome, senha);
  }

  public void sacar(double valor) {
    if (estaAutorizado) {
      dinheiro -= valor;
      System.out.println("Sacando " + valor);
    } else {
      System.out.println("Usuario não autorizado");
    }
  }

  public void depositar(double valor) {
    if (estaAutorizado) {
      dinheiro += valor;
      System.out.println("Depositando " + valor);
    } else {
      System.out.println("Usuario não autorizado");
    }
  }

  public void transferir(double valor, String conta) {
    if (estaAutorizado) {
      dinheiro -= valor;
      System.out.println("Transferindo " + valor + " para " + conta);
    } else {
      System.out.println("Usuario não autorizado");
    }
  }

  public void saldo() {
    if (estaAutorizado) {
      System.out.println("Saldo:" + dinheiro);
    } else {
      System.out.println("Usuario não autorizado");
    }
  }

  public void sair() {
    estaAutorizado = false;
    System.out.println("Saindo...");
  }
}