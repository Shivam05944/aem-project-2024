package com.myproject.core.models;

import com.myproject.core.models.impl.MultiCompartment;


import java.util.List;

public interface Compartment {
    String getHeading();
    String getSubHeading();
    String getButton();
    String getButtonLabel();
    List<MultiCompartment> getForm();
}
