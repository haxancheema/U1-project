
/*
* Author: Hasan Ahmed Cheema
* Id: ar4904
* Study program: Systenutvecklare TGSYA25
*/
import java.util.Scanner;

public class DA339A_U1 {
  static Scanner input = new Scanner(System.in); // can be removed if another solution is used that does not require
                                                 // this scanner-object
  static int passingGradeThreshold; // change as you need when testing

  // an array to use for testing, replace as needed to test your code
  static String[][] resultsList = { { "Adam Ason", "14", "U" },
      { "Berta Bson", "25", "G" },
      { "Ceasar Cson", "17", "U" },
      { "", "", "" },
      { "Diva Dson", "20", "G" },
      { "", "", "" },
      { "Evert Eson", "", "" },
      { "", "", "" },
      { "", "", "" },
      { "", "", "" },
      { "", "", ""},
  };

  /*
   * For testing at presentation do not erase this block
   * {{"Adam Ason", "14","U"},
   * {"Berta Bson", "25","G"},
   * {"Ceasar Cson", "17","U"},
   * {"","",""},
   * {"Diva Dson","20","G"},
   * {"","",""},
   * {"Evert Eson","",""},
   * {"","",""},
   * {"","",""},
   * {"","",""},
   * };
   */

  /*
   * Parameters for methods below may NOT be changed and HAVE TO BE USED as
   * intended for a passing grade.
   */

  /**
   * This method makes sure to print the information about the persons in the
   * result list
   * (name, score and grade) from the result list in the terminal for the user.
   * The print out shall show name, score (if set), grade (if set) and a number
   * representing the person's place in the result list.
   * Empty places in the result list will NOT be shown.
   */
  public static void printPersonsInformation() {
    System.out.println("You chose to print the information of the persons in the result list"); // you don't need to
                                                                                                // keep this line
    // Add your code here
    int points;
    for (int i = 0; i < resultsList.length; i++) {
      if (!resultsList[i][1].isEmpty()) {
        points = Integer.parseInt(resultsList[i][1]);
        if (points >= passingGradeThreshold) {
          resultsList[i][2] = "G";
        } else {
          resultsList[i][2] = "U";
        }
      }
    }

    for (int i = 0; i < resultsList.length; i++) {
      if (!resultsList[i][0].isEmpty() || !resultsList[i][1].isEmpty() || !resultsList[i][2].isEmpty()) {
        System.out.print(i + ". ");
        for (int j = 0; j < resultsList[i].length; j++) {
          if (!resultsList[i][j].isEmpty()) {
            System.out.print(resultsList[i][j] + " ");
          }
        }
        System.out.println();
      }
    }
  }

  /**
   * This method makes sure to print the whole result list in the terminal for the
   * user.
   * If a place in the result list contains data for a person the person's name,
   * score (if set) and grade (if set) is shown.
   * If a place in the result list is empty a text stating that the place in empty
   * is shown.
   * In both cases a number representing the place in the result list is shown.
   */
  public static void printResultList() {
    System.out.println("You chose to print the result list"); // you don't need to keep this line
    // Add your code here
    int points;
    for (int i = 0; i < resultsList.length; i++) {
      if (!resultsList[i][1].isEmpty()) {
        points = Integer.parseInt(resultsList[i][1]);
        if (points >= passingGradeThreshold) {
          resultsList[i][2] = "G";
        } else {
          resultsList[i][2] = "U";
        }
      }
    }

    for (int i = 0; i < resultsList.length; i++) {
      System.out.print(i + ". ");
      if (resultsList[i][0].isEmpty() && resultsList[i][1].isEmpty() && resultsList[i][2].isEmpty()) {
        System.out.print("Empty place");
      }
      for (int j = 0; j < resultsList[i].length; j++) {
        System.out.print(resultsList[i][j] + " ");
      }
      System.out.println();
    }

  }

