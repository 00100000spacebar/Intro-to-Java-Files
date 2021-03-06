//
// UserInfo.java           Author: Aidan Din
//
// Encrypt methods and set and get methods.
//

public class UserInfo {
    private String name, address, username, password;

    public UserInfo() {
        name = "";
        address = "";
        username = "";
        password = "";
    }
    public String toString() {
      return name + " " + address + " " + username + " " + password;
    }
    //get and set methods
    public void setName(String n) {
      name = n;
    }
    public void setAddress(String a) {
      address = a;
    }
    public void setUsername(String u) {
      username = u;
    }
    public void setPassword(String p) {
      password = encrypt(p);
    }
    public String getName() {
      return name;
    }
    public String getAddress() {
      return address;
    }
    public String getUsername() {
      return username;
    }
    public String getPassword() {
      return password;
    }
    //encrypt methods
    public String encrypt(String s) {
        //runs all encrypt methods
        s = removeWhitespaceAndConvertToUpper(
        substitute(
        swapHalfsForEncrypt(
        swapFirst2WithLast2(
        swapMiddleChars(s)))));
        
        return s;
    }
    public String removeWhitespaceAndConvertToUpper(String s) {
        //removes trailing and leading whitespace
        s = s.trim()
        .toUpperCase();
        
        return s;
    }
    public String substitute(String s) {
        //replaces all necessary characters in the passcode
        s.replace("A", "@")
        .replace("E", "=")
        .replace("I", "!")
        .replace("J", "?")
        .replace("O", "*")
        .replace("P", "#")
        .replace("R", "&")
        .replace("S", "$")
        .replace("T", "+")
        .replace("V", "^")
        .replace("X", "%")
        .replace(" ", "_");
        
        return s;
    }
    public String swapHalfsForEncrypt(String s) {
        //splits a string into 2 pieces and returns the halves swapped
        String firstHalf, secondHalf;
        
        firstHalf = s.substring(0, (s.length() + 1) / 2);
        secondHalf = s.substring((s.length() + 1) / 2, s.length());
        
        return secondHalf + firstHalf;
    }
    public String swapFirst2WithLast2(String s) {
        //splits s string into 3 pieces and swaps the first and third pieces
        String body = s.substring(2,  s.length() - 2);
        String first2 = s.substring(0, 2);
        String last2 = s.substring(s.length() - 2, s.length());
        
        return last2 + body + first2;
    }
    public String swapMiddleChars(String s) {
        //splits a string into 4 pieces and swaps the second and third pieces
        String body1, body2, middle1, middle2;
        
            //checks for odd/even string lengths
            body1 = s.substring(0, ((s.length() + 1) / 2) - 2);
            middle1 = s.substring(((s.length() + 1) / 2) - 2, s.length() / 2);
            middle2 = s.substring((s. length() + 1) / 2, (s.length() / 2) + 2);
            body2 = s.substring(((s.length() + 1) / 2) + 2, s.length());
        
        return body1 + middle2 + middle1 + body2;
    }
}
