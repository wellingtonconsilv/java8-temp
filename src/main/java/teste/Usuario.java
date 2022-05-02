package teste;

public class Usuario {

    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                '}';
    }


    public static Usuario map(Order order) {
        return new Usuario(order.getCustomerName());
    }
}
