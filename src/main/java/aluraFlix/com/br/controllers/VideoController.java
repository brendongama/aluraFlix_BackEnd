package aluraFlix.com.br.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aluraFlix.com.br.Services.VideoService;
import aluraFlix.com.br.models.Video;


@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoService service;
		 
	@GetMapping
	private ResponseEntity<List<Video>> getAllVideos() {
		List<Video> listVideos = service.getAllVideos();
		if(listVideos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listVideos);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Video> getOneVideo(@PathVariable Integer id) {
		Optional<Video> video = service.getOneVideo(id);
		if(video.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(video.get());
	}
	
	@PostMapping
	private ResponseEntity<Video> getOneVideo(@RequestBody Video video) {
	Video newVideo = service.saveVideo(video);
		return ResponseEntity.status(HttpStatus.CREATED).body(newVideo);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Video> deleteOneVideo(@PathVariable Integer id) {	
		Optional<Video> oldVideo = service.getOneVideo(id);
		if(oldVideo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteVideo(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Video> putVideo(@RequestBody Video video, @PathVariable Integer id) {
		Optional<Video> oldVideo = service.getOneVideo(id);
		if(oldVideo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		video.setId(oldVideo.get().getId());
		Video newVideo = service.saveVideo(video);
		return ResponseEntity.status(HttpStatus.CREATED).body(newVideo);
	}
	
	
}
