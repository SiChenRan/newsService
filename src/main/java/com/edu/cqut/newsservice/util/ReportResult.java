package com.edu.cqut.newsservice.util;

import java.util.List;

public class ReportResult {
    private List<String> items;
    private List<Long> values;


    private ReportResult(List<String> items, List<Long> values) {
        this.items = items;
        this.values = values;
    }

    public static ReportResult ok(List<String> items, List<Long> values) {
        return new ReportResult(items, values);
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<Long> getValues() {
        return values;
    }

    public void setValues(List<Long> values) {
        this.values = values;
    }
}
