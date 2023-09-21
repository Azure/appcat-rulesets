import org.json.JSONObject;

public class App {

  public static void main(String[] args) {

    // Get the VCAP_SERVICES env var as a JSON string
    String vcapServices = System.getenv("VCAP_SERVICES");
    
    // Parse into a JSON object
    JSONObject json = new JSONObject(vcapServices);
    
    // Find the MySQL service
    JSONObject mysqlService = json.getJSONArray("mysql").getJSONObject(0);
    
    // Extract connection details
    String mysqlHost = mysqlService.getJSONObject("credentials").getString("host");
    String mysqlPort = mysqlService.getJSONObject("credentials").getString("port");
    String mysqlUsername = mysqlService.getJSONObject("credentials").getString("username");  
    String mysqlPassword = mysqlService.getJSONObject("credentials").getString("password");
    
    // Construct JDBC URL from details 
    String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort;

    // Connect to database using username/password
    connectToDatabase(mysqlUrl, mysqlUsername, mysqlPassword);

  }

}