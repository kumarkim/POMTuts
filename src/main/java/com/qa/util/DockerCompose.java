 package com.qa.util;

import java.io.File;
import java.io.IOException;

public class DockerCompose {

	public static void main(String args[]) throws IOException, InterruptedException {
		startDocker();
		stoptDocker();
	}
	public DockerCompose() {

	}
	
	/*
	 * cmd /c start : starts the commnand prompt
	 * 
	 */
	public static void startDocker() throws IOException, InterruptedException {
		String loc = "./docker/start_docker.bat";
		String location =new File(loc).getCanonicalPath();
		Runtime.getRuntime().exec("cmd /c start "+location);
		Thread.sleep(20000);   
		System.out.println("Docker compose UP complete");
	}
	
	/*
	 * taskkill : killing a task
	 * "/f": force kill
	 * "/im": image to kill
	 * "cmd.exe" : name of the image to kill
	 */
	public static void stoptDocker() throws IOException, InterruptedException {
		String loc = "./docker/stop_docker.bat";
		String location =new File(loc).getCanonicalPath();
		Runtime.getRuntime().exec("cmd /c start "+location);
		Thread.sleep(15000);
		System.out.println("Docker compose down complete");
	//	Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	}

}
