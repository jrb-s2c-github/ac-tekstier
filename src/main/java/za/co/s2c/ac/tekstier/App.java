package za.co.s2c.ac.tekstier;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

import javax.net.ssl.HttpsURLConnection;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        String username = args[0];
        String password = args[1];

        if (args.length == 3 && args[2].equals ("dev")) {
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        }

        String sessionId = null;
        DecryptionClient client = Feign.builder().
                encoder(new GsonEncoder()).decoder(new GsonDecoder()).
                target(DecryptionClient.class, "https://localhost:8443");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            if (next.startsWith(":q"))
                break;

            // TODO pwd and username from command line
            DecryptionRequestBean request = DecryptionRequestBean.builder().email(username).
                    password(password).appId("f2aac19d-b464-4c04-979e-af1937399f3b").alg("AES").mode("FPE").
                    accountId("85542a03-1574-4e9a-a2ae-587ab16146dc").sessionId(sessionId).cipher(next).build();
            DecryptionResponseBean response = client.decrypt(request);
            sessionId = response.sessionId;
            System.out.println("# " + response.plain);
        }
    }
}
