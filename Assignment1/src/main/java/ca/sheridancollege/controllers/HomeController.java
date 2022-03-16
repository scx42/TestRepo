package ca.sheridancollege.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class is the controller class and is used to send dynamic content to user
 * @author by Changxin Sun
 */


@Controller
public class HomeController {

	@GetMapping("javaFun")
	public String fillForm() {
		return "javaFun";
	}

	@PostMapping("/submitForm")
	public String thanksForFilling(@RequestParam String haveFun, @RequestParam(required = false) String addEmail,
			@RequestParam String name, @RequestParam String email, HttpServletResponse response) throws IOException {

		//Get an instance of the PrintWriter from response
		PrintWriter out = response.getWriter();
		
		String funSentence = null;
		String emailSentence = null;

		//Compare the value of radio option from dynamic web input and decide what to display in web page
		if (haveFun.equalsIgnoreCase("Yes")) {
			funSentence = "Glad you're having fun!";
		} else {
			funSentence = "Hope it gets better!";
		}

		//decide what to display according to the value from the checkbox
		if (addEmail != null) {
			emailSentence = "We'll add email:" + email + " to our list.";

		} else {
			emailSentence = "We won't add your email to our list.";
		}

		//print in console for testing
		System.out.println(haveFun + " " + addEmail + " " + name + " " + email);
		
		//print out the web page
		out.print("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Thanks for filling out the form</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "<h1>Thanks for filling out the form," + name + "</h1>" + "<h2>" + funSentence + "</h2>" + "<h3>"
				+ emailSentence + "</h3>" + "\r\n" + "</body>\r\n" + "</html>");
		return null;
	}
}
