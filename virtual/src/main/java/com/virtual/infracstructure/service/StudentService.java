package com.virtual.infracstructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.virtual.api.dto.request.StudentReq;
import com.virtual.api.dto.response.StudentResponse;
import com.virtual.domain.entities.Student;
import com.virtual.domain.repositories.StudentRepo;
import com.virtual.infracstructure.abstract_service.IStudentServ;
import com.virtual.utils.enums.SortType;
import com.virtual.utils.exceptions.BadRequestException;
import com.virtual.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentServ {

    @Autowired
    private final StudentRepo studentRepo;

    @Override
    public StudentResponse create(StudentReq request) {
        Student student = this.requestToEntity(request);

        return this.entityToResp(this.studentRepo.save(student));
    }

    @Override
    public StudentResponse get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public StudentResponse update(StudentReq request, Long id) {
        Student student = this.find(id);

        Student studentUpdate = this.requestToEntity(request);
        studentUpdate.setId(id);
        studentUpdate.setClass1(student.getClass1());
        return this.entityToResp(this.studentRepo.save(studentUpdate));
    }

    @Override
    public void delete(Long id) {
        Student student = this.find(id);
        this.studentRepo.delete(student);
    }

    @Override
    public Page<StudentResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.studentRepo.findAll(pagination)
                .map(this::entityToResp);
    }

    private StudentResponse entityToResp(Student entity) {

        return StudentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }

    private Student requestToEntity(StudentReq studentReq) {
        return Student.builder()
                .name(studentReq.getName())
                .email(studentReq.getEmail())
                .build();
    }

    private Student find(Long id) {
        return this.studentRepo.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Client")));
    }
}
