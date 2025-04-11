package com.myproject.core.models;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Student Details" , description = "Enter Student details")
public @interface StudentConfiguration {

    @AttributeDefinition(name = "Student Name" , type = AttributeType.STRING, description = "Enter Student Name")
    public String getStudentName() default "Shivam";

    @AttributeDefinition(name = "Roll No" , type = AttributeType.INTEGER, description = "Enter Roll No")
    public int getRollNumber() default 4;

    @AttributeDefinition(name = "Regular" , type = AttributeType.BOOLEAN, description = "Is student is regular")
    public boolean getRegular() default true;

    @AttributeDefinition(name = "Subjects" , type = AttributeType.STRING, description = "See Your Subjects")
    public String[] getSubjects() default {"maths,english,sanskrit"};

    @AttributeDefinition(name = "Countries" , type = AttributeType.STRING, description = "Select your countries",
    options = {
            @Option(label = "India", value = "india"),
            @Option(label = "Russia", value = "russia"),
            @Option(label = "France", value = "france"),
            @Option(label = "America", value = "america"),
    })
    public String getCountries() default "India";
}
