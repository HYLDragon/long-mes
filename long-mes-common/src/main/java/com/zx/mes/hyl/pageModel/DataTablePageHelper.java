package com.zx.mes.hyl.pageModel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/3.
 */
public class DataTablePageHelper implements Serializable {

    /**
     * EasyUI 分页帮助类
     *
     * @author
     *
     */
    public class PageHelper implements java.io.Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private int page;// 当前页
        private int rows;// 每页显示记录数
        private int start;//第一条数据的起始位置，比如0代表第一条数据
        private int length;//告诉服务器每页显示的条数
        private String sort;// 排序字段
        private String[] order;// asc/desc

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String[] getOrder() {
            return order;
        }

        public void setOrder(String[] order) {
            this.order = order;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

}
