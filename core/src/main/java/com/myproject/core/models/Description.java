package com.myproject.core.models;

import com.myproject.core.models.impl.Form;

import java.util.List;

public interface Description {

    String getTitle();

    String getSubtitle();

    String getDatetime();

    String getDescription();

    String getRegisterLink();

    String getFileReference();

    List<Form> getForm();
}
