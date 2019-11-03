public class RomanNumber {


    public String intToRoman(int number) {

        char roman[] = new char[1000];
        int index = 0;

        if (number < 0) {
            System.out.println("Invalid number");
            return null;
        }

        while (number != 0) {
            if (number >= 1000) {
                index = digit('M', index, number / 1000, roman);
                number = number % 1000;
            } else if (number >= 500) {
                if (number < 900) {
                    index = digit('D', index, number / 500, roman);
                    number = number % 500;
                } else {
                    index = subdigit('C', 'M', index, roman);
                    number = number % 100;
                }
            } else if (number >= 100) {
                if (number < 400) {
                    index = digit('C', index, number / 100, roman);
                    number = number % 100;
                } else {
                    index = subdigit('C', 'M', index, roman);
                    number = number % 100;
                }
            } else if (number >= 50) {
                if (number < 90) {
                    index = digit('L', index, number / 50, roman);
                    number = number % 50;
                } else {
                    index = subdigit('X', 'C', index, roman);
                    number = number % 10;
                }
            } else if (number >= 10) {
                if (number < 40) {
                    index = digit('X', index, number / 10, roman);
                    number = number % 10;
                } else {
                    index = subdigit('X', 'L', index, roman);
                    number = number % 10;
                }
            } else if (number >= 5) {
                if (number < 9) {
                    index = digit('V', index, number / 5, roman);
                    number = number % 5;
                } else {
                    index = subdigit('I', 'X', index, roman);
                    number = 0;
                }
            } else if (number >= 1) {
                if (number < 4) {
                    index = digit('I', index, number, roman);
                    number = 0;
                } else {
                    index = subdigit('I', 'V', index, roman);
                    number = 0;
                }
            }

        }
        return new String(roman);


    }

    int subdigit(char num1, char num2, int index, char roman[]) {
        roman[index++] = num1;
        roman[index++] = num2;
        return index++;
    }

    int digit(char num1, int index, int numberOfTimes, char roman[]) {
        for (int i = 0; i < numberOfTimes; i++) {
            roman[index++] = num1;
        }

        return index++;

    }


    int value(char r) {
        if (r == 'I') {
            return 1;
        }
        if (r == 'V') {
            return 5;
        }
        if (r == 'X') {
            return 10;
        }
        if (r == 'L') {
            return 50;
        }
        if (r == 'C') {
            return 100;
        }
        if (r == 'D') {
            return 500;
        }
        if (r == 'M') {
            return 1000;
        }
        return -1;
    }

    int romanToDecimal(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int currentRomanValue = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int nextRomanValue = value(str.charAt(i + 1));

                if (currentRomanValue >= nextRomanValue) {
                    result = result + currentRomanValue;
                } else {
                    result = result + nextRomanValue - currentRomanValue;
                    i++;
                }
            } else {
                result = result + currentRomanValue;
            }

        }
        return result;
    }

    public static void main (String args[])
    {
        RomanNumber number = new RomanNumber();
        System.out.println(number.romanToDecimal("MDCCCIV"));
    }
}