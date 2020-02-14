package com.hhy.community.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhy1997
 * 2020/1/31
 */
@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPreviews;
    private boolean showFist;
    private boolean showNext;
    private boolean showEnd;
    private Integer page;
    private Integer totalPage;
    //当前显示的页数
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0,page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if (page == 1) {
            showPreviews = false;
        } else {
            showPreviews = true;
        }
        //是否展示下一页
        if (page.equals(totalPage)) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示首页
        if (pages.contains(1)) {
            showFist = false;
        } else {
            showFist = true;
        }
        //是否展示尾页
        if (pages.contains(totalPage)) {
            showEnd = false;
        } else {
            showEnd = true;
        }
    }
}
