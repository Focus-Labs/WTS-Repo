package com.focuslabs.wts.service;

import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.entity.Post;
import com.focuslabs.wts.entity.Traveler;
import com.focuslabs.wts.repository.EventDAO;
import com.focuslabs.wts.repository.PostDAO;
import com.focuslabs.wts.repository.TravelerDAO;
import com.focuslabs.wts.vo.EventVO;
import com.focuslabs.wts.vo.PostVO;
import com.focuslabs.wts.vo.SearchResultVO;
import com.focuslabs.wts.vo.TravelerVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by Samson Tekleab on 3/24/2016.
 */
public class SearchServiceImp implements ISearchService {

    @Autowired
    EventDAO eventDAO;

    @Autowired
    PostDAO postDAO;

    @Autowired
    TravelerDAO travelerDAO;

    ArrayList<SearchResultVO> searchResults = new ArrayList<SearchResultVO>();

    /**
     * Searches database for matches for array that is provided.
     *
     * @param q Array of String objects to search for matches
     * @return ArrayList<SearchResultVO> ArrayList of SearchResultVO.
     * Returns Empty ArrayList if no match found
     **/
    @Override
    public ArrayList<SearchResultVO> search(String[] q) {

        for (Event event :
                eventDAO.findAll()) {
            for (String s :
                    q) {
                if (event.getTitle().contains(s)) {
                    searchResults.add(new EventVO(event));
                }
                break;
            }
        }

        for (Post post :
                postDAO.findAll()) {
            for (String s :
                    q) {
                if (post.getPostText().contains(s)) {
                    searchResults.add(new PostVO(post));
                }
                break;
            }
        }

        for (Traveler traveler :
                travelerDAO.findAll()) {
            for (String s :
                    q) {
                if (traveler.getFullName().contains(s)) {
                    searchResults.add(new TravelerVO(traveler));
                }
                break;
            }
        }

        //TODO Add Host search loop
        //TODO Add Document search loop

        return searchResults;
    }
}
