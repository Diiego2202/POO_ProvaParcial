import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Processo {

    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public static void reservarMesa(){

        boolean tipo;
        String aux = "";
        TipoPessoa tipoPessoa = inputTipoCliente(); 

        String nome = JOptionPane.showInputDialog("Nome: ");

        Cliente c = null;
        switch(tipoPessoa){
            case Fisica:
                String cpf = JOptionPane.showInputDialog("CPF: ");    
                PessoaFisica pf = new PessoaFisica(nome, cpf);
                c = pf;
                break;
            case Juridica:
                String cnpj = JOptionPane.showInputDialog("CNPJ: ");
                PessoaJuridica pj = new PessoaJuridica(nome, cnpj);
                c = pj;
                break;
        }


        while(!aux.equals("s") && !aux.equals("n")){
            aux = JOptionPane.showInputDialog("O pagamento será à vista? [S/N]: ").toLowerCase();
            if(!aux.equals("s") && !aux.equals("n")){
                JOptionPane.showMessageDialog(null, "ERRO!! Informe um valor válido\nS: Pagamento à vista | N: Pagamento parcelado");
            }
        }
            
        if("s".equals(aux)){
            tipo = true;
        } else {
            tipo = false;        
        }
    
        Reserva reserva = new Reserva(c, tipo);
        reserva.setPagamentoAVista(tipo);
    
        reservas.add(reserva);
            
        if(reservas.size() > 6){
            JOptionPane.showMessageDialog(null, "Reservas esgotadas :( \nVocê está na lista de espera");
        } else{
            JOptionPane.showMessageDialog(null, "Reserva efetuada com sucesso");
        }
    } 
    

    private static TipoPessoa inputTipoCliente(){

        String tp="";

        while(!tp.equals("f") && !tp.equals("j")){
            tp = JOptionPane.showInputDialog("Tipo de cliente[F/J]: ").toLowerCase();
            if(!tp.equals("f") && !tp.equals("j")){
                JOptionPane.showMessageDialog(null, "ERRO!! Informe um valor válido\nF: Físico | J: Jurídico");
            }
        }

        return tp.equals("f") ? TipoPessoa.Fisica : TipoPessoa.Juridica;
    }

    public static void pesquisarReserva(){

        if(reservas.size() > 0){
            String aux = JOptionPane.showInputDialog(null, "Informe seu CPF/CNPJ: ");
            int achou = verificar(aux);

            if(achou >= 0){
                JOptionPane.showMessageDialog(null, "Você possui uma reserva"); 
            } else{
                JOptionPane.showMessageDialog(null, "Você não possui uma reserva");     
            }
        } else{
            JOptionPane.showMessageDialog(null, "ERRO!! Não existem reservas cadastradas!");     
        } 
    }

    public static void imprimirReservas(){
        if(reservas.size() > 0){
            for(int i = 0; i < reservas.size(); i++) {
                if(i < 6){
                    JOptionPane.showMessageDialog(null, reservas.get(i));
                } else{
                    return;
                }  
            }
        } else{
            JOptionPane.showMessageDialog(null, "ERRO!! Não há reservas!");    
        }
         
    }

    public static void imprimirListaDeEspera(){
        if(reservas.size() > 6){
            for(int i = 0; i < reservas.size(); i++) {
                if(i >= 6){
                    JOptionPane.showMessageDialog(null, "Posição na lista de espera: " + (i-6) + "\n" + reservas.get(i));
                }
            }
        } else{
            JOptionPane.showMessageDialog(null, "ERRO!! Ainda restam revervas disponíveis!");     
        }
         
    }

    public static void cancelarReserva(){

        if(reservas.size() > 0){
            String aux = JOptionPane.showInputDialog(null, "Informe seu CPF/CNPJ: ");
            int achou = verificar(aux);

            if(achou >= 0){
                reservas.remove(achou);
                JOptionPane.showMessageDialog(null, "Reserva removida com sucesso!"); 
            } else{
                JOptionPane.showMessageDialog(null, "ERRO!! CPF/CNPJ não encontrado");     
            }
        } else{
            JOptionPane.showMessageDialog(null, "ERRO!! Não existem reservas cadastradas!");     
        } 
    }


    public static int verificar(String aux){

        if(reservas.size() > 0){

            for(int i = 0; i < reservas.size(); i++) {  
                if(reservas.get(i).getCliente() instanceof PessoaFisica){
                    Cliente c = reservas.get(i).getCliente();
                    PessoaFisica pf = (PessoaFisica) (c);
                    if(pf.getCpf().equals(aux)){
                        return i;
                    }
                }
                if(reservas.get(i).getCliente() instanceof PessoaJuridica){
                    Cliente c = reservas.get(i).getCliente();
                    PessoaJuridica pj = (PessoaJuridica) (c);
                    if(pj.getCnpj().equals(aux)){
                        return i;
                    }
                }
            }

        } 

        return -1;
    }


}