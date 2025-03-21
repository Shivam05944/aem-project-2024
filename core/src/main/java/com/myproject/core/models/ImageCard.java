package com.myproject.core.models;

import java.util.List;

public interface ImageCard {
    /* String getPageTitle();*/
    /* String getFileReference();*/
    /* public String getPageTitle() {
         PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
         Page page = pageManager.getPage(pagePath);
         return page.getTitle();
     }*/
    List<String> getAllPageTitles();

    List<String> getFileReference();

    List<String> getAllPageDescriptions();
    List<String> getAllPage();
}
