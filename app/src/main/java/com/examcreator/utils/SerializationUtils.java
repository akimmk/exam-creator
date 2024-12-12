package com.examcreator.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtils {

  public static void save(Object object, String filePath) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
      oos.writeObject(object);
    }
  }

  public static <T> T load(String filePath, Class<T> type) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
      return type.cast(ois.readObject());
    }
  }
}
