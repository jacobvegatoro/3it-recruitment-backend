package com.tresit.msrecruitment.app.pdf.controller;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.tresit.msrecruitment.app.pdf.model.Tutorial;
import com.tresit.msrecruitment.app.pdf.repository.TutorialRepository;
import com.tresit.msrecruitment.app.pdf.service.TutorialService;

import javassist.bytecode.ByteArray;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ReportController {

	//@Autowired
	//TutorialRepository tutorialRepository;

	@Autowired
	TutorialService tutorialService;

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

		// return "Hola";
	}

	private String parseHTMLTemplate(String htmlTemplate) throws IOException {
		
		//String fileName = "plantilla";
		String fileName = RandomStringUtils.randomAlphanumeric(8);
		
		String dir = "src/main/resources/templates/";
		FileOutputStream outputStream = new FileOutputStream(dir + fileName + ".html");
	    byte[] strToBytes = htmlTemplate.getBytes();
	    outputStream.write(strToBytes);
	    outputStream.close();
		
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);

		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);

		Context context = new Context();
		context.setVariable("to", "Baeldung");

		return templateEngine.process(fileName, context);

		// return "Hola";
	}

	public void generatePdfFromHtml(String html) throws IOException, DocumentException {
		String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
		OutputStream outputStream = new FileOutputStream(outputFolder);

		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		renderer.createPDF(outputStream);

		outputStream.close();
	}

	public ByteArrayOutputStream generateStreamPdfFromHtml(String html) throws IOException, DocumentException {
		// String outputFolder = System.getProperty("user.home") + File.separator +
		// "thymeleaf.pdf";
		// OutputStream outputStream = new FileOutputStream(outputFolder);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		renderer.createPDF(outputStream);

		outputStream.close();

		// System.out.println(outputStream.toString());

		return outputStream;
	}

	@GetMapping("/report")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		List<Tutorial> tutorials = new ArrayList<Tutorial>();

		if (title == null)
			tutorialService.getAll().forEach(tutorials::add);
		else
			tutorialService.getByTitle(title).forEach(tutorials::add);

		if (tutorials.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		// System.out.println("Contenido: " + parseThymeleafTemplate());

		// String html = "<html><head></head><body><h1>Hola
		// mundo!!!!</h1></body></html>";

		try {
			// generatePdfFromHtml(html);
			generatePdfFromHtml(parseThymeleafTemplate());
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	}

	@GetMapping(value = "/pdf")
	public ResponseEntity<byte[]> getPdfFile() {
		/*
		 * StreamingResponseBody stream = output -> {
		 * 
		 * ByteArrayOutputStream baos = null; try { baos =
		 * generateStreamPdfFromHtml(parseThymeleafTemplate()); } catch
		 * (DocumentException e) { e.printStackTrace(); }
		 * System.out.println("Stream: "); System.out.println(baos.toString());
		 * OutputStreamWriter osw = new OutputStreamWriter(baos); osw.close();
		 * System.out.println("Archivo: "); System.out.println(osw.toString()); };
		 */

		String html = "<html><head></head><body><h1>Hola mundo!!!!</h1></body></html>";
		
		ByteArrayOutputStream baos = null;
		try {
			//baos = generateStreamPdfFromHtml(parseThymeleafTemplate());
			baos = generateStreamPdfFromHtml(parseHTMLTemplate(html));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=archivo.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(baos.toByteArray());
	}
}
