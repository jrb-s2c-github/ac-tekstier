package za.co.s2c.ac.tekstier;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Builder
public class DecryptionRequestBean {
    @ToString.Exclude
    public String cipher;

    public String alg;
    public String mode;

    public String email;

    @ToString.Exclude
    public String password;

    public String accountId;

//    public String keyName;

    public String appId;

    @ToString.Exclude
    public String sessionId;
}
