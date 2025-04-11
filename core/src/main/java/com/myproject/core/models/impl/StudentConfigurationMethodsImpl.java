package com.myproject.core.models.impl;

import com.myproject.core.models.StudentConfiguration;
import com.myproject.core.models.StudentConfigurationMethods;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = StudentConfigurationMethods.class)
@Designate(ocd = StudentConfiguration.class)
public class StudentConfigurationMethodsImpl implements StudentConfigurationMethods {

   private String studentName;
   private int rollNumber;
   private boolean regular;
   private String[] subjects;
   private String countries;

   @Activate()
   protected void start(StudentConfiguration stu){
       studentName = stu.getStudentName();
       rollNumber = stu.getRollNumber();
       regular = stu.getRegular();
       subjects = stu.getSubjects();
       countries = stu.getCountries();
   }

    @Override
    public String getStudentName() {
        return studentName;
    }

    @Override
    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String[] getSubjects() {
        return subjects;
    }

    @Override
    public String getCountries() {
        return countries;
    }

    @Override
    public boolean getregular() {
        return regular;
    }
}
