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
import com.my_library.repositories.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping({"/livres"})
@CrossOrigin(origins = "*")
public class LivresController {
	
	
	private final LivresRepository livresRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public LivresController(LivresRepository livresRepository, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.livresRepository = livresRepository;
	}
	
	
	@GetMapping("/list")
	public List<Livres> getAllLivres(){
		return (List<Livres>) livresRepository.findAll();
	}
	
	
	@PostMapping("/add/{userId}") 
	public Livres ajoutLivres(@PathVariable (value = "userId") Long userId, @Valid @RequestBody Livres livre) { 
			return userRepository.findById(userId).map(user -> {
			livre.setUser(user); 
			return livresRepository.save(livre); 
	}).orElseThrow(() -> new IllegalArgumentException("userId" + userId + " not found")); 
	} 
	
	/************************************************************************
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
		***************************************************************************/
	@PutMapping("/update/{userId}/{livresId}") 
	public Livres updateLivres(@PathVariable (value = "userId") Long userId, @PathVariable (value = "livresId") Long livresId, 
			@Valid @RequestBody Livres livresRequest) { 
	if(!userRepository.existsById(userId)) { 
	throw new IllegalArgumentException("userId " + userId + "not found"); 
	} 
	
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
	
/************************************************	
	@DeleteMapping("/{livresId}")
	public ResponseEntity<?> deleteLivre (@PathVariable Long livresId){
		return livresRepository.findById(livresId).map(livre -> {
			livresRepository.delete(livre);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("livresId " + livresId + "not found"));
	
	}
*****************************************************/
	
	@DeleteMapping("/delete/{livresId}") 
	public ResponseEntity<?> deleteLivre(@PathVariable (value = "livresId") Long livresId) { 
		return livresRepository.findById(livresId).map(livre -> { 
				livresRepository.delete(livre); 
				return ResponseEntity.ok().build(); 
		}).orElseThrow(() -> new IllegalArgumentException("Article not found with id " + livresId)); 
	} 
	
	
	@GetMapping("/{livresId}")
	public Livres getLivre(@PathVariable Long livresId) {
		
		Optional<Livres> l = livresRepository.findById(livresId);
		return l.get();
	}
	
	

}
