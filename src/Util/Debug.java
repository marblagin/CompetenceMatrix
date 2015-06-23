/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Llewellyn Craddock
 */
public class Debug {
    public static void Log(String content)
    {
        System.out.println("[Debug]" + content);
    }
    public static void Log(int content)
    {
        System.out.println("[Debug]" + content);
    }
    public static void LogException(Exception e)
    {
        System.out.println("[Exception]" + e.getMessage());
        e.printStackTrace();
    }
}
