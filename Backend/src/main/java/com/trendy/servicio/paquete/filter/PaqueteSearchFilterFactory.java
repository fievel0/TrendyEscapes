package com.trendy.servicio.paquete.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaqueteSearchFilterFactory {

    private final Map<String, PaqueteSearchFilter> criteriaMap;

    @Autowired
    public PaqueteSearchFilterFactory(List<PaqueteSearchFilter> criteriaList){
        criteriaMap = criteriaList.stream().collect(Collectors.toMap(
                criteria -> criteria.getClass().getSimpleName().replace("PaqueteBy", "").replace("Filter", "").toLowerCase(),
                criteria -> criteria
        ));
    }

    public PaqueteSearchFilter getCriteria(String criteria){
        return criteriaMap.getOrDefault(criteria.toLowerCase(), null);
    }

    public Map<String, PaqueteSearchFilter> getMap(){
        return criteriaMap;
    }

}

