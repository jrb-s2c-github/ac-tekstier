package za.co.s2c.ac.tekstier;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Builder
public class DecryptionResponseBean {
    public String plain;

    @ToString.Exclude
    public String sessionId;
}
