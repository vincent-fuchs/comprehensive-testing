package com.github.vincent_fuchs.comprehensive_testing.integration;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
public class AllServicesTest {

    private static Logger LOGGER = LoggerFactory.getLogger(AllServicesTest.class);

    private static List<Process> processes = new ArrayList<>();

    public static void initRegistryServer() throws IOException {
        String registryServerJarLocation = getServerJarLocation("registry-server");
        String registryServerJarName = "registry-server.jar";
        URL registryUrl = new URL("http://localhost:8761/info");
        createProcess(registryServerJarLocation, registryServerJarName, registryUrl);
    }


    public static void initCountryServer() throws MalformedURLException {
        String registryServerJarLocation = getServerJarLocation("rest-microservices-country");
        String registryServerJarName = "rest-microservices-country.jar";
        URL registryUrl = new URL("http://localhost:7070/info");
        createProcess(registryServerJarLocation, registryServerJarName, registryUrl);
    }

    public static void initProductServer() throws MalformedURLException {
        String registryServerJarLocation = getServerJarLocation("rest-microservices-product");
        String registryServerJarName = "rest-microservices-product.jar";
        URL registryUrl = new URL("http://localhost:8080/info");
        createProcess(registryServerJarLocation, registryServerJarName, registryUrl);
    }

    public static void initVolatilityIndexServer() throws MalformedURLException {
        String registryServerJarLocation = getServerJarLocation("rest-microservices-volatility-index");
        String registryServerJarName = "rest-microservices-volatility-index.jar";
        URL registryUrl = new URL("http://localhost:9090/info");
        createProcess(registryServerJarLocation, registryServerJarName, registryUrl);
    }

    private static void createProcess(String jarLocation, String jarName, URL urlToTest) {
        try {
            Process process = new ProcessBuilder("java", "-jar", jarName)
                    .directory(new File(jarLocation)).start();
            RestTemplate template = new TestRestTemplate();
            Thread.sleep(60000);
            int i = 0;
            for (; i <= 5; i++) {
                try {
                    template.getForEntity(urlToTest.toString(), String.class);
                    processes.add(process);
                    LOGGER.info(urlToTest + " is up <----------");
                    break;
                } catch (RestClientException rce) {
                    LOGGER.error(urlToTest + " is not up yet");
                }
                Thread.sleep(10000);
            }
            if (i == 5) {
                throw new AssertionError("Couldn't run 'java -jar " + jarName + "' on location : " + jarLocation);
            }
        } catch (Exception ex) {
            LOGGER.error("Couldn't start the sever : ", ex);
            throw new AssertionError("Couldn't run 'java -jar " + jarName + "' on location : " + jarLocation);
        }
    }

    private static String getServerJarLocation(String serverFolderName) {
        ClassLoader currentClassLoader = AllServicesTest.class.getClassLoader();
        String currentPath = new File(currentClassLoader.getResource("").getPath()).getParent();
        String parentLocation = StringUtils.removeEnd(currentPath, File.separator + "rest-microservices-cart" + File.separator + "target");
        return parentLocation + File.separator + serverFolderName + File.separator + "target";
    }

    public static void destroyServers() {
        if (CollectionUtils.isNotEmpty(processes)) {
            processes.forEach(Process::destroy);
        }
    }
}
