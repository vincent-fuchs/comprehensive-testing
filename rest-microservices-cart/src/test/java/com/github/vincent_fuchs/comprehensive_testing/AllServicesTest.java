package com.github.vincent_fuchs.comprehensive_testing;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul
 *
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CartRestfulApp.class)
@WebAppConfiguration
@IntegrationTest
public class AllServicesTest {

    private static Logger LOGGER = LoggerFactory.getLogger(AllServicesTest.class);

    private static List<Process> processes = new ArrayList<>();


    @BeforeClass
    public static void initServers() throws IOException {
        initRegistryServer();
    }

    private static void initRegistryServer() throws IOException {
        String registryServerJarLocation = getRegistryServerJarLocation();
        String registryServerJarName = "registry-server.jar";
        URL registryUrl = new URL("http://localhost:8761/info");
        createProcess(registryServerJarLocation, registryServerJarName, registryUrl);
    }

    private static void createProcess(String jarLocation, String jarName, URL urlToTest) {
        try {
            Process process = new ProcessBuilder("java", "-jar", jarName)
                    .directory(new File(jarLocation)).start();
            RestTemplate template = new TestRestTemplate();
            Thread.sleep(10000);
            for (int i = 0; i <= 5; i++) {
                try {
                    template.getForEntity(urlToTest.toString(), String.class);
                    processes.add(process);
                    break;
                } catch (RestClientException rce) {
                    LOGGER.error(urlToTest + " is not up yet");
                }
                Thread.sleep(10000);
            }
        } catch (Exception ex) {
            LOGGER.error("Couldn't start the sever : ", ex);
            throw new AssertionError("Couldn't run 'java -jar " + jarName + "' on location : " + jarLocation);
        }
    }

    private static String getRegistryServerJarLocation() {
        ClassLoader currentClassLoader = AllServicesTest.class.getClassLoader();
        String currentPath = new File(currentClassLoader.getResource("").getPath()).getParent();
        String parentLocation = StringUtils.removeEnd(currentPath, "/rest-microservices-cart/target");
        return parentLocation + "/registry-server/target";
    }

    @Test
    public void test() {

    }

    @AfterClass
    public static void destroyServers() {
        if (CollectionUtils.isNotEmpty(processes)) {
            processes.forEach(Process::destroy);
        }
    }
}
