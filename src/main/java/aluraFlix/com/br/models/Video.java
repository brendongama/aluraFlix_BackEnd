package aluraFlix.com.br.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Max(value = 30, message = "O campo TITULO deve ter no máximo 30 caracteres")
	private String titulo;
	
	@NotBlank(message = "O campo DESCRIÇÃO não pode ser nulo ou vazio")
	private String descricao;
	
	@NotBlank(message = "O campo URL não pode ser nulo ou vazio")
	private String url;

}
