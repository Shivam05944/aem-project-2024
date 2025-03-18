package com.myproject.core.models;

import java.util.List;

public interface TagList {

    List<String> getFilteredPages();

    List<String> getPagesByName();

    List<String> getPagesByDate();

   List<String> getFileReference();
}
