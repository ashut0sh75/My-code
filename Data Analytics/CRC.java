import java.util.zip.CRC32;

public class CRC {

    // Polynomial for CRC-12
    private static final int CRC12_POLYNOMIAL = 0x80F;
    // Polynomial for CRC-16
    private static final int CRC16_POLYNOMIAL = 0x8005;
    // Generate CRC-12 code for given data
    public static int generateCRC12(byte[] data) {
        int crc = 0xFFF; // Initialize with 0xFFF (initial CRC value)
        for (byte b : data) {
            crc ^= (b << 4) & 0xF00; // XOR with data byte
            for (int i = 0; i < 8; i++) {
                crc <<= 1; // Left shift CRC
                if ((crc & 0x1000) != 0) // Check if MSB is set
                    crc ^= CRC12_POLYNOMIAL; // XOR with CRC-12 polynomial
            }
        }
        return crc & 0xFFF; // Return only the 12 least significant bits
    }

    // Generate CRC-16 code for given data
    public static int generateCRC16(byte[] data) {
        int crc = 0xFFFF; // Initialize with 0xFFFF (initial CRC value)
        for (byte b : data) {
            crc ^= (b & 0xFF) << 8; // XOR with data byte
            for (int i = 0; i < 8; i++) {
                crc = (crc & 0x8000) != 0 ? (crc << 1) ^ CRC16_POLYNOMIAL : crc << 1; // Check if MSB is set
            }
        }
        return crc & 0xFFFF; // Return only the 16 least significant bits
    }

    // Generate CRC-CCITT code for given data
    public static int generateCRC_CCITT(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return (int) crc32.getValue(); // CRC-CCITT value from java.util.zip.CRC32
    }

    // Check if received data is valid using CRC-12 code
    public static boolean isValidCRC12(byte[] data, int receivedCRC) {
        int calculatedCRC = generateCRC12(data);
        return calculatedCRC == receivedCRC;
    }

    // Check if received data is valid using CRC-16 code
    public static boolean isValidCRC16(byte[] data, int receivedCRC) {
        int calculatedCRC = generateCRC16(data);
        return calculatedCRC == receivedCRC;
    }

    // Check if received data is valid using CRC-CCITT code
    public static boolean isValidCRC_CCITT(byte[] data, int receivedCRC) {
        int calculatedCRC = generateCRC_CCITT(data);
        return calculatedCRC == receivedCRC;
    }

    public static void main(String[] args) {
        // Example usage
        byte[] data = "Hello, world!".getBytes();
        int crc12 = generateCRC12(data);
        int crc16 = generateCRC16(data);
        int crcCCITT = generateCRC_CCITT(data);

        System.out.println("CRC-12: " + crc12);
        System.out.println("CRC-16: " + crc16);
        System.out.println("CRC-CCITT: " + crcCCITT);

        // Simulate transmission
        boolean isCRC12Valid = isValidCRC12(data, crc12);
        boolean isCRC16Valid = isValidCRC16(data, crc16);
        boolean isCRC_CCITTValid = isValidCRC_CCITT(data, crcCCITT);

        System.out.println("CRC-12 Validity: " + isCRC12Valid);
        System.out.println("CRC-16 Validity: " + isCRC16Valid);
        System.out.println("CRC-CCITT Validity: " + isCRC_CCITTValid);
    }
}
