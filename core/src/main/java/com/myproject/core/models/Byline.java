package com.myproject.core.models;

import java.util.List;

public interface Byline {
    String getImagePath();

    String getName();

    List<String> getOccupations();

    boolean isEmpty();
}
