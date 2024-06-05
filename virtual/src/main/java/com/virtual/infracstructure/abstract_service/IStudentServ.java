package com.virtual.infracstructure.abstract_service;

import com.virtual.api.dto.request.StudentReq;
import com.virtual.api.dto.response.StudentResponse;

public interface IStudentServ extends CrudService<StudentReq, StudentResponse, Long>{
    
    public String FIELD_BY_SORT = "name";
}
