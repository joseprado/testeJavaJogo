/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joseprado.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.joseprado.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;

/**
 *
 * @author jose.prado
 */
@Resource
public class ArquivoController {
    
    private final Result result;
        
       
	/**
	 * @deprecated CDI eyes only
	 */
	protected ArquivoController() {
		this(null);
	}
	
	@Inject
	public ArquivoController(Result result) {
		this.result = result;
	}
        
        @Post("/upload")
        public void recebeArquivo(UploadedFile arquivoLog){
            if(arquivoLog == null){
                
            }   
            result.redirectTo("/");
        }
    
}
