import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opcao;

        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));
            if(opcao < 1 || opcao > 6){
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            } else{
                switch(opcao){
                    case 1: 
                        Processo.reservarMesa();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;

                }
            }

        } while(opcao != 6);
    }

    public static String menu(){

        String aux = "1. Reservar mesa";
               aux += "\n2. Pesquisar reserva";
               aux += "\n3. Imprimir reservas";
               aux += "\n4. Imprimir lista de espera";
               aux += "\n5. Cancelar reserva";
               aux += "\n6. Finalizar";
        
        return aux;

    }
}
