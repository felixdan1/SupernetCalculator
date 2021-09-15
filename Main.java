package com.company;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class Main
{
    static String[] convertIPToBinArray(String ipAddress){ //Converts the given IP address into a string array containing binary numbers.
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++){

            result = Long.parseLong(ipAddressInArray[i]);
            ipAddressInArray[i] = Long.toBinaryString(result);
        }

        return ipAddressInArray;
    }

    public static String toSubnet(int val) {
        switch (val) {
            case 0:
                return ("0.0.0.0");
            case 1:
                return ("128.0.0");
            case 2:
                return ("192.0.0.0");
            case 3:
                return ("224.0.0.0");
            case 4:
                return ("240.0.0.0");
            case 5:
                return ("248.0.0.0");
            case 6:
                return ("252.0.0.0");
            case 7:
                return ("254.0.0.0");
            case 8:
                return ("255.0.0.0");
            case 9:
                return ("255.128.0.0");
            case 10:
                return ("255.192.0.0");
            case 11:
                return ("255.224.0.0");
            case 12:
                return ("255.240.0.0");
            case 13:
                return ("255.248.0.0");
            case 14:
                return ("255.252.0.0");
            case 15:
                return ("255.254.0.0");
            case 16:
                return ("255.255.0.0");
            case 17:
                return ("255.255.128.0");
            case 18:
                return ("255.255.192.0");
            case 19:
                return ("255.255.224.0");
            case 20:
                return ("255.255.240.0");
            case 21:
                return ("255.255.248.0");
            case 22:
                return ("255.255.252.0");
            case 23:
                return ("255.255.254.0");
            case 24:
                return ("255.255.255.0");
            case 25:
                return ("255.255.255.128");
            case 26:
                return ("255.255.255.192");
            case 27:
                return ("255.255.255.224");
            case 28:
                return ("255.255.255.240");
            case 29:
                return ("255.255.255.248");
            case 30:
                return ("255.255.255.252");
            case 31:
                return ("255.255.255.254");
            case 32:
                return ("255.255.255.255");
            default:
                return ("0.0.0.0");
        }
    }

    public static String toWildCard(int val){
        switch (val){
            case 0: return ("255.255.255.255");
            case 1: return ("127.255.255.255");
            case 2: return ("63.255.255.255");
            case 3: return ("31.255.255.255");
            case 4: return ("15.255.255.255");
            case 5: return ("7.255.255.255");
            case 6: return ("3.255.255.255");
            case 7: return ("1.255.255.255");
            case 8: return ("0.255.255.255");
            case 9: return ("0.127.255.255");
            case 10: return ("0.63.255.255");
            case 11: return ("0.31.255.255");
            case 12: return ("0.15.255.255");
            case 13: return ("0.7.255.255");
            case 14: return ("0.3.255.255");
            case 15: return ("0.1.255.255");
            case 16: return ("0.0.255.255");
            case 17: return ("0.0.127.255");
            case 18: return ("0.0.63.255");
            case 19: return ("0.0.31.255");
            case 20: return ("0.0.15.255");
            case 21: return ("0.0.7.255");
            case 22: return ("0.0.3.255");
            case 23: return ("0.0.1.255");
            case 24: return ("0.0.0.255");
            case 25: return ("0.0.0.127");
            case 26: return ("0.0.0.63");
            case 27: return ("0.0.0.31");
            case 28: return ("0.0.0.15");
            case 29: return ("0.0.0.7");
            case 30: return ("0.0.0.3");
            case 31: return ("0.0.0.1");
            case 32: return ("0.0.0.0");
            default: return ("0.0.0.0");
        }
    }

    public static void main(String[] args) {
        int exitProgram = 0;
        while (exitProgram == 0){

            JOptionPane.showMessageDialog(null, "Hello, welcome to my Route Summarization Calculator.");
            String firstIP = JOptionPane.showInputDialog("Please enter the first address: e.g 172.16.0.1 ");
            String secondIP = JOptionPane.showInputDialog("Please enter the second IP Address e.g 172.16.0.7");

            String[] ipBinArrayOne = convertIPToBinArray(firstIP);
            String[] ipBinArrayTwo = convertIPToBinArray(secondIP);

            for (int i = 0; i < ipBinArrayOne.length; i++) { //Correctly formats ipBinArrayOne to contain leading zeros.
                if (ipBinArrayOne[i].length() == 1) {
                    ipBinArrayOne[i] = "0" + "0" + "0" + "0" + "0" + "0" + "0" + ipBinArrayOne[i];
                } else if (ipBinArrayOne[i].length() == 2) {
                    ipBinArrayOne[i] = "0" + "0" + "0" + "0" + "0" + "0" + ipBinArrayOne[i];
                } else if (ipBinArrayOne[i].length() == 3) {
                    ipBinArrayOne[i] = "0" + "0" + "0" + "0" + "0" + ipBinArrayOne[i];
                } else if (ipBinArrayOne[i].length() == 4) {
                    ipBinArrayOne[i] = "0" + "0" + "0" + "0" + ipBinArrayOne[i];
                } else if (ipBinArrayOne[i].length() == 5) {
                    ipBinArrayOne[i] = "0" + "0" + "0" + ipBinArrayOne[i];
                } else if (ipBinArrayOne[i].length() == 6) {
                    ipBinArrayOne[i] = "0" + "0" + ipBinArrayOne[i];
                } else if (ipBinArrayOne[i].length() == 7) {
                    ipBinArrayOne[i] = "0" + ipBinArrayOne[i];
                }
            }

            for (int i = 0; i < ipBinArrayTwo.length; i++) { //Correctly formats ipBinArrayTwo to contain leading zeros.
                if (ipBinArrayTwo[i].length() == 1) {
                    ipBinArrayTwo[i] = "0" + "0" + "0" + "0" + "0" + "0" + "0" + ipBinArrayTwo[i];
                } else if (ipBinArrayTwo[i].length() == 2) {
                    ipBinArrayTwo[i] = "0" + "0" + "0" + "0" + "0" + "0" + ipBinArrayTwo[i];
                } else if (ipBinArrayTwo[i].length() == 3) {
                    ipBinArrayTwo[i] = "0" + "0" + "0" + "0" + "0" + ipBinArrayTwo[i];
                } else if (ipBinArrayTwo[i].length() == 4) {
                    ipBinArrayTwo[i] = "0" + "0" + "0" + "0" + ipBinArrayTwo[i];
                } else if (ipBinArrayTwo[i].length() == 5) {
                    ipBinArrayTwo[i] = "0" + "0" + "0" + ipBinArrayTwo[i];
                } else if (ipBinArrayTwo[i].length() == 6) {
                    ipBinArrayTwo[i] = "0" + "0" + ipBinArrayTwo[i];
                } else if (ipBinArrayTwo[i].length() == 7) {
                    ipBinArrayTwo[i] = "0" + ipBinArrayTwo[i];
                }
            }

            String fullBinOne = ipBinArrayOne[0] + ipBinArrayOne[1] + ipBinArrayOne[2] + ipBinArrayOne[3];
            String fullBinTwo = ipBinArrayTwo[0] + ipBinArrayTwo[1] + ipBinArrayTwo[2] + ipBinArrayTwo[3];

            char[] charBinOne = fullBinOne.toCharArray();
            char[] charBinTwo = fullBinTwo.toCharArray();
            char[] routeSummaryArray = fullBinOne.toCharArray();

            int subnetCIDR = 0;

            for (int i = 0; i < charBinOne.length; i++) {
                if (charBinOne[i] != charBinTwo[i]) {
                    subnetCIDR = i;
                    break;
                }
            }

            for (int i = subnetCIDR; i < charBinOne.length; i++) {
                routeSummaryArray[i] = '0';
            }

            char[] byteOne = {routeSummaryArray[0], routeSummaryArray[1], routeSummaryArray[2], routeSummaryArray[3], routeSummaryArray[4], routeSummaryArray[5], routeSummaryArray[6], routeSummaryArray[7]};
            char[] byteTwo = {routeSummaryArray[8], routeSummaryArray[9], routeSummaryArray[10], routeSummaryArray[11], routeSummaryArray[12], routeSummaryArray[13], routeSummaryArray[14], routeSummaryArray[15]};
            char[] byteThree = {routeSummaryArray[16], routeSummaryArray[17], routeSummaryArray[18], routeSummaryArray[19], routeSummaryArray[20], routeSummaryArray[21], routeSummaryArray[22], routeSummaryArray[23]};
            char[] byteFour = {routeSummaryArray[24], routeSummaryArray[25], routeSummaryArray[26], routeSummaryArray[27], routeSummaryArray[28], routeSummaryArray[29], routeSummaryArray[30], routeSummaryArray[31]};

            String fullRouteSum = String.valueOf(routeSummaryArray);
            String strByteOne = String.valueOf(byteOne);
            String strByteTwo = String.valueOf(byteTwo);
            String strByteThree = String.valueOf(byteThree);
            String strByteFour = String.valueOf(byteFour);

            int intByteOne = Integer.parseInt(strByteOne, 2);
            int intByteTwo = Integer.parseInt(strByteTwo, 2);
            int intByteThree = Integer.parseInt(strByteThree, 2);
            int intByteFour = Integer.parseInt(strByteFour, 2);

            String finalRouteSum = "" + intByteOne + '.' + intByteTwo + '.' + intByteThree + '.' + intByteFour;
            String finalCIDR = "/" + subnetCIDR;
            String finalMask = toSubnet(subnetCIDR);
            String finalWildCard = toWildCard(subnetCIDR);

            JOptionPane.showMessageDialog(null, "Route Summarization: " + finalRouteSum + finalCIDR + "\nSubnet Mask: " + finalMask + "\nWildcard Mask: " + finalWildCard + "\n\nThis has been copied to your clipboard.");
            String copyClipboard = "Route Summarization: " + finalRouteSum + finalCIDR + "\nSubnet Mask: " + finalMask + "\nWildcard Mask: " + finalWildCard;
            StringSelection stringSelection = new StringSelection(copyClipboard);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            int reply = JOptionPane.showConfirmDialog(null, "Would you like to input another IP range?", "Start again?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                continue;
            } else {
                exitProgram = 1;
            }
            System.out.println();
        }
    }
}
