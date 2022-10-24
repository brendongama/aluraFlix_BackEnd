package aluraFlix.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluraFlix.com.br.models.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{

}
