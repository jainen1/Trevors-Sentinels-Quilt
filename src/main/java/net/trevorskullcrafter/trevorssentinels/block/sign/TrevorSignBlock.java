package net.trevorskullcrafter.trevorssentinels.block.sign;

import com.terraformersmc.terraform.sign.BlockSettingsLock;
import com.terraformersmc.terraform.sign.TerraformSign;
import net.minecraft.block.sign.SignBlock;
import net.minecraft.block.sign.SignType;
import net.minecraft.util.Identifier;

public class TrevorSignBlock extends SignBlock implements TerraformSign {
	private final Identifier texture;

	public TrevorSignBlock(Identifier texture, Settings settings) {
		super(BlockSettingsLock.lock(settings), SignType.OAK);
		this.texture = texture;
	}

	@Override public Identifier getTexture() { return texture; }
}
