package befaster.solutions.HLO;

import org.junit.Test;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;


public class HelloSolutionTest {

    private final HelloSolution solution = new HelloSolution();

    @Test
    public void returnsHelloWorld() {
        assertThat(solution.hello("whatever"), sameBeanAs("Hello, World!"));
    }

}


