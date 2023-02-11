package uz.atm.utils;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;


/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/25/22 4:46 PM
 **/
@Slf4j
public class AppUtils {

    private static final ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);


    public static Integer randomInteger() {
        try {
            Random random = SecureRandom.getInstanceStrong();  // SecureRandom is preferred to Random
            return random.nextInt(99999);
        } catch ( NoSuchAlgorithmException e ) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static void threadSleep( int milliseconds ) {
        try {
            Thread.sleep(milliseconds);
        } catch ( InterruptedException e ) {
            log.error("Exception occured at sleeping sleep : {}", e.getMessage());
        }
    }

    public static Long getRequestResponseIdFromFile( String path ) {
        try ( RandomAccessFile file = new RandomAccessFile(path, "rw");
              FileChannel channel = file.getChannel();
              FileLock lock = channel.lock() ) {
            file.seek(0);
            long l = file.readLong();
            file.seek(0);
            file.write(longToBytes(l + 1));
            return l;
        } catch ( OverlappingFileLockException | IOException e ) {
            log.error("Exception occurred while generating requestId ; Cause : {}", e.getMessage());
            return new SecureRandom().nextLong(999999999999L, 999999999999999999L);
        }
    }

    public static boolean isJWT( String jwt ) {
        String[] jwtSplitted = jwt.split("\\.");
        if ( jwtSplitted.length != 3 ) // The JWT is composed of three parts
            return false;
        try {
            byte[] decodedStr = Base64.getDecoder().decode(jwtSplitted[0]);
            String jsonFirstPart = new String(decodedStr);
            JSONObject firstPart = new JSONObject(jsonFirstPart); // The first part of the JWT is a JSON
            if ( !firstPart.has("alg") ) // The first part has the attribute "alg"
                return false;
        } catch ( JSONException | IllegalArgumentException err ) {
            throw new RuntimeException(err.getMessage());
        }
        return true;
    }


    public static byte[] longToBytes( long x ) {
        buffer.putLong(0, x);
        return buffer.array();
    }

    public static long bytesToLong( byte[] bytes ) {
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();
        return buffer.getLong();
    }

}

