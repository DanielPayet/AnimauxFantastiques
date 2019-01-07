package fr.wizard.fantasticBeasts.FantasticBeasts;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import fr.wizard.fantasticBeasts.FantasticBeasts.Controller.BeastsController;
import fr.wizard.fantasticBeasts.Models.Beast;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FantasticBeastsApplicationTests {

	@Test
	public void beastsTest() {
		//GIVEN
		DataBase.load();
		BeastsController beastsController = new BeastsController();
		//WHEN
		List<Beast> beasts = beastsController.getBeasts("Monde entier", "XX");
		//THEN
		Assertions.assertThat(beasts.size()).isEqualTo(2);
	}

}
