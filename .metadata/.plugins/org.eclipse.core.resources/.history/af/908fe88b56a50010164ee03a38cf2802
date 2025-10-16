package br.com.serratec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private static List<Aluno> alunos = new ArrayList<>();

	static {
		alunos.add(new Aluno(1L, "Ana", "ana@gmail.com"));
		alunos.add(new Aluno(2L, "Igor", "igor@gmail.com"));
	}

	@GetMapping
	public List<Aluno> listar() {
		return alunos;
	}

	@PostMapping
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}

	@GetMapping("{id}")
	public Aluno buscar(@PathVariable Long id) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getId().equals(id)) {
				return alunos.get(i);
			}
		}
		return null;
	}

	@DeleteMapping("{id}")
	public void apagar(@PathVariable Long id) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getId().equals(id)) {
				alunos.remove(i);
				break;
			}
		}
	}

	@PutMapping("{id}")
	public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getId().equals(id)) {
				Aluno a = new Aluno(id, aluno.getNome(), aluno.getEmail());
				alunos.set(i, a);
				return a;
			}
		}
		return null;
	}

}
