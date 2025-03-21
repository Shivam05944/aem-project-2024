package com.myproject.core.models;

import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.RepositoryException;
import java.util.List;

public interface PageService {

    List<String> getPages(String pagePath, String value, String[] tags, ResourceResolver resourceResolver) throws RepositoryException;
}
