package nl.animundo.apps.alpacashowadmin.backend.services.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationPropertiesService {
    private static Logger logger = LoggerFactory.getLogger(ApplicationPropertiesService.class);

    private static String workingDir = ApplicationUserDirService.getUserDir();

    private ApplicationPropertiesService() throws InstantiationException {
        throw new InstantiationException("Instances of this type are forbidden!");
    }

    public static Properties getApplicationProperties(String environment) throws IOException {

        Properties applicationProperties = new Properties();

        if (environment.equalsIgnoreCase("prd")) {
            applicationProperties.load(new FileReader(new File(workingDir + "/prd.application.properties")));
            logger.info("Production properties set.");
        } else if (environment.equalsIgnoreCase("dev")) {
            applicationProperties.load(new FileReader(new File(workingDir + "/dev.application.properties")));
            logger.info("Development properties set.");
        } else {
            applicationProperties.load(new FileReader(new File(workingDir +"/dev.application.properties")));
            logger.info("Environment not detected. Development properties set.");
        }
        return applicationProperties;
    }
}
