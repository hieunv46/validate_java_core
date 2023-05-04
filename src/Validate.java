import java.util.Scanner;

public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("----------Validate Menu----------\n\n" + "1. Validate Integer\n" + "2. Validate Option\n"
                    + "3. Validate Non Number\n" + "4. Validate String\n" + "5. Validate String Non Sapce\n"
                    + "6. Validate Double\n" + "7. Validate Email\n" + "8. Validate Gender\n");
            int option = validateOption("Enter option: ", 1, 7);
            String output = "";
            switch (option) {
                case 1:
                    output = String.valueOf(validateInteger("Enter integer: ", "Must be integer and bigger than 1", 1));
                    break;
                case 2:
                    int min = 0;
                    int max = 0;
                    while (true) {
                        min = validateInteger("Enter min: ", "Must be integer and bigger than 1", 1);
                        max = validateInteger("Enter max: ", "Must be integer and bigger than 1", 1);
                        if (max > min) {
                            output = String.valueOf(validateOption("Enter Option: ", min, max));
                            break;
                        } else {
                            System.out.println("Max must be bigger than min !. Input again !");
                        }
                    }

            }
            System.out.println("Result: " + output);
            System.out.println("Press any key to continue, n to exit !");
            String confirmString = sc.nextLine();
            if (confirmString.equals("n") || confirmString.equals("N")) {
                System.out.println("Bye !");
                return;
            }
        }
    }

    public static int validateInteger(String message, String err, int firstLimit) {
        int number = 0;
        boolean checkNumber = false;

        while (!checkNumber) {
            System.out.println(message);
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < firstLimit) {
                    System.out.println(err);
                } else {
                    checkNumber = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return number;
    }

    public static int validateOption(String message, int min, int max) {
        int option = 0;
        boolean checkOption = false;
        while (!checkOption) {
            System.out.println(message);
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option < min || option > max) {
                    System.out.println("Must be integer bigger than " + (min - 1) + " and less than " + (max + 1)
                            + " ! Input again !");
                } else {
                    checkOption = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return option;
    }

    public static String validateNonNumber(String message, String err) {
        String input = "";
        boolean checkNonNumber = false;
        String regex = "^([A-Za-z]+ )+[A-Za-z]+$|^[A-Za-z]+$";

        while (!checkNonNumber) {
            System.out.println(message);
            try {
                input = sc.nextLine();
                if (!input.matches(regex)) {
                    System.out.println(err);
                } else {
                    checkNonNumber = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return input;
    }

    public static String validateString(String message, String err) {
        String input = "";
        boolean checkString = false;
        String regex = "^([A-Za-z0-9]+ )+[A-Za-z0-9]+$|^[A-Za-z0-9]+$";
        while (!checkString) {
            System.out.println(message);
            try {
                input = sc.nextLine();
                if (!input.matches(regex)) {
                    System.out.println(err);
                } else {
                    checkString = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return input;
    }

    public static String validateStringNonSpace(String message, String err) {
        boolean checkString = false;
        String input = "";

        while (!checkString) {
            System.out.println(message);
            try {
                input = sc.nextLine();
                int inputLength = input.length();
                int nonSpaceInuputLength = input.replaceFirst(" ", "").length();

                if (inputLength == 0 || inputLength > nonSpaceInuputLength) {
                    System.out.println(err);
                } else {
                    checkString = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return input;
    }

    public static double validateDouble(String message, String err) {
        double number = 0;
        boolean checkDouble = false;

        while (!checkDouble) {
            System.out.println(message);
            try {
                number = Double.parseDouble(sc.nextLine());
                if (number <= 0) {
                    System.out.println(err);
                } else {
                    checkDouble = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return number;
    }

    public static String validateEmail(String message, String err) {
        String input = "";
        boolean checkEmail = false;
        String regex = "^([A-Za-z0-9]+ )+[A-Za-z0-9]+$|^[A-Za-z0-9]+$";

        while (!checkEmail) {
            System.out.println(message);
            try {
                input = sc.nextLine();
                if (!input.matches(regex)) {
                    System.out.println(err);
                } else {
                    checkEmail = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return input;
    }

    public static String validateGender(String message, String err) {
        String input = "";
        boolean checkString = false;

        while (!checkString) {
            System.out.println(message);
            try {
                input = sc.nextLine();
                if (!input.equalsIgnoreCase("male") && !input.equalsIgnoreCase("female")) {
                    System.out.println(err);
                } else {
                    checkString = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e + ". Input again !.");
            }
        }
        return input.toLowerCase();
    }
}