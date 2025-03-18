package com.myproject.core.models;
import com.myproject.core.models.impl.MultiTab;

import java.util.List;

public interface Tab {
    List<MultiTab> getForm();
    String getHeading();
}
