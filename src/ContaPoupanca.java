public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente donoConta, double limite, double saldo, int num) {
        super(donoConta, saldo, num);
        setLimite(limite);
    }

    @Override
    public boolean setLimite(double limite) {
        if (limite <= 1000 && limite >= 100) {
            super.limite = limite;
            return true;
        } else {
            super.limite = 1000;
            return false;
        }
    }
    
    public double calculaTaxas() {
        return 0;
    }
}