package nl.animundo.apps.alpacashowadmin.backend.services.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.sun.xml.bind.v2.util.ClassLoaderRetriever.getClassLoader;

public class ApplicationPropertiesService {
    private static Logger logger = LoggerFactory.getLogger(ApplicationPropertiesService.class);

    // TODO: Make environment configurable
    private static String environment = "dev";

    private ApplicationPropertiesService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }


    public static Properties getApplicationProperties() throws IOException {

        Properties applicationProperties = new Properties();

        if ("prd".equalsIgnoreCase(environment) || "dev".equalsIgnoreCase(environment)) {
            applicationProperties = getResourceAsStreem(applicationProperties, environment);
            logger.info(environment + " properties set.");
        } else {
            applicationProperties = getResourceAsStreem(applicationProperties, "dev");
            logger.info("Environment not detected. Development properties set.");
        }
        return applicationProperties;
    }

    private static Properties getResourceAsStreem(Properties applicationProperties, String environment) {
        try {
            InputStream resourceAsStream = getClassLoader().getResourceAsStream(environment + ".application.properties");
            if (resourceAsStream != null) {
                applicationProperties.load(resourceAsStream);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return applicationProperties;
    }
}
