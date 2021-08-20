package com.gaji.mini.post.model.io;

import java.io.*;
import java.util.*;

import com.gaji.mini.post.model.vo.Post;

public class PostIO {
	private final String dir = "database/";
	private String fileName = "Post.dat";
	private Map<Integer, Post> posts;

	public void readFile() {
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(dir + fileName)))) {

			posts = (HashMap<Integer, Post>) ois.readObject();
			Set<Integer> keySet = posts.keySet();
			posts.putAll(posts);

			for (Integer key : keySet) { // key == postNo
				posts.put(key, posts.get(key));
				System.out.println(posts.get(key));
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeFile() {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dir + fileName)))) {

			oos.writeObject(posts);
			System.out.println(posts);
			System.out.println("File saved: database/Members.dat");

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
