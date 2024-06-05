package com.virtual.infracstructure.abstract_service;

import java.util.List;

import com.virtual.api.dto.request.ClassReq;
import com.virtual.api.dto.response.ClassResp;

public interface IClassService extends CrudService<ClassReq, ClassResp, Long>{
    public List<ClassResp> search(String name, String description);

    public final String FIELD_BY_SORT = "name";
}
