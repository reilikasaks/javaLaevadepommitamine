import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	GridPane laud;
	int lauaPikkusLaevades = 5;
	int laevapikkusPx = 50;
	Stage mainGameStage;
	Image laevaPilt = new Image ("pirate.png");
	ImagePattern laevaMuster = new ImagePattern(laevaPilt);

	@Override
	public void start(Stage primaryStage) throws Exception {
		seadistaLava();
		sisestaLaevad();
		reageeriKlikile();
	}

	private void reageeriKlikile() {
		laud.setOnMouseClicked(event -> {
			Rectangle ruut = (Rectangle) event.getTarget();
			String tyyp = ruut.getId();
			if (tyyp.equals("meri")){
				ruut.setFill(Color.DARKBLUE);
			} else if (tyyp.equals("laev")){
				ruut.setFill(laevaMuster);
				ruut.setId("põhjas");
			}
			if (!laevasidOnAlles()){
				gameover();
			}
		});
	}

	private void gameover() {
		mainGameStage.close();
		StackPane stack = new StackPane();
		Label go = new Label("Võitsid!");
		stack.getChildren().add(go);
		Scene scene = new Scene(stack, 300, 50);
		Stage goStage = new Stage();
		goStage.setScene(scene);
		goStage.show();
	}

	private boolean laevasidOnAlles() {
		for (Node ruut : laud.getChildren()){
			if (ruut.getId().equals("laev")){
				return true;
			}
		}
		return false;
	}

	private void sisestaLaevad() {
		for (int i = 0; i < lauaPikkusLaevades; i++) {
			for (int j = 0; j < lauaPikkusLaevades; j++) {
				//siia tulen 9x9 korda
				Rectangle ruut = new Rectangle(laevapikkusPx, laevapikkusPx);
				int rand = (int) (Math.random()*1.3);
				if (rand==1){
					ruut.setId("laev");
				} else {
					ruut.setId("meri");
				}
				ruut.setFill(Color.BLUE);
				laud.add(ruut, i,j);
			}
			
		}
	}

	private void seadistaLava() {
		laud = new GridPane();
		Scene scene = new Scene(laud, lauaPikkusLaevades*laevapikkusPx, lauaPikkusLaevades*laevapikkusPx);
		mainGameStage = new Stage();
		scene.setFill(Color.DARKBLUE);
		mainGameStage.setScene(scene);
		mainGameStage.show();
	}
}