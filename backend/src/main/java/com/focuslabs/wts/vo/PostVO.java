package com.focuslabs.wts.vo;

import com.focuslabs.wts.entity.Post;

/**
 * Created by Samson Tekleab on 3/24/2016.
 */
public class PostVO implements SearchResultVO {

    private Post post;

    public PostVO(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
