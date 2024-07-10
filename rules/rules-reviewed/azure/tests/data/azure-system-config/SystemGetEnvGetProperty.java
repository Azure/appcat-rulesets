// Contains code that should match for the following tests:
//
// eap-to-azure-appservice-environment-variables-001

public class SystemGetEnvGetProperty {

    static {
        String port;
        if ((port = System.getProperty("test.port")) != null) {
            TEST_PORT = Integer.parseInt(port);
        }
    }

    public static void main(String[] args) {
        int PORT = -1;

        // Attempt to read a port number from the environment
        try {
            PORT = Integer.parseInt(System.getenv("PORT"));
        } catch (Exception ex) {
        }

        // Attempt to read the port number from a System property
        try {
            PORT = Integer.parseInt(System.getProperty("PORT"));
        } catch (Exception ex) {
        }

        if (PORT < 0) {
            PORT = 8080;
        }

        System.out.println(String.format("Found port: %d", PORT));
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        List<String> profiles = new ArrayList<>();
        if (Boolean.parseBoolean(System.getProperty("profile.eventScheduler", Boolean.toString(true)))) {
            profiles.add("EventScheduler");
        }
        if (Boolean.parseBoolean(System.getProperty("profile.taskScheduler", Boolean.toString(true)))) {
            profiles.add("TaskScheduler");
        }
        System.setProperty("org.jboss.logging.provider", "slf4j");
        return builder.sources(SpringInitializer.class);
    }

    private String getSuffix() {
        HttpClient httpClient = HttpClient.create()
                .proxy(proxy -> proxy
                        .type(ProxyProvider.Proxy.HTTP)
                        .host(System.getProperty("https.proxyHost"))
                        .port(Integer.valueOf(System.getProperty("https.proxyPort")))
                        .nonProxyHosts(createNonProxyPattern(System.getProperty("http.nonProxyHosts"))));
        String suffix = "";
        String instance = System.getenv("INSTANCE_ID");
        if (StringUtils.isNotEmpty(instance)) {
            String[] split = StringUtils.split(instance, "-");
            if (split.length > 0) {
                suffix = "-" + split[0];
            }
        }
        return suffix;
    }

}
