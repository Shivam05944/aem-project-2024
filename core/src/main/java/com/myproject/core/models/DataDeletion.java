package com.myproject.core.models;

import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.RepositoryException;

public interface DataDeletion {
    void getData(String pagePath, ResourceResolver resourceResolver) throws RepositoryException, PersistenceException;

    void addNode(String pagePath, ResourceResolver resourceResolver) throws PersistenceException;

}
