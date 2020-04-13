
public class sequential {

    int sum() {
        int sum = 0;
        for (int i = 0; i < 1000; ++i) {
            sum += 1;
        }
        System.out.println("Summation :" + sum);
        return sum;
    }
}
