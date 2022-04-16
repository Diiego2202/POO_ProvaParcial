public class Reserva {

    Cliente cliente;
    boolean pagamentoAVista;

    public Reserva(Cliente cliente, boolean pagamentoAVista){
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }
    
    @Override
    public String toString() {
        //retornar o tipo do cliente (pessoa física ou jurídica), seu nome e a forma de pagamento (à vista ou parcelado). 
        return "{Cliente: " + cliente.getNome() + "}";
    }

    public boolean getpagamentoAVista() {
        return this.pagamentoAVista;
    }

    public void setPagamentoAVista(boolean pagamentoAVista) {
        this.pagamentoAVista = pagamentoAVista;
    }


}