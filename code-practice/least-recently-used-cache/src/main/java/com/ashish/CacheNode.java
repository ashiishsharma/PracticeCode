package com.ashish;

/**
 * @author Ashish Sharma
 *         on 10/24/2015.
 */
public class CacheNode<M> {
    private Integer pageNumber;
    private M m;

    public CacheNode(Integer pageNumber, M t) {
        this.pageNumber = pageNumber;
        this.m = t;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}
