package com.myproject.core.models;

import com.myproject.core.models.impl.MultiCard;

import java.util.List;

public interface BankCard {
    String getImage();

    String getTitle();

    String getHeader();

    List<MultiCard> getForm();
}
