package com.sports.life.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sports.life.vo.respVO.PageVO;

import java.util.List;

/**
 * 分页工具类
 */
public class PageUtil {
    private PageUtil(){}
    public static <T> PageVO getPageVo(List<T> list){
        PageVO<T> pageVO=new PageVO<>();
        if(list instanceof Page){
            Page page = (Page)list;
            pageVO.setTotalRows(page.getTotal());
            pageVO.setList(page.getResult());
            pageVO.setTotalPages(page.getPages());
            pageVO.setCurPageSize(page.size());
            pageVO.setPageNum(page.getPageNum());
            pageVO.setPageSize(page.getPageSize());
        }
        return pageVO;
    }

    public static <T> PageVO getPageVoFromPageInfo(PageInfo pageInfo,List<T> list){
        PageVO<T> pageVO=new PageVO<>();
            pageVO.setTotalRows(pageInfo.getTotal());
            pageVO.setList(list);
            pageVO.setTotalPages(pageInfo.getPages());
            pageVO.setCurPageSize(pageInfo.getSize());
            pageVO.setPageNum(pageInfo.getPageNum());
            pageVO.setPageSize(pageInfo.getPageSize());
        return pageVO;
    }
}
