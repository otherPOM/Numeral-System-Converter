# Numeral System Converter https://hyperskill.org/projects/41
## Stage 1
Implement a program that outputs a number in two systems: the first is decimal, and the second one is binary. This must be the same number represented in different systems; feel free to choose any number you like.

## Stage 2
Implement a program that calculates the last digit of the given number converted to base 8.

## Stage 3
Now let's implement a simple converter. It will convert the given decimal number to the given radix. You should support three radices with prefixes:

* binary (`0b`);
* octal (`0`);
* hexadecimal (`0x`).

To get a string with the answer, use the Long.toString(sourceNumber, destinationRadix) expression. Note that the expected output is a String, because Java implicitly converts 0/0b/0x concatenated numbers to their decimal representation.

