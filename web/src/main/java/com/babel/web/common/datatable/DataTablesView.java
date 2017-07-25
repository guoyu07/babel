package com.babel.web.common.datatable;

import java.util.List;

/**
 * Created by lenovo on 2017/7/19.
 */
public class DataTablesView < T > {
    private List< T > data; //data 与datatales 加载的「dataSrc"对应
    private int recordsTotal;
    private int recordsFiltered;
    private int draw;
    public DataTablesView() {}
    public int getDraw() {
        return draw;
    }
    public void setDraw(int draw) {
        this.draw = draw;
    }
    public List < T > getData() {
        return data;
    }
    public void setData(List < T > data) {
        this.data = data;
    }
    public int getRecordsTotal() {
        return recordsTotal;
    }
    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
    }
    public int getRecordsFiltered() {
        return recordsFiltered;
    }
    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}