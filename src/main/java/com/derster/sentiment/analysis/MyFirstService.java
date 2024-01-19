package com.derster.sentiment.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-pro.properties")
})
public class MyFirstService {


    private final MyFirstClass myFirstClass;
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("${my.custom.property}")
    private String dataFromProp;
    @Value("${my.prop2}")
    private String customProp2;
    private Environment environment;

    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }



    /*@Autowired
    public void setMyFirstClass( MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }*/

    public String tellAStory(){
        return "The dependency is saying : "+myFirstClass.sayHello();
    }
    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }
    public String getOsName(){
        return environment.getProperty("os.name");
    }
    public String readProp(){
        return environment.getProperty("my.custom.property");
    }

    @Autowired
    public void setEnvironment(Environment environment){
        this.environment = environment;
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getDataFromProp() {
        return dataFromProp;
    }

    public String getCustomProp2() {
        return customProp2;
    }
}
