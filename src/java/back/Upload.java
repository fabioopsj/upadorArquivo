package back;
import java.io.IOException;
import java.util.Scanner;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;


@ManagedBean (name = "bean")
@Named
@RequestScoped
public class Upload {
    private UploadedFile file;
    private String verificaTexto;

    public UploadedFile getFile() {
        return file;
    }
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public void upload() throws IOException{ 
        if (file != null) {
            FacesMessage message = new FacesMessage("Sucesso!", file.getFileName() + " foi add com sucesso !");
            FacesContext.getCurrentInstance().addMessage(null, message);
            verificaTexto = new Scanner(file.getInputstream(), "UTF-8").useDelimiter("\\A").next();
        }else{
            FacesMessage message = new FacesMessage("Erro !", "Nenhum arquivo !");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    public String conteudo(){
        return verificaTexto;
    }
    public String getConteudoDoArquivo() {
        return verificaTexto;
    }
    public void setConteudoDoArquivo(String verificaTexto) {
        this.verificaTexto = verificaTexto;
    }   
}