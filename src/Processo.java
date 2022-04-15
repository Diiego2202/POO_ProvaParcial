import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class Processo {

    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private Queue<Reserva> reservas = new LinkedList<Reserva>();

    public static void reservarMesa(){

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
            Reserva reserva = new Reserva(c, true);
        } else{
            Reserva reserva = new Reserva(c, false);    
        }

        clientes.add(c);

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
}