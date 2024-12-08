package com.my_library.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_library.entities.*;
import com.my_library.repositories.LivresRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping({"/livres","/hom*"})
@CrossOrigin(origins = "*")
public class LivresController {
	
	@Autowired
	private LivresRepository livresRepository;
	
	@GetMapping("/list")
	public List<Livres> getAllLivres(){
		return (List<Livres>) livresRepository.findAll();
	}
	
	@PostMapping("/add")
	public Livres ajoutLivres(@Valid @RequestBody Livres livre) {
		//TODO: process POST request
		
		return livresRepository.save(livre);
	}
	
	
	@PutMapping("/{livresId}")
	public Livres updateLivres(@PathVariable Long livresId,@Valid @RequestBody Livres livresRequest) {
		//TODO: process PUT request
		
		return livresRepository.findById(livresId).map(livre -> {
			livre.setTitre(livresRequest.getTitre());
			livre.setAuteur(livresRequest.getAuteur());
			livre.setAuteur(livresRequest.getAuteur());
			livre.setISBN(livresRequest.getISBN());
			livre.setCategory(livresRequest.getCategory());
			livre.setNbExemplaires(livresRequest.getNbExemplaires());
			livre.setDatePub(livresRequest.getDatePub());
			livre.setLocalisation(livresRequest.getLocalisation());
			livre.setStatutliv(livresRequest.getStatutliv());
		    return livresRepository.save(livre);
		}).orElseThrow(() -> new IllegalArgumentException("livresId " + livresId + "not found"));
		
		}
	
	@DeleteMapping("/{livresId}")
	public ResponseEntity<?> deleteLivre (@PathVariable Long livresId){
		return livresRepository.findById(livresId).map(livre -> {
			livresRepository.delete(livre);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("livresId " + livresId + "not found"));
	
	}
	
	@GetMapping("/{livresId}")
	public Livres getLivre(@PathVariable Long livresId) {
		
		Optional<Livres> l = livresRepository.findById(livresId);
		return l.get();
	}
	
	

}
