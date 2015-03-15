package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    throw new UnsupportedOperationException("The student has not implemented this method yet.");
    //System.out.println("\n-Original string:");
    //System.out.println("\"" + lines + "\"");
    /*String[] split = new String[2];
    if (!lines.contains("\\r") && !lines.contains("\\n") && !lines.contains("\\r\\n")) {
        split = {"", lines};
    } else {
        split = lines.split("(?<=\\r\\n|[\\r\\n])", 2);
    }
    /*System.out.println("\n-Split string:");
    for (String s : split) System.out.print("\"" + s + "\",");
    System.out.println("\n----------");*/
    //return split;
  }

}
