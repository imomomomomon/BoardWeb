package com.example.boardweb.component;

import com.example.boardweb.bean.PageBean;

public class PagingComponent {
    private PagingComponent() {
    }
    private static PagingComponent inst = null;
    public static PagingComponent getInst(){
        if(inst == null) inst = new PagingComponent();
        return inst;
    }

    public PageBean createPageBean(int pageScale, int totalRow) {
        int currentPage = 1;
        int start=1+(currentPage-1)*pageScale;
        int end=pageScale+(currentPage-1)*pageScale;
        int totalPage =
                totalRow%pageScale==0?(totalRow/pageScale):(totalRow/pageScale)+1;
        totalPage=totalPage==0?1:totalPage;

        int currentBlock = currentPage%pageScale
                == 0?(currentPage/pageScale):(currentPage/pageScale)+1;
        int startPage = 1+(currentBlock-1)*pageScale;
        int endPage = (pageScale+(currentBlock-1)*pageScale);
        if(endPage>totalPage)endPage=totalPage;

        return new PageBean(pageScale,currentPage,currentBlock,totalPage,start,end,startPage,endPage);
    }

    public void updateCurPage(PageBean bean,int updatePage,int totalRow) {
        int pageScale = bean.getPageScale();
        int start=1+(updatePage-1)*pageScale;
        int end=pageScale+(updatePage-1)*pageScale;
        int totalPage =
                totalRow%pageScale==0?(totalRow/pageScale):(totalRow/pageScale)+1;
        totalPage=totalPage==0?1:totalPage;
        int currentBlock = updatePage%pageScale
                == 0?(updatePage/pageScale):(updatePage/pageScale)+1;
        int startPage = 1+(currentBlock-1)*pageScale;
        int endPage = (pageScale+(currentBlock-1)*pageScale);
        if(endPage>totalPage)endPage=totalPage;

        bean.set(updatePage,currentBlock,totalPage,start,end,startPage,endPage);
    }
}