  /**
   * This method makes sure to print statistics about the result list to the user.
   * The following statistics shall be shown:
   * - Total number of persons taking the test in the list regardless of whether a
   * score is set or not
   * - Total number of persons with a passing grade G
   * - Total number of persons that failed grade U
   * - The highest score and namne of the person with that score and the given
   * grade
   * - The lowest score and namne of the person with that score and the given
   * grade
   */
  public static void printStatistics() {
    int totalPersons = 0;
    int totalG = 0;
    int totalU = 0;
    int highestScore = -1;
    String highestScorer = "";
    String highestGrade = "";

    int lowestScore = -1;
    String lowestScorer = "";
    String lowestGrade = "";

    boolean foundScore = false;
    int points;

    for (int i = 0; i < resultsList.length; i++) {
      if (!resultsList[i][1].isEmpty()) {
        totalPersons++;
        points = Integer.parseInt(resultsList[i][1]);

        if (points >= passingGradeThreshold) {
          resultsList[i][2] = "G";
          totalG++;
        } else {
          resultsList[i][2] = "U";
          totalU++;
        }

        if (!foundScore) {
          highestScore = points;
          highestScorer = resultsList[i][0];
          highestGrade = resultsList[i][2];

          lowestScore = points;
          lowestScorer = resultsList[i][0];
          lowestGrade = resultsList[i][2];

          foundScore = true;
        } else {
          if (points > highestScore) {
            highestScore = points;
            highestScorer = resultsList[i][0];
            highestGrade = resultsList[i][2];
          }
          if (points < lowestScore) {
            lowestScore = points;
            lowestScorer = resultsList[i][0];
            lowestGrade = resultsList[i][2];
          }
        }
      }
    }

    System.out.println("--- Statistics ---");
    System.out.println("Total persons with a score set: " + totalPersons);
    System.out.println("Total with passing grade G: " + totalG);
    System.out.println("Total with failing grade U: " + totalU);

    if (!foundScore) {
      System.out.println("No scores available to determine highest or lowest score.");
    } else {
      System.out.println("Highest score: " + highestScore + " - " + highestScorer + " " + highestGrade);
      System.out.println("Lowest score: " + lowestScore + " - " + lowestScorer + " " + lowestGrade);
    }
  }

  /**
   * This method adds a person to the result list.
   * The information that is added to the result list is defined in the method
   * parameters.
   * If a user tries to add a person to a full result list an error messages
   * informing the user
   * about this will be shown and no person added to the list.
   * 
   * @param name  The name of the person to add
   * @param score The score of the person to add as an int, if this is a negative
   *              value no score is set.
   */
  public static void addPerson(String name, int score) {
    System.out.println("You chose to add a person"); // you don't need to keep this line
    // Add your code here
    for (int i = 0; i < resultsList.length; i++) {
      if (resultsList[i][0].isEmpty() && resultsList[i][1].isEmpty() && resultsList[i][2].isEmpty()) {

        resultsList[i][0] = name;
        if (score >= 0) {
          resultsList[i][1] = Integer.toString(score);
          if (score >= passingGradeThreshold) {
            resultsList[i][2] = "G";
          } else {
            resultsList[i][2] = "U";
          }
        } else {
          resultsList[i][1] = "";
          resultsList[i][2] = "";
        }
        System.out.println("You added " + name + " with score " + score + " at index " + i);
        return;
      }
    }

    System.out.println("List is already full");
  }

  /**
   * This method changes the name of a specific person in the result list.
   * Which persons's name is changed is decided by a method parameter.
   * If a user tries to change the name at a place in the list that has
   * no current person an error message informing the user about this
   * will be shown and no data in the result list is changed.
   * 
   * @param index   The index of the person whose name shall be changed.
   * @param newName The new name of the person at place given by index.
   */
  public static void changeNameOfPerson(int index, String newName) {
    System.out.println("You chose to change the name of a person"); // you don't need to keep this line
    // Add your code here
    if (index < 0 || index >= resultsList.length) {
      System.out.println("Error : Invalid index.");
      return;
    }

    // Check that a person exists at the index
    if (resultsList[index][0].isEmpty()) {
      System.out.println("Error: Chosen index does not have any person.");
      return;
    }

    // Perform the name change
    resultsList[index][0] = newName;
    System.out.println("New name of person at index " + index + " is " + newName);
  }

