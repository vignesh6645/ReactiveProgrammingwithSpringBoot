package com.example.springReactiveApplication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Flux<Student> findAll() {
        return studentRepository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    public Mono<Student> save(StudentRequest request) {
        return studentRepository.save(
                Student.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .age(request.getAge())
                        .build()
        );
    }

    public Flux<Student> findByFirstname(String firstname) {
        return studentRepository.findAllByFirstnameContainingIgnoreCase(firstname);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id).subscribe();
    }
}
