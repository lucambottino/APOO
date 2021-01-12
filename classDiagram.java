// COVID INFO IMPLENTATION
// APOO - Turma 2 - Grupo 1 Usuarios do ENIAC

// USER REQUES CLASS_________________________________________________
public class User_Request {
    // VARIABLES
    private String timestamp;
    private int request_type;
    private String message;
    private String phone_number;
    private String user_input_text;

    // CONSTRUCTOR
    public User_Request(String user_input_text, String phone_number);

    // METHODS
  public int set_request_type(int);

    public int get_request_type();

    public void generate_message();

    public String get_message();

    public String get_timestamp();

    public void set_user_option(int option);

    public void send_answer(String phone_number);

    public int verify_user_option(int option);
}

// INFORMACOES MEDICAS CLASS________________________________________________

public class Informacoes_medicas {

    // VARIABLES

    private List<String> lista_sintomas;
    private List<String> lista_precaucoes;
    private List<String> lista_recomendacoes_medicas;
    private String telefone_usuario;
    private int opcao_selecionada;
    private String API_url;
    private String OMS_link = "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public";
    private String covid_brasil = "https://covid.saude.gov.br";

    // CONSTRUCTOR
    Informacoes_medicas(String tel_usu, op_sel){
  	this.telefone_usuario = tel_usu;
    this.opcao_selecionada = op_sel;
 	 	atualiza_lista_recomendacoes_medicas(this.lista_recomendacoes_medicas);
    atualiza_lista_precaucoes(this.lista_precaucoes);
    atualiza_lista_sintomas(this.lista_sintomas);
  }

    // METHODS
    private String URL_request(String link, String query) {
        String searchQuery = query;

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = link + URLEncoder.encode(searchQuery, "UTF-8");
            HtmlPage page = client.getPage(searchUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//li[@class='" + query + "']");
        if (items.isEmpty()) {
            System.out.println("Not found !");
            return ERROR;
        } else {
            return items;
        }
    }

    public List<String> get_lista_sintomas(String API_url) {
        return lista_sintomas;
    }

    public List<String> get_lista_precaucoes(String API_url) {
        return lista_precaucoes;
    }

    public List<String> get_lista_recomendacoes_medicas(String API_url) {
        return lista_recomendacoes;
    }

    private String parser(String content);

  public List<String> request_sintomas(String API_url)

  private void atualiza_lista_sintomas(List<String> lista_sintomas){
		content = URL_request(OMS_link, "symptoms"); 
    lista_sintomas = parser(content)
  }

  private void atualiza_lista_precaucoes(List<String> lista_precaucoes){
		content = URL_request(OMS_link, "precautions"); 
    lista_p = parser(content)
  }

  private void atualiza_lista_recomendacoes_medicas(List<String> lista_recomendacoes_medicas){
    content = URL_request(OMS_link, "recomendations"); 
    lista_sintomas = parser(content)
  }
}
