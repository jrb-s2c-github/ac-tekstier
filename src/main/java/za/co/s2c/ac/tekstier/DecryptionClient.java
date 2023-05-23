package za.co.s2c.ac.tekstier;

import feign.Headers;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface DecryptionClient {

    @RequestLine("POST crypto/decrypt")
    public DecryptionResponseBean decrypt(DecryptionRequestBean request);

}
