import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date data = new Date();

        PessoaFisica pF1 = new PessoaFisica("Julia", "rua das engracadinhas", data, "155.495.816-47", 16, 'F');
        PessoaFisica pF2 = new PessoaFisica("Mariana", "rua das princesas", data, "107.010.076-56", 16, 'F');
        PessoaFisica pF3 = new PessoaFisica("Juliaa", "rs", data, "155.495.816-47", 16, 'F');
        PessoaJuridica pJ = new PessoaJuridica("CHURRASIC PARK", "rua dos dinossauros", data, "24 405 890/0001-86", "Alimenticio", 5);

        Conta contaPF1 = new ContaCorrente(pF1, 1000000, 100000, 0);
        Conta contaPF2 = new ContaCorrente(pF2, 1000000, 500000, 1);
        Conta contaPF3 = new ContaUniversitaria(pF3, 200, 200, 3);
        Conta contaPJ = new ContaCorrente(pJ, 1000000, 500000, 2);

        System.out.println("<< BANCO JMSZ >>\n<< IMPRIMINDO INFORMACOES DOS CLIENTES >>");
        System.out.println(contaPF1.toString());
        System.out.println(contaPF2.toString());
        System.out.println(contaPF3.toString());
        System.out.println(contaPJ.toString());

        System.out.println("\n<< REALIZANDO OPERACOES >>");
        contaPF1.depositar(5000);
        contaPF2.depositar(2000);
        contaPJ.depositar(10000);
        contaPJ.depositar(2000);

        contaPF1.sacar(200);
        contaPF2.sacar(1500);
        contaPF2.sacar(200);
        contaPJ.sacar(130);
        contaPJ.sacar(200);
        contaPJ.sacar(300);
        contaPJ.sacar(1640);
        
        contaPF1.extratoTaxas();
        contaPF2.extratoTaxas();
        contaPJ.extratoTaxas();

        System.out.println("\n<< IMPRIMINDO EXTRATO... >>");
        System.out.println("\nConta: " +pF1.getNome());
        contaPF1.extrato(1);
        System.out.println("\nConta: " +pF2.getNome());
        contaPF2.extrato(1);
        System.out.println("\nConta: " +pJ.getNome());
        contaPJ.extrato(1);

        System.out.println("\nImprimindo a media...");
        //int media = Operacao.totalOperacoes/Conta.totalContas;

        //System.out.println("Media: " +media);

        //verificacao pelo metodo equals
        System.out.println("\n<< VERIFICANDO SE HA CONTAS IGUAIS (cpf ou cnpj) >>");
        System.out.println("\nConta " + pF1.getNome() + " equals (igual) Conta " + pF2.getNome() + "? ");
        System.out.println(pF1.autenticar(pF2.getCpf()));
        System.out.println("\nConta " + pF1.getNome() + " equals (igual) Conta " + pF3.getNome() + "? ");
        System.out.println(pF1.autenticar(pF3.getCpf()));
    }
}