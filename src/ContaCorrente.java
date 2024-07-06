public class ContaCorrente extends  Conta {
    public ContaCorrente(Cliente donoConta, double limite, double saldo, int num) {
        super(donoConta, saldo, num);
        setLimite(limite);
    }

    @Override
    public boolean setLimite(double limite) {
        if (limite <= -100) {
            super.limite = -100;
            return false;
        } else {
            super.limite = limite;
            return true;
        }
    }
    
    public double calculaTaxas() {
        return 0;
    }
}