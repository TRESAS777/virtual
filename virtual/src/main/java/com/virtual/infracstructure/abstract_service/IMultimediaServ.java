package com.virtual.infracstructure.abstract_service;

import com.virtual.api.dto.request.MultimediaReq;
import com.virtual.api.dto.response.MultimediaResp;

public interface IMultimediaServ extends CrudService<MultimediaReq, MultimediaResp, Long>{
    public String FIELD_BY_SORT = "type";
    
}
