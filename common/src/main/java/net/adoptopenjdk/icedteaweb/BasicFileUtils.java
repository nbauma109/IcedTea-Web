package net.adoptopenjdk.icedteaweb;

import net.adoptopenjdk.icedteaweb.io.IOUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BasicFileUtils {

    /**
     * Method to save String as file in UTF-8 encoding.
     *
     * @param content which will be saved as it is saved in this String
     * @param f file to be saved. No warnings provided
     * @throws IOException if save fails
     */
    public static void saveFile(final String content, final File f) throws IOException {
        saveFile(content, f, UTF_8);
    }

    /**
     * Method to save String as file in specified encoding/.
     *
     * @param content  which will be saved as it is saved in this String
     * @param f        file to be saved. No warnings provided
     * @param encoding of output byte representation
     * @throws IOException if save fails
     */
    public static void saveFile(final String content, final File f, final Charset encoding) throws IOException {
        try (final Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), encoding))) {
            output.write(content);
            output.flush();
        }
    }

    /**
     * utility method which can read from any stream as one long String
     *
     * @param is stream
     * @return stream as string
     * @throws IOException if connection can't be established or resource does not exist
     */
    public static String toString(final InputStream is) throws IOException {
        return IOUtils.readContentAsUtf8String(is);
    }

    /**
     * utility method which can read from any stream as one long String
     *
     * @param is       stream
     * @param encoding the encoding to use to convert the bytes from the stream
     * @return stream as string
     * @throws IOException if connection can't be established or resource does not exist
     */
    public static String toString(final InputStream is, final Charset encoding) throws IOException {
        return IOUtils.readContentAsString(is, encoding);
    }
}
