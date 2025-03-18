package com.myproject.core.models.impl;

import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.Template;
import com.myproject.core.models.TitleComponent;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


import java.text.SimpleDateFormat;
import java.util.*;


@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {TitleComponent.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleComponentImpl implements TitleComponent {

    @ValueMapValue
    private String title;

    @ScriptVariable
    private Page currentPage;

    public String getTitle() {
        return (title != null && !title.isEmpty()) ? title : currentPage.getTitle();
    }

    @Override
    public List<String> getTags() {
        List<String> tagTitles = new ArrayList<>();
        Tag[] pageTags = currentPage.getTags();
        for (Tag tag : pageTags) {
            tagTitles.add(tag.getTitle());
        }
        return tagTitles;
    }

    public String getName() {
        return currentPage.getName();
    }

    public Locale getLanguage() {
        return currentPage.getLanguage();
    }

    public Template getTemplate() {
        return currentPage.getTemplate();
    }

    public String getProperties() {
        ValueMap properties= currentPage.getProperties();
        return properties.get("customField", String.class);

    }

    public String getLastModified() {
        Calendar lastModified = currentPage.getLastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
        return sdf.format(lastModified.getTime());
    }

    public String getNavigationTitle() {
        return currentPage.getNavigationTitle();
    }

    public String getPageManager() {
        return currentPage.getPageManager().toString();
    }

    public String getPath() {
        return currentPage.getPath();
    }

    /* public Page getParent(){
         return currentPage.getParent();
     }*/
    public Page getParent(int level) {
        return currentPage.getParent();
    }

    public boolean hasContent() {
        return currentPage.hasContent();
    }

    public boolean isValid() {
        return currentPage.isValid();
    }

    public boolean isLocked() {
        return currentPage.isLocked();
    }
}