  /**
   * This method changes the score for a specific person in the result list.
   * Which person's score is changed is decided by a method parameter.
   * If a user tries to change the score at a place in the list that has
   * no current person an error message informing the user about this
   * will be shown and no data in the result list is changed.
   * 
   * @param index    The index of the person whose score shall be changed.
   * @param newScore The new score, as an int, of the person at place given by
   *                 index. If this is a negative value no score is set.
   */
  public static void changeScoreForPerson(int index, int newScore) {
    System.out.println("You chose to change the score of a person"); // you don't need to keep this line
    // Add your code here
    // Validate index
    if (index < 0 || index >= resultsList.length) {
      System.out.println("Error: Invalid index. Returning to menu.");
      return;
    }

    // Check that a person exists at the index
    if (resultsList[index][0].isEmpty()) {
      System.out.println("Error: Chosen index does not have any person.");
      return;
    }

    // Update or remove score
    if (newScore < 0) {
      // remove score
      resultsList[index][1] = "";
      resultsList[index][2] = "";
      System.out.println("Score removed for person at index " + index);
    } else {
      resultsList[index][1] = Integer.toString(newScore);
      resultsList[index][2] = (newScore >= passingGradeThreshold) ? "G" : "U";
      System.out.println("Score of the person at index " + index + " is changed to " + newScore);
    }
  }

  /**
   * This method removes a person at a given index from the result list.
   * The data at this index is replaced by empty Strings.
   * If no person exists at the given index an error message informing
   * the user about this will be shown and no data in the result list is changed.
   * 
   * @param index The index of the place where a person is to be removed.
   */
  public static void removePerson(int index) {
    System.out.println("You chose to remove a person"); // you don't need to keep this line
    // New behavior: if the index is invalid or the place is empty, print an error
    // and return
    if (index < 0 || index >= resultsList.length) {
      System.out.println("Error: Invalid index. Returning to menu.");
      return;
    }

    if (resultsList[index][0].isEmpty() && resultsList[index][1].isEmpty() && resultsList[index][2].isEmpty()) {
      System.out.println("Error: No person at that index. Returning to menu.");
      return;
    }

    // Remove the person at the given index
    for (int i = 0; i < resultsList[index].length; i++) {
      resultsList[index][i] = "";
    }
    System.out.println("You removed the person at index " + index);
  }

  /**
   * This method changes places in the result list for the data existing
   * at those places given by the parameters. It is possible to change
   * places between data even if one or both places contains empty strings.
   * This gives the user the possibility to change the place of one person
   * to an empty place in the result list.
   * If the two parameters have the same value an error message informing
   * the user about this will be shown and no data in the result list is changed.
   * 
   * @param index1 First index involved in the change of places
   * @param index2 Second index involved in the change of places
   */
  public static void changePlaces(int index1, int index2) {
    System.out.println("You chose to switch places between index " + index1 + " and " + index2); // you don't need to
                                                                                                 // keep this line
    // Add your code here
    if (index1 != index2 && index1 >= 0 && index1 < resultsList.length && index2 >= 0 && index2 < resultsList.length) {
      String[] temp = resultsList[index1];
      resultsList[index1] = resultsList[index2];
      resultsList[index2] = temp;

    } else {
      System.out.println("Invalid input. Either same index or out of bounds.");
    }
  }

  /**
   * This method prints the program menu in the terminal for the user to view.
   * This printout shall also inform the user about the threshold for a passing
   * grade
   * stored in variable passingGradeThreshold.
   */
  public static void printMenu() {
    System.out.println("The passing threshold is set to: " + passingGradeThreshold);
    System.out.println("-----Program menu-----"); // you don't need to keep this line
    // Add your code here
    System.out.println("What would you like to do?");
    System.out.println("1. Print out  a student's information.");
    System.out.println("2. Print out the result list");
    System.out.println("3. Print out statistics");
    System.out.println("4. Add a student in the list.");
    System.out.println("5. Change name of a student.");
    System.out.println("6. Change point/numbers of a student.");
    System.out.println("7. Swap or change position of a student.");
    System.out.println("8. Remove a student from list.");
    System.out.println("9. Close the program.");

  }

