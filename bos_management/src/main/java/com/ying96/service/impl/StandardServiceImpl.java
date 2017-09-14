package com.ying96.service.impl;

import com.ying96.domain.base.Standard;
import com.ying96.repository.StandardRepository;
import com.ying96.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

@Service
@Transactional
public class StandardServiceImpl implements StandardService{

    @Autowired
    private StandardRepository standardRepository ;

    @Override
    public void save(Standard standard) {
        standardRepository.save(standard) ;
    }

    @Override
    public List<Standard> findByName(String name) {
      return   standardRepository.findByName(name);
    }
}
