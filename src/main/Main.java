package main;

import file.FileIO;
import gui_title.Title;

public class Main {

	public static void main(String[] args) {
		FileIO file = FileIO.getFileObject();
		file.load();
		new Title();

	}

}
