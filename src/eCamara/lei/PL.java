package eCamara.lei;

public class PL extends ProjetoDeLeiAbstract {

    private boolean conclusivo;

    /**
     * Construtor responsavel por construir um objeto do tipo PL(projeto de lei) a partir do dni do deputado que o criou,
     * do ano em que ele foi criado, da ementa, dos interesses relacionados ao projeto, da url do site em que o projeto
     * esta hospedado e um boolean indicando se o projeto eh conclusivo ou nao.
     *
     * @param dni dni do deputado criador do projeto.
     * @param ano data de criacao do projeto.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto.
     * @param url url do site em que o projeto esta hospedado.
     * @param conclusivo boolean que representa se o projeto de lei eh conclusivo ou nao.
     */
    public PL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        super(dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    /**
     * Metodo responsavel por criar uma representacao textual do objeto atraves do dni do autor, da ementa, da conclusao
     * do projeto e da situacao em que ele se encontra.
     *
     * @param codigo codigo do projeto.
     * @return string que representa o objeto.
     */
    public String toString(String codigo){
        if (conclusivo){
            return "Projeto de Lei - " + codigo + super.dniAutor + " - " + super.ementa + " - Conclusiva - " + super.situacao;
        }
        return "Projeto de Lei - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - Nao conclusiva - " + super.situacao;
    }
}
