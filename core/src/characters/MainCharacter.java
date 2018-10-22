package characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gameprogmeth.game.GameProgMeth;

public class MainCharacter extends Character {

	public MainCharacter(int x, int y, int speed) {
		animationSpeed = 0.5f;
		renderWidth = 160;
		renderHeight = 240;
		widthPixel = 80;
		heightPixel = 80;

		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		this.speed = speed;

		animation = new Animation[4];
		roll = 2;

		TextureRegion[][] rollSpriteSheet = TextureRegion.split(new Texture("Main Character.png"), widthPixel,
				heightPixel);

		animation[0] = new Animation<TextureRegion>(animationSpeed, rollSpriteSheet[0]);
		animation[1] = new Animation<TextureRegion>(animationSpeed, rollSpriteSheet[1]);
		animation[2] = new Animation<TextureRegion>(animationSpeed, rollSpriteSheet[2]);
		animation[3] = new Animation<TextureRegion>(animationSpeed, rollSpriteSheet[3]);
	}

}
