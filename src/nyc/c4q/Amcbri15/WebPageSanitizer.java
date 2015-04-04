package nyc.c4q.Amcbri15;
import java.net.URL;
import java.util.Scanner;

/**
 * Anthony McBride
 * AccessCode 2.1
 * Web Page Sanitizer
 * (Used simplified HTTP API that was created for previous classwork)
 */
public class WebPageSanitizer
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(
                System.in);

        while(true)
        {
            System.out.println("Please enter a URL for the page you'd like to sanitize:");
            String userURL = in.next();
            // Gets unsanitized HTML from user's URL
            String unsanitizedHTML = getHTML(userURL);

            // Throws error message if URL is invalid
            if(unsanitizedHTML.equals("Invalid URL!"))
            {
                System.out.println("Invalid URL!");
                continue;
            }
            else
            {
                // Prints sanitized HTML
                System.out.println(sanitize(unsanitizedHTML));
                break;
            }
        }

    }

    public static String sanitize(String HTML)
    {
        Scanner originalHTML = new Scanner(HTML);
        originalHTML.useDelimiter("[<]");
        String sanitizedHTML = "";

        // Scans HTML using tag open cone as the delimiter

        while(originalHTML.hasNext())
        {
            String line = originalHTML.next();
            // Ignores all text between script and /script
            if(line.startsWith("script"))
            {
                while(! originalHTML.next().startsWith("/script"))
                {
                    sanitizedHTML += "";
                }
                continue;
            }
            // Adds open cone after the script is removed to continue with remaining HTML text
            sanitizedHTML += "<" + line;
        }

        return "\nHere is your sanitized HTML:\n\n" + sanitizedHTML;
    }

    public static String getHTML(String stringURL)
    {
        URL url = HTTP.stringToURL(
                stringURL);
        if(url == null)
        {
            return "Invalid URL!";
        }
        return HTTP.get(url);

    }


}
