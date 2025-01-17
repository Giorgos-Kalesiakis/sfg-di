package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("-------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("-------- Property");
		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) ctx.getBean("propertyInjectedController");

		// This throws an error if PropertyInjectedController has not been declared a Spring managed
		// component (i.e. annotated with @Controller for this scenario). Also :
		// 		1. Use @Autowired for the greeting service reference inside propertyInjectedController to avoid null exceptions.
		//		2. Annotate GreetingServiceImpl class as @Service to inform Spring that it's a managed component.
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-------- Setter");

		SetterInjectedController setterInjectedController =
				(SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor");

		ConstructorInjectedController constructorInjectedController =
				(ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());

	}

}
