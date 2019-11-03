package befaster.solutions.SUM;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumSolutionTest {

    private final SumSolution sum = new SumSolution();

    @Test
    public void compute_sum() {
        assertThat(sum.compute(1, 3), equalTo(4));
    }

}

