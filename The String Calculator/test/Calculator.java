public class Calculator {
    private String delimiter = "[,|\n]";

    public double calculate(String input) throws Exception {
        String[] numbers = input.split(delimiter);
        if (isEmpty(input))
            return 0;
        if (input.length() == 1)
            return stringToDouble(input);
        else
            return getSum(numbers);
    }

    private double getSum(String[] numbers) throws Exception {
        findDangerousInput(numbers);
        return sum(numbers);
    }

    private double sum(String[] numbers) {
        double sum = 0;
        for (String number : numbers) {
            if (stringToDouble(number) >= 1000)
                continue;
            sum += stringToDouble(number);
        }
        return sum;
    }

    private void findDangerousInput(String[] numbers) throws Exception {
        for (String number : numbers) {
            if (stringToDouble(number) < 0)
                throw new Exception("Negative number");
        }
    }

    private boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public double calculateSubtract(String number) {
        String[] numbers = number.split(delimiter);
        if (isEmpty(number))
            return 0;
        return subtract(numbers);
    }

    private double subtract(String[] numbers) {
        double subtract = stringToDouble(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            subtract -= stringToDouble(numbers[i]);
        }
        return roundNumber(subtract);
    }

    public double calculateDivision(String number) {
        String[] numbers = number.split(delimiter);
        if (isEmpty(number))
            return 0;
        return division(numbers);
    }

    private double division(String[] numbers) {
        return (roundNumber(stringToDouble(numbers[0]) / stringToDouble(numbers[1])));
    }

    private double stringToDouble(String number) {
        return Double.parseDouble(number);
    }

    private double roundNumber(Double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public double calculateMultiplication(String number) {
        String[] numbers = number.split(delimiter);
        if (isEmpty(number))
            return 0;
        return multiplication(numbers);
    }

    private double multiplication(String[] numbers) {
        return (roundNumber(stringToDouble(numbers[0]) * stringToDouble(numbers[1])));
    }

    public double calculatePower(String number) {
        String[] numbers = number.split(delimiter);
        if (isEmpty(number))
            return 0;
        if (numbers[1].equals(0))
            return 1;
        return power(numbers);
    }

    private double power(String[] numbers) {
        return roundNumber(Math.pow(stringToDouble(numbers[0]), stringToDouble(numbers[1])));
    }
}