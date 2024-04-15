package net.trevorskullcrafter.trevorssentinels.block.sign;

import com.terraformersmc.terraform.sign.BlockSettingsLock;
import com.terraformersmc.terraform.sign.TerraformSign;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.sign.SignType;
import net.minecraft.block.sign.WallSignBlock;
import net.minecraft.util.Identifier;

public class TrevorWallSignBlock extends WallSignBlock implements TerraformSign {
	private final Identifier texture;

	public TrevorWallSignBlock(Identifier texture, AbstractBlock.Settings settings) {
		super(BlockSettingsLock.lock(settings), SignType.OAK); // TODO: take a look at this again
		this.texture = texture;
	}

	@Override public Identifier getTexture() { return texture; }
}
