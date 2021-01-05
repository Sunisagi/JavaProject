package sharedObject;


import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	public static Image field;
	public static Image lavaCard;
	public static Image arrowDispenserCard;
	public static Image snowDispenserCard;
	public static Image lava;
	public static Image dispenser;
	public static Image arrow;
	public static Image snowBall;
	public static Image normalZombie;
	public static Image pigMan;
	public static Image itemBar;
	public static Image lavaCard100;
	public static Image lavaCard75;
	public static Image lavaCard50;
	public static Image lavaCard25;
	public static Image arrowDispenserCard100;
	public static Image arrowDispenserCard75;
	public static Image arrowDispenserCard50;
	public static Image arrowDispenserCard25;
	public static Image snowDispenserCard100;
	public static Image snowDispenserCard75;
	public static Image snowDispenserCard50;
	public static Image snowDispenserCard25;
	public static Image startBackground;
	public static Image loseScene;
	public static AudioClip zombieHit;
	public static AudioClip zombie;
	public static AudioClip snow;
	public static AudioClip pigmanHurt;
	public static AudioClip hurt;
	public static AudioClip stone;
	
	
	static {
		loadResource();
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		field = new Image(ClassLoader.getSystemResource("Field1.jpg").toString());
		lavaCard = new Image(ClassLoader.getSystemResource("LavaCard.png").toString());
		arrowDispenserCard = new Image(ClassLoader.getSystemResource("ArrowDispenserCard.png").toString());
		snowDispenserCard = new Image(ClassLoader.getSystemResource("SnowDispenserCard.png").toString());
		lava = new Image(ClassLoader.getSystemResource("Lava.png").toString());
		dispenser = new Image(ClassLoader.getSystemResource("Dispenser02.png").toString());
		arrow = new Image(ClassLoader.getSystemResource("Arrow.png").toString());
		snowBall = new Image(ClassLoader.getSystemResource("Snowball.png").toString());
		normalZombie = new Image(ClassLoader.getSystemResource("NormalZombie.png").toString());
		pigMan= new Image(ClassLoader.getSystemResource("Pigman.png").toString());
		itemBar = new Image(ClassLoader.getSystemResource("Itembar.png").toString());
		lavaCard100 = new Image(ClassLoader.getSystemResource("LavaCard100.jpg").toString());
		lavaCard75 = new Image(ClassLoader.getSystemResource("LavaCard75.jpg").toString());
		lavaCard50 = new Image(ClassLoader.getSystemResource("LavaCard50.jpg").toString());
		lavaCard25 = new Image(ClassLoader.getSystemResource("LavaCard25.jpg").toString());
		arrowDispenserCard100 = new Image(ClassLoader.getSystemResource("ArrowDispenserCard100.jpg").toString());
		arrowDispenserCard75 = new Image(ClassLoader.getSystemResource("ArrowDispenserCard75.jpg").toString());
		arrowDispenserCard50 = new Image(ClassLoader.getSystemResource("ArrowDispenserCard50.jpg").toString());
		arrowDispenserCard25 = new Image(ClassLoader.getSystemResource("ArrowDispenserCard25.jpg").toString());
		snowDispenserCard100 = new Image(ClassLoader.getSystemResource("SnowDispenserCard100.jpg").toString());
		snowDispenserCard75 = new Image(ClassLoader.getSystemResource("SnowDispenserCard75.jpg").toString());
		snowDispenserCard50 = new Image(ClassLoader.getSystemResource("SnowDispenserCard50.jpg").toString());
		snowDispenserCard25 = new Image(ClassLoader.getSystemResource("SnowDispenserCard25.jpg").toString());
		startBackground = new Image(ClassLoader.getSystemResource("StartBackground.png").toString());
		loseScene = new Image(ClassLoader.getSystemResource("LoseScene.png").toString());
		zombieHit = new AudioClip(ClassLoader.getSystemResource("Zombiehit.mp3").toString());
		zombie = new AudioClip(ClassLoader.getSystemResource("zombie.mp3").toString());
		snow = new AudioClip(ClassLoader.getSystemResource("snow.mp3").toString());
		pigmanHurt = new AudioClip(ClassLoader.getSystemResource("Pigmanhurt.mp3").toString());
		hurt = new AudioClip(ClassLoader.getSystemResource("hurt.mp3").toString());
		stone =  new AudioClip(ClassLoader.getSystemResource("stone.mp3").toString());
	}
	
}
