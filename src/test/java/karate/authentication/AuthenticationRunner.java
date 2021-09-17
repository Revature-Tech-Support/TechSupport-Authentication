package karate.authentication;

import com.intuit.karate.junit5.Karate;

public class AuthenticationRunner {

    @Karate.Test
    Karate runAll(){
        return Karate.run().relativeTo(getClass());
    }
}
