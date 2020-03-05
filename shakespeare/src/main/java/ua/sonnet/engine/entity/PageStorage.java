package ua.sonnet.engine.entity;

import java.util.ArrayList;
import java.util.List;

public class PageStorage {

    private List<Page> pages;

    public PageStorage() {
        pages = new ArrayList<>();
    }

    public PageStorage(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void addPage(Page page){
        pages.add(page);
    }

    @Override
    public String toString() {
        return "PageStorage{" +
                "pages=" + pages +
                '}';
    }
}
