package dmacc;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Home;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.HomeRepository;

@SpringBootApplication
public class SpringHomesApplication implements CommandLineRunner {

	static Scanner in = new Scanner(System.in);
	static ApplicationContext appCtx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringHomesApplication.class, args);
		
	}
	
	@Autowired
	HomeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		boolean showMenu = true;
		System.out.println("--- Spring Homes List ---");
		
		while (showMenu) {
			System.out.println();
			System.out.println("********************************");
			System.out.println("*  1 -- Add a new home         *");
//			System.out.println("*  2 -- Edit an existing home  *");
			System.out.println("*  2 -- Delete a home          *");
			System.out.println("*  3 -- View list of all homes *");
			System.out.println("*  4 -- EXIT                   *");
			System.out.println("********************************");
			System.out.print("*  Select an option (1-5): ");
			int selection = in.nextInt();
			in.nextLine();
			System.out.println();

			if (selection == 1) {
				addAHome();
//			} else if (selection == 2) {
//				editAHome();
			} else if (selection == 2) {
				deleteAHome();
			} else if (selection == 3) {
				viewTheList();
			} else {
				((AbstractApplicationContext) appCtx).close();
				System.out.println();
				System.out.println("--- Goodbye! ---");
				showMenu = false;
			}
		}
	}
	
	private void viewTheList() {
		List<Home> allHomes = repo.findAll();
		
		for(Home home : allHomes) {
			System.out.println(home.toString());
		}
	}

	private void addAHome() {
		Home home = appCtx.getBean("home", Home.class);
		
		System.out.print("Enter type (e.g. Single-Family, Apartment, Townhome, etc.): ");
		home.setType(in.nextLine());
		System.out.print("Enter size of home in sq ft: ");
		home.setHouseSqFt(in.nextInt());
		System.out.print("Enter # of bedrooms: ");
		home.setBeds(in.nextInt());
		System.out.print("Enter # of bathrooms: ");
		home.setBaths(in.nextDouble());
		System.out.print("Enter year home was built: ");
		home.setYearBuilt(in.next());
		
		repo.save(home);
	}

	private void deleteAHome() {
		System.out.print("Enter id of home to delete ('-1' to cancel): ");
		Long id = in.nextLong();
		
		if (id != -1) {
			repo.deleteById(id);
		} 	
	}

}
