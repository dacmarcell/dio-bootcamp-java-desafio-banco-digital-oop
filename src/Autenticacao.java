public class Autenticacao {
  protected final static Usuario[] usuarios = {
      new Usuario("joao", "123"),
      new Usuario("maria", "456"),
      new Usuario("jose", "789")
  };

  public boolean autenticar(String nome, String senha) {
    for (Usuario usuario : usuarios) {
      if (usuario.nome.equals(nome) && usuario.senha.equals(senha)) {
        return true;
      }
    }
    return false;
  }
}
