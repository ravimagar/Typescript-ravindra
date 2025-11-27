/**
 * Question 11: String Compression
 * Problem: Compress a string by replacing consecutive chars with char + count
 * 
 * Example:
 * Input: "aabbcccc"
 * Output: "a2b2c4"
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCompression {
    
    public static String compressString(String str) {
        if (str.length() <= 1) return str;
        
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
    
    // Using regex
    public static String compressStringRegex(String str) {
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(str);
        StringBuilder compressed = new StringBuilder();
        
        while (matcher.find()) {
            String match = matcher.group();
            compressed.append(match.charAt(0)).append(match.length());
        }
        
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
    
    // Decompress string
    public static String decompressString(String str) {
        StringBuilder decompressed = new StringBuilder();
        int i = 0;
        
        while (i < str.length()) {
            char character = str.charAt(i);
            StringBuilder numStr = new StringBuilder();
            i++;
            
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                numStr.append(str.charAt(i));
                i++;
            }
            
            int count = Integer.parseInt(numStr.toString());
            for (int j = 0; j < count; j++) {
                decompressed.append(character);
            }
        }
        
        return decompressed.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(compressString("aabbcccc")); // "a2b2c4"
        System.out.println(compressString("abcdef")); // "abcdef" (no benefit)
        System.out.println(compressString("aaaa")); // "a4"
        System.out.println(compressStringRegex("aabbcccc")); // "a2b2c4"
        
        System.out.println(decompressString("a2b2c4")); // "aabbcccc"
        System.out.println(decompressString("a4b1c2")); // "aaabc"
    }
}
