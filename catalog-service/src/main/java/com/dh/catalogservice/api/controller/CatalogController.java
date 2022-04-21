package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/catalog")
public class CatalogController {

	private CatalogServiceImpl catalogService;



	@Autowired
	public CatalogController(CatalogServiceImpl catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<?> getCatalogByGenre(@PathVariable String genre) {
		log.info("Bringing the movies and series catalog by genre: "+ genre);
		return ResponseEntity.ok().body(catalogService.getCatalogFromGenre(genre));
	}


	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("name", principal.getAttribute("name"));
	}

	@GetMapping(path ="/detail/{id}")
	public Map<String, Object> detailSecure (@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
											 Authentication auth,
											 @PathVariable("id") Integer id) {
		Map<String, Object> response = new HashMap<>();
		response.put("clientName", authorizedClient.getClientRegistration().getClientName());
		response.put("accessToken", authorizedClient.getAccessToken());
		response.put("authName", auth.getDetails());
		response.put("id", id);

		return response;

	}

}
