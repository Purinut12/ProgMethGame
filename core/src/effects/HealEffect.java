package effects;

import java.awt.Transparency;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import characters.Destroyable;
import characters.MainCharacter;

public class HealEffect extends Effect{

	private MainCharacter player;
	private float renderWidth;
	private float renderHeight;
	private int widthPixel;
	private int heightPixel;

	private Vector2 pos;
	private Vector2 staticPos;
	private Vector2 velocity;

	private float transparency;
	private float fadingSpeed;

	private Sprite sprite;

	public HealEffect(MainCharacter player) {
		renderWidth = 16;
		renderHeight = 16;
		widthPixel = 16;
		heightPixel = 16;

		sprite = new Sprite(new Texture("effect/heal.png"), widthPixel, heightPixel);
		this.player = player;
		this.isDestroyed = false;
		pos = new Vector2(0, 0);
		staticPos = new Vector2(0, 0);
		velocity = new Vector2(0, 10);
		transparency = 1.0f;
		fadingSpeed = 0.03f;
	}

	public void render(SpriteBatch batch) {
		sprite.setAlpha(transparency);
		sprite.setPosition(pos.x, pos.y);
		sprite.draw(batch);
	}

	public void update(float dt) {
		this.pos.set(player.getPosition().x + player.getRenderWidth() / 2 - renderWidth / 2,
				player.getPosition().y + player.getRenderHeight() / 2 - renderHeight / 2);
		velocity.scl(dt);
		staticPos.add(velocity);
		velocity.scl(1/dt);
		pos.add(staticPos);
		transparency -= fadingSpeed;
		if(transparency <= 0) {
			transparency = 0;
			isDestroyed = true;
		}
	}
}