  /**
   * This method reads the menu choice from the user and returns the choice the
   * user made as an integer.
   * 
   * @return The menu choice made by the user represented by an integer value of
   *         type int.
   */
  public static int readMenuChoice() {
    // Prompt until the user enters a valid integer between 1 and 9.
    while (true) {
      System.out.println("Make menu choice between 1-9.");
      if (input.hasNextInt()) {
        int menuChoice = input.nextInt();
        if (menuChoice >= 1 && menuChoice <= 9) {
          return menuChoice;
        } else {
          System.out.println("Invalid menu choice. Try again.");
        }
      } else {
        input.next();
        System.out.println("Invalid input. Please enter a number between 1 and 9.");
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("You started the program"); // this line can be removed
    // Add you code here with the loop that handles the user's menu choices.
    // Do not forget to read the threshold of the passing grade as the program
    // starts
    // and store it in the variable passingGradeThreshold.
    // Read passing threshold (must be >= 1). Keep prompting until valid.
    System.out.println();
    passingGradeThreshold = 0;
    while (passingGradeThreshold < 1) {
      System.out.println("What is the passing threshold?(minimum 1)");
      if (input.hasNextInt()) {
        passingGradeThreshold = input.nextInt();
        if (passingGradeThreshold <= 0) {
          System.out.println("Wrong input. Please try again");
        }
      } else {

        System.out.println("Wrong input. Please enter a number.");
        input.next();
      }
    }
    System.out.println();
    while (true) {
      printMenu();
      int choice = readMenuChoice();

      if (choice == 9) {
        System.out.println("You chose to close the program.");
        break;
      }

      switch (choice) {
        case 1:

          printPersonsInformation();
          break;
        case 2:
          printResultList();
          break;
        case 3:
          printStatistics();
          break;
        case 4:
          System.out.println("Write name of a person who you want to add.");
          input.nextLine();
          String nameToAdd = input.nextLine();
          if (nameToAdd.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Returning to menu.");
            break;
          }
          System.out.println("Write score of a person who you want to add");
          if (input.hasNextInt()) {
            int scoreToAdd = input.nextInt();
            addPerson(nameToAdd, scoreToAdd);
          } else {
            System.out.println("Invalid input. Returning to menu.");
            input.next();
          }
          break;
        case 5:
          System.out.println("Write index of a person who you want to change name.");
          if (input.hasNextInt()) {
            int indexForName = input.nextInt();
            input.nextLine();
            System.out.println("Write new name of a person who you want to change.");
            String newName = input.nextLine().trim();
            if (!newName.isEmpty()) {
              changeNameOfPerson(indexForName, newName);
            } else {
              System.out.println("Name cannot be empty. Returning to menu.");
            }
          }

          else {
            System.out.println("Invalid input. Returning to menu.");
            input.next();
          }
          break;
        case 6:
          System.out.println("Write index of a person who you want to change score.");
          if (input.hasNextInt()) {
            int indexForScore = input.nextInt();
            System.out.println("Write new score of a person who you want to change.");
            if (input.hasNextInt()) {
              int newScore = input.nextInt();
              changeScoreForPerson(indexForScore, newScore);
            }
            else {
              System.out.println("Invalid input. Returning to menu.");
            }
          }
         else {
            System.out.println("Invalid input. Returning to menu.");
            input.next();
          }
          break;
        case 7:
          printResultList();
          System.out.println("Write index of a person who you want to change place.");
          if (input.hasNextInt()) {
            int index1 = input.nextInt();
            System.out.println("Write index of a person who you want to change place with.");
            if (input.hasNextInt()) {
              int index2 = input.nextInt();
              changePlaces(index1, index2);
            } else {
              System.out.println("Invalid input. Returning to menu.");
              input.next();
            }

          } else {
            System.out.println("Invalid input. Returning to menu.");
            input.next();
          }
          break;
        case 8:
          System.out.println("Write index of a person who you want to remove.");
          if (input.hasNextInt()) {
            int indexToRemove = input.nextInt();
            removePerson(indexToRemove);
          } else {
            System.out.println("No such index in Array. Returning to menu.");
            input.next();
          }
          break;
        default:

      }
    }
  }
}
