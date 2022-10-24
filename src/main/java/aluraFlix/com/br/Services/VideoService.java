package aluraFlix.com.br.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aluraFlix.com.br.models.Video;
import aluraFlix.com.br.repositories.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository repository;
	
	public List<Video> getAllVideos() {
		return repository.findAll();
	}
	
	public Optional<Video> getOneVideo(Integer id){
		return repository.findById(id);
	}
	
	public Video saveVideo(Video video) {
		return repository.save(video);
	}
	
	public void deleteVideo(Integer id) {
		repository.deleteById(id);
	}
}
