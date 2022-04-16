import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Processo {

    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public static void reservarMesa(){

        boolean tipo;
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

        String aux = JOptionPane.showInputDialog("O pagamento será à vista? [S/N]: ").toLowerCase();

        

        if("s".equals(aux)){
            tipo = true;
        } else{
            tipo = false;        
        }

        Reserva reserva = new Reserva(c, tipo);

        clientes.add(c);
        reservas.add(reserva);
    }

    private static TipoPessoa inputTipoCliente(){

        String tp="";

        while(!tp.equals("f") && !tp.equals("j")){
            tp = JOptionPane.showInputDialog("Tipo de cliente: ").toLowerCase();
            if(!tp.equals("f") && !tp.equals("j")){
                JOptionPane.showMessageDialog(null, "F: Física | J: Jurídica");
            }
        }

        return tp.equals("f") ? TipoPessoa.Fisica : TipoPessoa.Juridica;
    }

    public static void imprimir(){
        for(int i = 0; i < reservas.size(); i++) {   
            System.out.print(reservas.get(i));
        } 
    }
}