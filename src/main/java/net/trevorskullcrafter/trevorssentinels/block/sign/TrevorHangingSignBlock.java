package net.trevorskullcrafter.trevorssentinels.block.sign;

import com.terraformersmc.terraform.sign.BlockSettingsLock;
import com.terraformersmc.terraform.sign.TerraformHangingSign;
import net.minecraft.block.sign.CeilingHangingSignBlock;
import net.minecraft.block.sign.SignType;
import net.minecraft.util.Identifier;

public class TrevorHangingSignBlock extends CeilingHangingSignBlock implements TerraformHangingSign {
	private final Identifier texture;
	private final Identifier guiTexture;

	public TrevorHangingSignBlock(Identifier texture, Identifier guiTexture, Settings settings) {
		super(BlockSettingsLock.lock(settings), SignType.OAK);
		this.texture = texture;
		this.guiTexture = guiTexture;
	}

	@Override public Identifier getTexture() { return texture; }
	@Override public Identifier getGuiTexture() { return guiTexture; }
}
