package com.virtual.infracstructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.virtual.api.dto.request.LessonReq;
import com.virtual.api.dto.response.LessonResp;
import com.virtual.domain.entities.Lesson;
import com.virtual.domain.repositories.LessonRepo;
import com.virtual.infracstructure.abstract_service.ILessonServ;
import com.virtual.utils.enums.SortType;
import com.virtual.utils.exceptions.BadRequestException;
import com.virtual.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonServ{

    @Autowired
    private final LessonRepo lessonRepo;

    @Override
    public LessonResp create(LessonReq request) {
        Lesson lesson = this.requestToEntity(request);

        return this.entityToResp(this.lessonRepo.save(lesson));
    }

    @Override
    public LessonResp get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public LessonResp update(LessonReq request, Long id) {
        Lesson lesson = this.find(id);

        Lesson lessonUpdate = this.requestToEntity(request);
        lessonUpdate.setId(id);
        lessonUpdate.setClass1(lesson.getClass1());
        return this.entityToResp(this.lessonRepo.save(lessonUpdate));
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = this.find(id);
        this.lessonRepo.delete(lesson);
    }

    @Override
    public Page<LessonResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.lessonRepo.findAll(pagination)
                .map(this::entityToResp);
    }

    private LessonResp entityToResp(Lesson entity) {

        return LessonResp.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .active(entity.getActive())
                .build();
    }

    private Lesson requestToEntity(LessonReq request) {

        return Lesson.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    private Lesson find(Long id) {

        return this.lessonRepo.findById(id)
            .orElseThrow(() -> new 
            BadRequestException(ErrorMessages
            .idNotFound("Servicio")));
    }
}
