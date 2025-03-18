package com.myproject.core.models.impl;

import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import com.myproject.core.models.TagList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = {TagList.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TagListImpl implements TagList {
    @Self
    private SlingHttpServletRequest request;
    @ValueMapValue
    private String pagePath;

    @Inject
    private Page page;
 /*private School school;
       private Student student;*/

    @ValueMapValue
    private List<String> tags;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private Calendar datepicker;


    public List<String> getFilteredPages() {
        List<String> filteredList = new ArrayList<>();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(pagePath);

        if (resource != null) {
            for (Resource child : resource.getChildren()) {
                Page page = child.adaptTo(Page.class);
                if (page == null) {
                    continue;
                }
                Tag[] pageTags = page.getTags();
                for (Tag tag : pageTags) {
                    if (tags.contains(tag.getTagID())) {
                        filteredList.add(child.getPath());
                    }

                }
            }
        }
        return filteredList;
    }

    @Override
    public List<String> getPagesByName() {
        List<String> filteredListName = new ArrayList<>();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(pagePath);

        if (resource != null) {
            for (Resource child : resource.getChildren()) {
                Page page = child.adaptTo(Page.class);
                if (page != null && page.getTitle().equals(name)) {
                    filteredListName.add(child.getPath());
                }
            }
        }
        return filteredListName;
    }

    @Override
    public List<String> getPagesByDate() {
        List<String> filteredListDate = new ArrayList<>();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(pagePath);

        if (resource != null) {
            for (Resource child : resource.getChildren()) {
                Page page = child.adaptTo(Page.class);

                if (page != null) {
                    Calendar lastModified = page.getLastModified();

                    if (lastModified != null && lastModified.after(datepicker)) {
                        filteredListDate.add(child.getPath());
                    }
                }
            }
        }
        return filteredListDate;
    }

    @Override
    public List<String> getFileReference() {
        List<String> imageReferences = new ArrayList<>();
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource rootResource = resourceResolver.getResource(pagePath);

        if (rootResource != null) {
            for (Resource child : rootResource.getChildren()) {
                Page childPage = child.adaptTo(Page.class);
                if (childPage != null) {
                    Resource contentResource = childPage.getContentResource();
                    if (contentResource != null) {
                        String fileReference = contentResource.getValueMap().get("fileReference", String.class);
                        if (fileReference != null) {
                            imageReferences.add(fileReference);
                        }
                    }
                }
            }
        }
        return imageReferences;
    }



  /*public List<String> getWebsites() {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(websiteList);
        List<String> childPaths = new ArrayList<>();
        for (Resource child : resource.getChildren()) {
            childPaths.add(child.getPath());
        }
        return childPaths;
    }*/
/*
    public List<String> getTags() {
        return School.getSchoolBranches().getBranches();
    }*/

    public String getName() {
        return name;
    }


   /* public Calendar getDatepicker() {
        return datepicker;
    }*/
}
