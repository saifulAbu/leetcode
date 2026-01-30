package array_and_string;

public class DefangingIpAddress_1108 {
  public String defangIPaddr(String address) {
    return address.replaceAll("\\.", "[.]");
  }
}
