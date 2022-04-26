import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String opcao="";


        while(!opcao.equals("6")){
            opcao = JOptionPane.showInputDialog(menu());
            try {
        
                if ("".equals(opcao)) {
                } else if ("1".equals(opcao)) {
                    Processo.reservarMesa();
                } else if ("2".equals(opcao)) {
                    Processo.pesquisarReserva();
                } else if ("3".equals(opcao)) {
                    Processo.imprimirReservas();
                } else if ("4".equals(opcao)) {
                    Processo.imprimirListaDeEspera();
                } else if ("5".equals(opcao)) {
                    Processo.cancelarReserva();    
                } else if("6".equals(opcao)){
                    break;
                }else{
                    JOptionPane.showMessageDialog(null, "ERRO!! Comando inválido!");
                    throw new UnsupportedOperationException();       
                }
                
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
    }

    public static String menu(){

        String aux = "Restaurante SABOR SOFISTICADO";
               aux += "\n1. Reservar mesa";
               aux += "\n2. Pesquisar reserva";
               aux += "\n3. Imprimir reservas";
               aux += "\n4. Imprimir lista de espera";
               aux += "\n5. Cancelar reserva";
               aux += "\n6. Finalizar";
        
        return aux;
    }
}