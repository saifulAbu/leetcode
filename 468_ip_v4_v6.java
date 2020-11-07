package com.company;

public class ValidIpAddress {
  public String validIPAddress(String IP) {
    if(validaIPv4(IP)) {
      return "IPv4";
    } else if(validaIPv8(IP)) {
      return "IPv8";
    }
    return "Neither";
  }

  boolean validaIPv4(String ip) {
    String sectionPattern = "([0-9]|[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])";
    String ipv4Pattern = "(" + sectionPattern + "[.]){3}" + sectionPattern;
    return ip.matches(ipv4Pattern);
  }

  boolean validaIPv8(String ip) {
    String sectionPattern = "([0-9a-fA-F][0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?)";
    String ipv8Pattern = "(" + sectionPattern + "[.]){7}" + sectionPattern;
    return ip.matches(ipv8Pattern);
  }

  public static void main(String args []) {
    ValidIpAddress validAddress = new ValidIpAddress();
    String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
    String sectionPattern = "([0-9a-fA-F][0-9a-fA-F]?[0-9a-fA-F]?[0-9a-fA-F]?)";
    String ipv4Pattern = "(" + sectionPattern + "[:]){7}" + sectionPattern;
    System.out.println(ip.matches(ipv4Pattern));
  }
}
