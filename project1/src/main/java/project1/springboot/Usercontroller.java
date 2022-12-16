package project1.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {

	private final UserRepository repository;

	Usercontroller(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	List<User> all() {
		return repository.findAll();
	}

	@PostMapping("/users")
	User newUser(@RequestBody User newEmployee) {
		return repository.save(newEmployee);
	}

	@GetMapping("/users/{id}")

	Optional<User> one(@PathVariable Long id) {

		return repository.findById(id);

	}

}
