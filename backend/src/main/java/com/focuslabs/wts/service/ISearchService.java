package com.focuslabs.wts.service;

import com.focuslabs.wts.vo.SearchResultVO;

import java.util.ArrayList;

/**
 * Created by Samson Tekleab on 3/24/2016.
 */
public interface ISearchService {

    ArrayList<SearchResultVO> search(String[] q);
}
