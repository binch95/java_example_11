package com.koreaIt;

public class DayList {
    long Id;
    String Content;

    public DayList(long Id, String Content) {
        this.Id = Id;
        this.Content = Content;
    }

    public long getId() {
        return Id;
    }

    public String getContent() {
        return Content;
    }

    public long setId(long Id) {
        this.Id = Id;
        return Id;
    }

    public String setContent(String Content) {
        this.Content = Content;
        return Content;
    }
}
