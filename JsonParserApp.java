import java.nio.file.*;
import java.security.*;
import java.math.*;
import org.json.JSONObject;

public class JsonParserApp {
    public static void main(String[] args) {

            String x = new String(Paths.get("input.json"));
            JSONObject a = new JSONObject(x).getJSONObject("student");
            String name = a.getString("first_name").toLowerCase();
            String roll = a.getString("roll_number").toLowerCase();
            String b = name + roll;
            String ans = output(b);
            Files.write(Paths.get("output.txt"), ans.getBytes());
            System.out.println("Final output: " + ans);
    }

    public static String output(String input) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] answer = md.digest(input.getBytes());
        BigInteger hash = new BigInteger(1, answer);
        return String.format("%032x", hash);
    }
}
