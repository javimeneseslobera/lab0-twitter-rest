package es.unizar.tmdad.lab0.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.unizar.tmdad.lab0.service.TwitterLookupService;

@RestController
public class SearchController {

	@Autowired
	TwitterLookupService twitter;

	@RequestMapping("/search")
	public SearchResults search(@RequestParam("q") String q, Model m) {
		return twitter.search(q);
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UncategorizedApiException.class)
	public SearchResults handleUncategorizedApiException(Model m) {
		return twitter.emptyAnswer();
	}
}