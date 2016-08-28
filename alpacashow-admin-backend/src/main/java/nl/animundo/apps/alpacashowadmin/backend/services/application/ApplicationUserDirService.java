package nl.animundo.apps.alpacashowadmin.backend.services.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationUserDirService {

    /**
     * This is a system workaround because of user.dir problems.
     * Sometimes the project.basedir is used (Rest Clients form IntelliJ),
     * and sometimes the module.basedir (maven, JUnit)
     * I do not know how to fix this problem.
     * TODO: Look for a fix for the problems with basedirs
     *
     * @return userDir
     */
    public static String getUserDir() {

        String userDir = System.getProperty("user.dir");
        if (userDir.contains("alpacashow-admin-backend")) {
            return userDir;
        } else {
            return System.getProperty("user.dir") + "/alpacashow-admin-backend";
        }
    }
}
