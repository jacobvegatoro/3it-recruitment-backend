package com.tresit.msrecruitment.app.pdf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.tresit.msrecruitment.app.pdf.repository.TutorialRepository;

@Controller
@RequestMapping("/reporte")
public class ExampleController {

	private String parseThymeleafTemplate() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);

		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);

		Context context = new Context();
		context.setVariable("to", "Baeldung");

		return templateEngine.process("thymeleaf_template", context);
		
		//return "Hola";
	}

	public void generatePdfFromHtml(String html) throws IOException, DocumentException {
	    String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
	    OutputStream outputStream = new FileOutputStream(outputFolder);

	    //OutputStream outputStream = new ByteArrayOutputStream(outputFolder);

	    ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocumentFromString(html);
	    renderer.layout();
	    renderer.createPDF(outputStream);

	    outputStream.close();
	}

		//http://localhost:8080/reporte/exampleString
		@GetMapping("/exampleString")
		public String exampleString(Model model) {
			System.out.println("llamo a vista");
			//model.addAttribute("name", "Carlitos");			
			//return "example2";

			model.addAttribute("to", "Carlitos");			
			return "thymeleaf_template";

		}
		
		@RequestMapping(value = "/download", method = RequestMethod.GET)
		public void download(HttpServletResponse response) throws IOException {
		    InputStream inputStream = new FileInputStream(new File(System.getProperty("user.home") + File.separator + "thymeleaf.pdf")); //load the file
		    IOUtils.copy(inputStream, response.getOutputStream());
		    response.flushBuffer();
		}
		
}
