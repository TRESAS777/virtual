package com.virtual.infracstructure.abstract_service;

import com.virtual.api.dto.request.LessonReq;
import com.virtual.api.dto.response.LessonResp;

public interface ILessonServ extends CrudService<LessonReq, LessonResp, Long>{
    public String FIELD_BY_SORT = "title";
    
}
