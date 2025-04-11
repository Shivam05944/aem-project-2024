package com.myproject.core.servlets;

import com.myproject.core.models.DataDeletion;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(service = {Servlet.class}, property = {"sling.servlet.methods=GET", "sling.servlet.paths=/bin/deletedata"})
public class DataCorrectionServlets extends SlingAllMethodsServlet {

    public String sitePath = "/content/custom/us/en/news/jcr:content/root/container";

    @Reference
    private DataDeletion dataDeletion;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();

        try {
            dataDeletion.getData(sitePath, resourceResolver);
            dataDeletion.addNode(sitePath, resourceResolver);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Data Deletion Successful, Creation");


        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("No changes");
        }
    }
}
