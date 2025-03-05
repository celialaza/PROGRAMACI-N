public class Cuenta {
    private String nombre;
    private double saldo;

    public Cuenta() throws SaldoInvalidoException{
        this.saldo=0.0;
        if(saldo<0){
            throw new SaldoInvalidoException ("El saldo no puede ser negativo.");
        }
    }

    public Cuenta(String nombre, double saldo) throws SaldoInvalidoException{
        this.nombre = nombre;
        this.saldo = saldo;
        if(saldo<0){
        throw new SaldoInvalidoException ("El saldo no puede ser negativo.");
    }


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void depositar(double valor) throws CantidadInvalidaException{
        if(valor > 0){
            this.saldo += valor;
        }else{
            throw new CantidadInvalidaException("La cantidad debe ser mayor de cero.");
        }

    }
    public void retirar(double valor) throws FondosInsuficientesException{
        if(valor<this.saldo){
            this.saldo -= valor;

        }else{
            throw new FondosInsuficientesException("No se puede retirar una cantidad superior al saldo de la cuenta.");
        }
    }
}