package com.module2.homework.hw7;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class FileIterator implements Iterator<String> {
    BufferedReader bufferedReader;

    public FileIterator(String filePath) throws IOException {
        File file = new File(filePath);

        if(!file.exists()){
            return;
        }

        Charset charset = StandardCharsets.US_ASCII;
        try{
            bufferedReader = Files.newBufferedReader(file.toPath(), charset);
        }catch (IOException ioException){
            throw new IOException(ioException.getMessage());
        }
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        try {
            if (bufferedReader == null) {
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public String next() {
        String result = "";

        try {
            result = bufferedReader.readLine();
            if (result == null){
                throw new NoSuchElementException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
