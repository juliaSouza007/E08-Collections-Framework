import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Conta {
    private Cliente donoConta;

    protected double saldo = 15000;

    public static int totalContas = 0;

    protected int contador = 0;

    protected double limite;

    protected int num;
    
    private ArrayList<Operacao> operacoes;

    private int nextOp; //proxima Operacao

    public Conta (Cliente donoConta, double saldo, int num) {
        this.num = num;
        this.saldo = saldo;
        this.donoConta = donoConta;
        
        this.operacoes = new ArrayList<Operacao>();
        this.nextOp = 0;
        
        totalContas++;
    }

    boolean depositar (double valor) {
        if (valor > 0.0) {
            this.saldo += valor;
            
            this.operacoes.add(new OperacaoDeposito(valor));
            this.nextOp++;
           
            contador++;
            return true;
        } else {
            return false;
        }
    }

    boolean sacar (double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            
            this.operacoes.add(new OperacaoSaque(valor));
            this.nextOp++;
            
            contador++;
            
            return true;
        } else {
            return false;
        }
    }

    public void extrato(int condicao) {
        if (condicao == 0)
            for(Operacao atual : this.operacoes) {
                if (atual != null) {
                    atual.imprimirExtrato();
                }
            }
        else if (condicao == 1){
            ArrayList<Operacao> ordenada = new ArrayList<Operacao>();
            for(Operacao atual : this.operacoes) {
                ordenada.add(atual);
            }
            Collections.sort(ordenada);
            for(Operacao atual : ordenada) {
                if (atual != null) {
                    atual.imprimirExtrato();
                }
            }
        }
        System.out.println("");
    }

    public String toString() {
        String str = "<< Conta " + donoConta.getNome() + " >>\n" +
                this.donoConta.toString() + "\n" +
                "Saldo : " + this.saldo + "\n" +
                "Limite: " + this.limite + "\n" +
                "\n";
        return str;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Conta) {
            Conta objConta = (Conta) obj;

            if(this.num == objConta.num) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public void extratoTaxas(){
        System.out.println("<< EXTRATO DE TAXAS  "+ donoConta.getNome() +" >>");
        float taxa = 0;
        
        System.out.println("Taxa de Manutencao: " + donoConta.calculaTaxas()+ "\n");
        taxa += donoConta.calculaTaxas();
        
        if (this.operacoes.size() >= 1){
            System.out.println("Operacoes:");
            for (Operacao ifSaq : operacoes){
                if (ifSaq == null) break;
                if (ifSaq.getTipo() == 's'){
                    System.out.println("Saque: "+ ifSaq.calculaTaxas());
                    taxa += ifSaq.calculaTaxas();
                }
            }
        } 
        System.out.println();
        System.out.printf("Total: %.2f\n", taxa);
    }


    //getters
    public double getSaldo() {
        return saldo;
    }

    public Cliente getDonoConta(){
        return this.donoConta;
    }

    //setters
    public void setDonoConta(Cliente donoConta) {
        this.donoConta = donoConta;
    }

    public abstract boolean setLimite(double limite);
}