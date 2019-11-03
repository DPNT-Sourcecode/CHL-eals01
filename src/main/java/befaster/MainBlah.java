package befaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBlah {

    public static void main(String[] args) throws IOException {

        System.out.println("creating buffered reader");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("reader created");
        String line = buffer.readLine();
        System.out.println("line is: '" + line + "'");
    }
}
