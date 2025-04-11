package com.myproject.core.models.impl;

import com.myproject.core.models.DataDeletion;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.HashMap;
import java.util.Map;

@Component(service = DataDeletion.class)
public class DataDeletionImpl implements DataDeletion {

    @Reference
    private QueryBuilder builder;

    @Override
    public void getData(String pagePath, ResourceResolver resourceResolver) throws RepositoryException, PersistenceException {

        Map<String, String> map = new HashMap<>();

        map.put("path", pagePath);
        map.put("type", "nt:unstructured");
        map.put("group.property", "sling:resourceType");
        map.put("group.property.1_value", "custom/components/title");
        map.put("group.property.2_value", "custom/components/title");
        map.put("p.limit", "-1");

        Query query = builder.createQuery(PredicateGroup.create(map), resourceResolver.adaptTo(Session.class));
        query.setStart(0);
        query.setHitsPerPage(20);

        SearchResult result = query.getResult();
        for (Hit hit : result.getHits()) {
            Resource resource = resourceResolver.getResource(hit.getPath());

            resourceResolver.delete(resource);

        }
        resourceResolver.commit();
    }

    public void addNode(String pagePath, ResourceResolver resourceResolver) throws PersistenceException {


        Resource path = resourceResolver.getResource(pagePath);
        Resource container = path.getChild("container");
        Map<String, Object> properties = new HashMap<>();

        properties.put("jcr:primaryType", "nt:unstructured");
        properties.put("sling:resourceType", "custom/components/image");
        properties.put("title", "image");
        resourceResolver.create(container, "image", properties);
        resourceResolver.commit();

    }

}

