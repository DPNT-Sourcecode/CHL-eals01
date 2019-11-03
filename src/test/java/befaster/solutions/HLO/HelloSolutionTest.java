package befaster.solutions.HLO;

import org.junit.Test;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;


public class HelloSolutionTest {

    private final HelloSolution solution = new HelloSolution();

    @Test
    public void returnsHelloFollowedByName() {
        assertThat(solution.hello("Jarek"), sameBeanAs("Hello, Jarek!"));
    }

}
