import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateIT.class, ReadIT.class, UpdateIT.class, DeleteIT.class})
public class AllTests {

    public static final String PERSISTENCE_UNIT_NAME = "ch.bfh.bti7515.phototraveler.domain";

}
