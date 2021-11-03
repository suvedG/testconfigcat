package com.test.configcat;

import com.configcat.ConfigCatClient;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigcatApplication{

	public static void main(String[] args) throws IOException{
		SpringApplication.run(ConfigcatApplication.class, args);
		
		Scanner scanner = new Scanner(System.in);
		boolean end = false;
		while(!end){
		System.out.println("Please Select Your Environment -- Type T for test or P for production E for Exit");
		String userinput = scanner.nextLine();
		if(userinput.equals("T")){
			System.out.println("You Selected test environment");
			//Initialize the sdk -- test key
			ConfigCatClient client =new ConfigCatClient("bJnZCNlFH0OIQ8hHYSBFnQ/fA_VBPWV6EW4UxriKcXOAQ");
			fetchValues(client);

		}else if(userinput.equals("P")){
			System.out.println("You Selected production environment");
			//Initialize the sdk -- production key
			ConfigCatClient client =new ConfigCatClient("bJnZCNlFH0OIQ8hHYSBFnQ/UgYJJj0RRkuBo2e9A-P5ug");
			fetchValues(client);
		}else if(userinput.equals("E")){
			System.out.println("Your Program Has Ended");
			end = true;
		}
		else{
			System.out.println("Wrong Input");
		}
	}
		scanner.close();
	}

	public static void fetchValues(ConfigCatClient client) throws IOException{
		//Fetch value from console
		boolean buttonvalue = client.getValue(Boolean.class, "buttonToggle", false);
		boolean defaultvalue = client.getValue(Boolean.class, "isMyFirstFeatureEnabled", false);
	
		//Print Fetched values
		System.out.println("buttonToggle: " + buttonvalue);
		System.out.println("isMyFirstFeatureEnabled: " + defaultvalue);
		client.close();
		
	}

}


