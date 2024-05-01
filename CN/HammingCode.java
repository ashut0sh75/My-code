public class HammingCode {
    public static void main(String[] args) {
        String data = "1011"; // Input binary string
        String encodedData = generateHammingCode(data);
        System.out.println("Encoded Data: " + encodedData);

        // Simulate an error
        String erroneousData = encodedData.substring(0, 4) + '1' + encodedData.substring(5);
        System.out.println("Erroneous Data: " + erroneousData);

        // Error detection and correction
        String correctedData = correctError(erroneousData);
        System.out.println("Corrected Data: " + correctedData);
    }

    private static String generateHammingCode(String data) {
        int[] encodedData = new int[12];

        // Position of redundant bits
        encodedData[0] = encodedData[1] = encodedData[3] = encodedData[7] = -1;

        // Placing data bits
        int j = 2;
        for (int i = 0; i < data.length(); i++) {
            if (j == 3 || j == 5 || j == 6 || j == 7 || j == 9 || j == 10 || j == 11) {
                j++;
            }
            encodedData[j] = data.charAt(i) - '0';
            j++;
        }

        // Calculating parity bits
        for (int i = 0; i < 12; i++) {
            if (encodedData[i] != -1) {
                continue;
            }
            int xor = 0;
            for (int k = i + 1; k < 12; k++) {
                if (isSet(k, i)) {
                    xor ^= encodedData[k];
                }
            }
            encodedData[i] = xor;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : encodedData) {
            sb.append(i);
        }

        return sb.toString();
    }

    private static boolean isSet(int k, int i) {
        // Converting both k and i to binary string, and then checking if the ith bit of k is set
        String kBinary = Integer.toBinaryString(k + 1);
        String iBinary = Integer.toBinaryString(i + 1);
        int iPositionFromRight = iBinary.length();
        int kPositionFromRight = kBinary.length() - iPositionFromRight;
        return kPositionFromRight >= 0 && kBinary.charAt(kPositionFromRight) == '1';
    }

    private static String correctError(String erroneousData) {
        int[] data = new int[erroneousData.length()];
        for (int i = 0; i < erroneousData.length(); i++) {
            data[i] = erroneousData.charAt(i) - '0';
        }

        // Calculate parity bits again
        for (int i = 0; i < 12; i++) {
            if (data[i] != 1 && data[i] != 0) {
                continue;
            }
            int xor = 0;
            for (int k = i + 1; k < 12; k++) {
                if (isSet(k, i)) {
                    xor ^= data[k];
                }
            }
            // If parity doesn't match, flip the bit
            if (xor != data[i]) {
                data[i] = xor;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : data) {
            sb.append(i);
        }

        return sb.toString();
    }
}