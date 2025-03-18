package com.myproject.core.models.impl;

import com.myproject.core.models.BankCard;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {BankCard.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BankCardImpl implements BankCard {
    @ChildResource
    public List<MultiCard> forms;
    @ValueMapValue
    public String image;

    @ValueMapValue
    public String title;

    @ValueMapValue
    public String header;

    @ValueMapValue
    public String subHeader;


    public String getSubHeader() {
        return subHeader;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public List<MultiCard> getForm() {
        return forms;
    }
}
