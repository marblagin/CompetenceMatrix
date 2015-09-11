
package Util;

/**
 *  This class was used to debug the program by printing any and all errors or exceptions
 * @author Llewellyn Craddock
 */
public class Debug {
    
    /**
     * This debug method prints out a log of a type string when called
     * @param content String values to be printed as debug log
     */
    public static void Log(String content)
    {
        System.out.println("[Debug]" + content);
    }
    /**
     * This debug method prints out a log of a type integer when called
     * @param content Integer values to be printed as debug log
     */
    public static void Log(int content)
    {
        System.out.println("[Debug]" + content);
    }
    /**
     * This debug method prints out a log of a type exception when called
     * @param e The exception given (various)
     */
    public static void LogException(Exception e)
    {
        System.out.println("[Exception]" + e.getMessage());
        e.printStackTrace();
    }
    
}
