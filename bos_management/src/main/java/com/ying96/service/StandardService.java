package com.ying96.service;

import com.ying96.domain.base.Standard;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */
public interface StandardService {
    public void save(Standard standard);

    public List<Standard> findByName(String name);
}
