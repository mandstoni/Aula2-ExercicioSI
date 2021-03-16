package usuario;

import comum.IServicoPessoa;
import comum.Pessoa;
import comum.PessoaFisica;
import comum.PessoaJuridica;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AppPrincipal {
    public static void main(String[] args){
        try {
            IServicoPessoa objPessoa = (IServicoPessoa) Naming.lookup("rmi://localhost:4200/pessoa");
            PessoaFisica p1 = new PessoaFisica();

            p1.setId(1);
            p1.setNome("Amanda");
            p1.setTelefone("16998302364");
            p1.setCidade("AQA");
            p1.setEndereco("Avenida Domingo Sorbo, 487");
            p1.setEstado("SP");
            p1.setNomeMae("MÃE1");
            p1.setNomePai("PAI1");
            p1.setSalario(1500);


            PessoaJuridica p2 = new PessoaJuridica();
            p2.setId(2);
            p2.setNome("Lucas");
            p2.setTelefone("16997915111");
            p2.setCidade("SANCA");
            p2.setEndereco("Avenida Irma Antonia de Arruda, 111");
            p2.setEstado("SP");
            p2.setNomeMae("MÃE2");
            p2.setNomePai("PAI2");
            p2.setSalario(1588);

            objPessoa.inserir(p1);
            objPessoa.inserir(p2);

            for(Pessoa people : objPessoa.listarPessoa()){
                System.out.println("ID: " + people.getId());
                System.out.println("Nome: " + people.getNome());
                System.out.println("Telefone: " + people.getTelefone());
                System.out.println("Cidade: " + people.getCidade());
                System.out.println("Endereco: " + people.getEndereco() + people.getEstado());
                System.out.println("Nome da mae e nome do pai: " + people.getNomeMae() + ", " + people.getNomePai());
                System.out.println("Salario: " + people.calculaAumento());
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (RemoteException e){
            e.printStackTrace();
        } catch (NotBoundException e){
            e.printStackTrace();
        }
    }
}