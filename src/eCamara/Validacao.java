package eCamara;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validacao {


    private void validaString(String frase, String mensagem) {
        if (frase == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    private void validaDni(String dni, String mensagem) {
        String[] array = dni.split("-");
        try {
            Integer.parseInt(array[0]);
            Integer.parseInt(array[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public void validarCadastroPessoa(String dni, String nome, String estado) {
        validaString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validaString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validaDni(dni, "Erro ao cadastrar pessoa: dni invalido");
    }
    public void validaDataFutura(String dataInicio, String mensagem){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        try {
            Date dataDeInicio = sdf.parse(dataInicio);
            Date dataAtual = new Date();
            if (dataDeInicio.compareTo(dataAtual) > 0) {
                throw new IllegalArgumentException(mensagem);
            }
        } catch (ParseException pe) {
            throw new IllegalArgumentException(mensagem);
        }

    }

    public void validaFormatoData(String dataInicio, String mensagem) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dataInicio);
        } catch (ParseException pe) {
            throw new IllegalArgumentException(mensagem);
        }

    }


    public void validaDniCadastraDeputado(String dni){
        validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validaDni(dni,"Erro ao cadastrar deputado: dni invalido");

    }

    public void validaDataCadastroDeputado(String dataInicio){
        validaString(dataInicio, "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
        validaFormatoData(dataInicio, "Erro ao cadastrar deputado: data invalida");
        validaDataFutura(dataInicio, "Erro ao cadastrar deputado: data futura");

    }

    public void validaDeputado(String dataInicio){
        validaString(dataInicio, "Data de inicio da funcao como deputado não pode ser vazia ou nula");
    }

    /**
     * Metodo responsavel por validar a string que representa um partido no metodo "cadastrarPartido". Caso a entrada for
     * vazia, somente formada de espacos ou nula uma excecao sera lancada com a mensagem de acordo.
     *
     * @param partido string que representa o partido.
     */
    public void validaCadastraPartido(String partido) {
        validaString(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
    }

    public void validaExibirPessoa(String dni) {
        validaString(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
        validaDni(dni, "Erro ao exibir pessoa: dni invalido");
    }

}
