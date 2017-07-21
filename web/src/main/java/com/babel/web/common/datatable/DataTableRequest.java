package com.babel.web.common.datatable;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lenovo on 2017/7/20.
 */
public class DataTableRequest {

    public DataTableRequest(String aoData) throws Exception {
        JSONArray jsonarray = new JSONArray(aoData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("iDisplayLength"))
                setDisplayLength(obj.getInt("value"));
            if (obj.get("name").equals("iDisplayStart")) {
                setDisplayStart(obj.getInt("value"));
            }
            if (obj.get("name").equals("sEcho")) {
                setDisplayStart(obj.getInt("value"));
            }
        }
    }
    private Integer displayStart = 0;
    private Integer displayLength = 0;

    public Integer getPageNumber() {
        return this.displayStart == 0 ? 1 : (this.displayStart / this.displayLength) + 1;
    }

    public Integer getDisplayStart() {
        return displayStart;
    }

    public void setDisplayStart(Integer displayStart) {
        this.displayStart = displayStart;
    }

    public Integer getDisplayLength() {
        return displayLength;
    }

    public void setDisplayLength(Integer displayLength) {
        this.displayLength = displayLength;
    }
}
