
package Util;

/**
 *
 * @author Llewellyn Craddock
 */
public class Debug {
    
    //This class was used to debug the program by printing any and all errors or exceptions
    
    /**
     *
     * @param content
     */
    public static void Log(String content)
    {
        System.out.println("[Debug]" + content);
    }
    /**
     *
     * @param content
     */
    public static void Log(int content)
    {
        System.out.println("[Debug]" + content);
    }
    /**
     *
     * @param e 
     */
    public static void LogException(Exception e)
    {
        System.out.println("[Exception]" + e.getMessage());
        e.printStackTrace();
    }
}
