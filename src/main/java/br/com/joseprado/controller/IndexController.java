package br.com.joseprado.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.joseprado.entity.Acoes;
import br.com.joseprado.entity.Jogo;
import br.com.joseprado.entity.Resultado;
import br.com.joseprado.factory.OrganizaLogFactory;
import br.com.joseprado.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;

@Controller
@Resource
public class IndexController {

	private final Result result;
       
        @Inject
        private Util util;
        
        @Inject
        private OrganizaLogFactory organizaFactory;
        
        @Inject
        private Jogo jogo;
      
	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
	}
        
        @Post("/upload")
        public void upload(UploadedFile arquivoLog){
            if(arquivoLog != null){
                try {
                    String texto  = util.getStringFromInputStream(arquivoLog.getFile());
                    texto = texto.replace("-", "");
                    String[] listTexto = texto.split("\n");
                    jogo = organizaFactory.organizaJogo(listTexto);
                } catch (IOException ex) {
                    Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            Resultado resultado = organizaFactory.getResultado(jogo.getAcoes());
            
            result.include("nomejogo", jogo.getNome());
            result.include("iniciojogo", jogo.getHora_inicio());
            result.include("finaljogo", jogo.getHora_fim());
            result.include("assassino", resultado.getMaiorAssassino());
            result.include("assassinatos", resultado.getNumeroAssassinatos());
            result.include("assassinado", resultado.getMaiorAssassinado());
            result.include("mortes", resultado.getNumeroMortes());
            result.include("arma", resultado.getArmaUsada());
            
        } 

	@Get("/")
	public void index() {
             
            
            result.include("mensagem", "Adicione o log do Jogo");
            result.include("submit", "Enviar");
                
               
                
	}
}