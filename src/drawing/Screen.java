package drawing;

import gui.Field;
import gui.ItemBar;
import gui.TopBar;
import item.Item;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Screen extends VBox {
	private static final Screen instance = new Screen();
	private TopBar topBar;
	private ItemBar itemBar;
	
	public Screen() {
		this.setHeight(580);
		this.setWidth(800);
		
		topBar = new TopBar();
		itemBar = topBar.getItemBar();
		this.setEventHandle();
		this.getChildren().addAll(topBar,Field.getInstance());
		
	}
	
	public void setEventHandle() {
		try {
		itemBar.getLavaCard().setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(!itemBar.getLavaCard().getHasCoolDown()) {
					Dragboard db = itemBar.getLavaCard().startDragAndDrop(TransferMode.MOVE);

					ClipboardContent content = new ClipboardContent();
					content.putString(itemBar.getLavaCard().getName());
					content.putImage(itemBar.getLavaCard().getImage());
					db.setContent(content);

					event.consume();
				}
			}
		});
		
		itemBar.getArrowDispenserCard().setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(!itemBar.getArrowDispenserCard().getHasCoolDown()) {
					

					Dragboard db = itemBar.getArrowDispenserCard().startDragAndDrop(TransferMode.MOVE);

					ClipboardContent content = new ClipboardContent();
					content.putString(itemBar.getArrowDispenserCard().getName());
					content.putImage(itemBar.getArrowDispenserCard().getImage());
					db.setContent(content);

					event.consume();
				}
			}
		});
		
		itemBar.getSnowDispenserCard().setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(!itemBar.getSnowDispenserCard().getHasCoolDown()) {
					

					Dragboard db = itemBar.getSnowDispenserCard().startDragAndDrop(TransferMode.MOVE);

					ClipboardContent content = new ClipboardContent();
					content.putString(itemBar.getSnowDispenserCard().getName());
					content.putImage(itemBar.getSnowDispenserCard().getImage());
					db.setContent(content);

					event.consume();
				}
			}
		});
		
		Field.getInstance().setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {

				if (event.getGestureSource() != Field.getInstance() && event.getDragboard().hasString()) {
					event.acceptTransferModes(TransferMode.MOVE);
				}

				event.consume();
			}
		});
		
		Field.getInstance().setOnDragEntered(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				event.consume();
			}
		});
		
		Field.getInstance().setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				int x = (int) event.getX();
				int y = (int) event.getY();
				boolean success = false;
				
				if (db.hasString()) {
					//System.out.println(x+" "+y);
					String name = db.getString();
					Item item = Field.getInstance().cardToItem(name);
					if(Field.getInstance().setItem(x, y, item)) {
						if(name == itemBar.getLavaCard().getName()) {
							itemBar.getLavaCard().setHasCoolDown(true);
							itemBar.getLavaCard().coolDownTime(itemBar.getLavaCard());
						
						}
						if(name == itemBar.getArrowDispenserCard().getName()) {
							itemBar.getArrowDispenserCard().setHasCoolDown(true);
							itemBar.getArrowDispenserCard().coolDownTime(itemBar.getArrowDispenserCard());
						}
						if(name == itemBar.getSnowDispenserCard().getName()) {
							itemBar.getSnowDispenserCard().setHasCoolDown(true);
							itemBar.getSnowDispenserCard().coolDownTime(itemBar.getSnowDispenserCard());
						}
						success = true;
					}
				}

				event.setDropCompleted(success);
				event.consume();
			}
		});
	}catch(Exception e) {
		System.out.print("There is something wrong");
	}
	}

	public TopBar getTopBar() {
		return topBar;
	}

	public static Screen getInstance() {
		return instance;
	}
	
	
}
