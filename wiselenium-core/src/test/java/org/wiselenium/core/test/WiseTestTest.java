package org.wiselenium.core.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wiselenium.core.element.field.Radiobutton;
import org.wiselenium.core.element.field.Text;
import org.wiselenium.core.pagefactory.dummy.DummyPage;

@SuppressWarnings("javadoc")
public class WiseTestTest extends WiseTestNG<WiseTestTest> {
	
	@Page
	private DummyPage page;
	
	
	@BeforeClass
	public void pageShouldBeInjected() {
		assertNotNull(this.page);
	}
	
	@Test
	public void shouldFindElement() {
		Text text = this.get(DummyPage.URL).and().findElement(Text.class, By.id("text"));
		assertNotNull(text);
	}
	
	@Test
	public void shouldFindElements() {
		List<Radiobutton> radiobuttons = this.get(DummyPage.URL).and()
			.findElements(Radiobutton.class, By.name("sex"));
		assertNotNull(radiobuttons);
		assertFalse(radiobuttons.isEmpty());
	}
	
	@Test
	public void shouldInitElementsWithClass() {
		DummyPage page = this.initElements(DummyPage.class);
		assertNotNull(page);
	}
	
	@Test
	public void shouldInitElementsWithInstance() {
		DummyPage page = new DummyPage();
		this.initElements(page);
		assertNotNull(page.getText());
	}
	
	@Test
	public void shouldTakeScreenShot() {
		String fileName = "wiseTestScreenShot.png";
		this.takeScreenShot(fileName);
		File file = new File(fileName);
		file.deleteOnExit();
		assertTrue(file.exists());
	}
	
}