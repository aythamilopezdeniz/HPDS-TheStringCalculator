public class Calculator {
    private String delimiter = ",|\n";

    public int calculate(String input) throws Exception {
        String[] numbers = input.split(delimiter);
        if (isEmpty(input))
            return 0;
        if (input.length() == 1)
            return stringToInt(input);
        else
            return getSum(numbers);
    }

    private int getSum(String[] numbers) throws Exception {
        findDangerousInput(numbers);
        return calculateSum(numbers);
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if(stringToInt(number) >= 1000)
                continue;
            sum += stringToInt(number);
        }
        return sum;
    }

    private void findDangerousInput(String[] numbers) throws Exception {
        for (String number: numbers) {
            if(stringToInt(number) < 0)
                throw new Exception("Negative number");
        }
    }

    private boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
