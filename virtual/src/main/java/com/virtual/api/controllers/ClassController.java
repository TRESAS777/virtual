package com.virtual.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.api.dto.request.ClassReq;
import com.virtual.api.dto.response.ClassResp;
import com.virtual.infracstructure.abstract_service.IClassService;
import com.virtual.utils.enums.SortType;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController {
    @Autowired
    private final IClassService classService;

    @GetMapping
    public ResponseEntity<Page<ClassResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType) {

        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.classService.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassResp> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.classService.get(id));
    }

    @PostMapping
    public ResponseEntity<ClassResp> create(
        @Validated @RequestBody ClassReq request
    ){
        return ResponseEntity.ok(this.classService.create(request));
    }
    
}
