package com.virtual.infracstructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.virtual.api.dto.request.ClassReq;
import com.virtual.api.dto.response.ClassResp;
import com.virtual.domain.entities.ClassEntity;
import com.virtual.domain.repositories.ClassRepository;
import com.virtual.infracstructure.abstract_service.IClassService;
import com.virtual.utils.enums.SortType;
import com.virtual.utils.exceptions.BadRequestException;
import com.virtual.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{

    @Autowired
    private final ClassRepository classRepository;

    @Override
    public ClassResp create(ClassReq request) {
        ClassEntity classEntity = this.requestToEntity(request);
        classEntity.setActive(true);
        return this.entityToResp(this.classRepository.save(classEntity));
    }

    @Override
    public ClassResp get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public ClassResp update(ClassReq request, Long id) {
        throw new UnsupportedOperationException("Unimplemented method ''");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method ''");
    
    }

    @Override
    public Page<ClassResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        this.classRepository.findAll(pagination);

        return this.classRepository.findAll(pagination)
                .map(this::entityToResp);
    }

    @Override
    public List<ClassResp> search(String name, String description) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
    private ClassResp entityToResp(ClassEntity entity){
        return ClassResp.builder()
            .id(entity.getId())
            .name(entity.getName())
            .description(entity.getDescription())
            .active(entity.getActive())
            .build();
    }

    private ClassEntity requestToEntity(ClassReq request){
        return ClassEntity.builder()
            .name(request.getName())
            .description(request.getDescription())
            .build();
    }

    private ClassEntity find(Long id){

        return this.classRepository.findById(id)
            .orElseThrow(() -> new 
            BadRequestException(ErrorMessages
            .idNotFound("ClassEntity")));
    }
}
