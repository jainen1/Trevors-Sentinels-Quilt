package net.trevorskullcrafter.trevorssentinels.block;

import com.terraformersmc.terraform.sign.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.sapling.SaplingBlock;
import net.minecraft.block.sign.SignBlock;
import net.minecraft.block.sign.WallSignBlock;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.custom.*;
import net.trevorskullcrafter.trevorssentinels.block.sapling.*;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.util.ModRegistries;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.*;

public class ModBlocks {
    public static final Block GALINITE_BLOCK = registerBlock("galinite_block", new Block(QuiltBlockSettings.create()
		.pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.CALCITE).mapColor(MapColor.GRAY).strength(3.5f,3f).requiresTool()));
    public static final Block CHISELED_GALINITE_BLOCK = registerBlock("chiseled_galinite_block", new Block(QuiltBlockSettings.copy(ModBlocks.GALINITE_BLOCK)));
    public static final Block GALINITE_PILLAR = registerBlock("galinite_pillar", new PillarBlock(QuiltBlockSettings.copy(ModBlocks.GALINITE_BLOCK)));
    public static final Block DATA_BLOCK = registerBlock("data_block", new DataBlock(QuiltBlockSettings.create().mapColor(MapColor.CYAN)
		.sounds(BlockSoundGroup.HONEY).nonOpaque().dynamicBounds().allowsSpawning(Blocks::never).pistonBehavior(PistonBehavior.PUSH_ONLY).solidBlock(Blocks::never)));
    public static final Block RICE_PLANT = registerBlockWithoutBlockItem("rice_plant", new RiceCropBlock(QuiltBlockSettings.copy(Blocks.WHEAT).nonOpaque()));
    public static final Block GOLDEN_RICE_PLANT = registerBlockWithoutBlockItem("golden_rice_plant", new RiceCropBlock(QuiltBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.GOLD).nonOpaque()));
    public static final Block RICE_BLOCK = registerBlock("rice_block", new PillarBlock(QuiltBlockSettings.copy(Blocks.HAY_BLOCK)));
    public static final Block GOLDEN_RICE_BLOCK = registerBlock("golden_rice_block", new PillarBlock(QuiltBlockSettings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.GOLD)));

    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(QuiltBlockSettings.create().strength(6f,8f)
		.mapColor(MapColor.STONE).sounds(ModSounds.STEEL_SOUNDS).requiresTool()));
    public static final Block CAUTION_STEEL_BLOCK = registerBlock("caution_steel_block", new PillarBlock(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block STAINLESS_STEEL_BLOCK = registerBlock("stainless_steel_block", new Block(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block STARSTEEL_LAMP = registerBlock("starsteel_lamp", new ToggleableLampBlock(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK)
		.mapColor(MapColor.YELLOW_TERRACOTTA).luminance((state) -> state.get(ToggleableLampBlock.CLICKED) ? 15 : 0)));
    public static final Block STARSTEEL_FAN = registerBlock("starsteel_fan", new Block(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block RUSTED_STEEL_BLOCK = registerBlock("rusted_steel_block", new Block(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block BATTERY = registerBlock("battery", new DirectionalBlock(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block FUSEBOX = registerBlock("fusebox", new DirectionalBlock(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block STEEL_LADDER = registerBlock("steel_ladder", new LadderBlock(QuiltBlockSettings.copy(Blocks.LADDER).nonOpaque()
		.sounds(ModSounds.STEEL_SOUNDS).strength(6f, 8f).requiresTool()));
    public static final Block VENDOR = registerBlock("vendor", new VendorBlock(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK).mapColor(MapColor.RED).luminance((state) -> 5)));
    public static final Block FANCY_COMPUTER = registerBlock("fancy_computer", new DirectionalBlock(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK).nonOpaque()));

    public static final Identifier STEEL_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/steel");
    public static final Identifier STEEL_HANGING_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/hanging/steel");
    public static final Identifier STEEL_HANGING_GUI_SIGN_TEXTURE = new Identifier(MOD_ID, "textures/gui/hanging_signs/steel");

    public static final Block STARSTEEL_SIGN = registerBlockWithoutBlockItem("steel_sign",
		new TerraformSignBlock(STEEL_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK).noCollision().instrument(NoteBlockInstrument.BASS)));
    public static final Block STARSTEEL_WALL_SIGN = registerBlockWithoutBlockItem("steel_wall_sign",
		new TerraformWallSignBlock(STEEL_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.STARSTEEL_SIGN)));
    public static final Block STEEL_HANGING_SIGN = registerBlockWithoutBlockItem("steel_hanging_sign",
		new TerraformHangingSignBlock(STEEL_HANGING_SIGN_TEXTURE, STEEL_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.STARSTEEL_SIGN)));
    public static final Block STEEL_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("steel_wall_hanging_sign",
		new TerraformWallHangingSignBlock(STEEL_HANGING_SIGN_TEXTURE, STEEL_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.STARSTEEL_SIGN)));

    public static final BlockFamily STEEL_FAMILY = BlockFamilies.register(ModBlocks.STEEL_BLOCK).sign(ModBlocks.STARSTEEL_SIGN, ModBlocks.STARSTEEL_WALL_SIGN).unlockCriterionName("has_steel").build();

    public static final Block HOLOGRAPHIC_BLUE_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_blue_wall_sign", new WallSignBlock(QuiltBlockSettings.copy(STARSTEEL_WALL_SIGN), ModRegistries.HOLOGRAPHIC_BLUE_WOOD));
    public static final Block HOLOGRAPHIC_BLUE_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_blue_sign", new SignBlock(QuiltBlockSettings.copy(STARSTEEL_SIGN), ModRegistries.HOLOGRAPHIC_BLUE_WOOD));
    public static final Block HOLOGRAPHIC_RED_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_red_wall_sign", new WallSignBlock(QuiltBlockSettings.copy(STARSTEEL_WALL_SIGN), ModRegistries.HOLOGRAPHIC_RED_WOOD));
    public static final Block HOLOGRAPHIC_RED_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_red_sign", new SignBlock(QuiltBlockSettings.copy(STARSTEEL_SIGN), ModRegistries.HOLOGRAPHIC_RED_WOOD));

    public static final Block WAX_INFUSED_COPPER_BLOCK = registerBlock("wax_infused_copper_block", new Block(QuiltBlockSettings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.ORANGE)));

    public static final Block HARD_LIGHT = registerBlockWithoutBlockItem("hard_light", new HardLightBlock(ModItems.HARD_LIGHT_PROJECTOR, QuiltBlockSettings.create().mapColor(MapColor.CYAN)
		.sounds(ModSounds.HARD_LIGHT_SOUNDS).luminance((state) -> 5).emissiveLighting(Blocks::always).noBlockBreakParticles().nonOpaque().dynamicBounds().allowsSpawning(Blocks::never)
		.blockVision(Blocks::never).pistonBehavior(PistonBehavior.IGNORE).strength(-1f, 3600000f)));
    public static final Block CAUTION_HARD_LIGHT = registerBlockWithoutBlockItem("caution_hard_light", new HardLightBlock(ModItems.CAUTION_HARD_LIGHT_PROJECTOR, QuiltBlockSettings.copy(HARD_LIGHT).mapColor(MapColor.GOLD)));
    public static final Block SENTINEL_HARD_LIGHT = registerBlockWithoutBlockItem("sentinel_hard_light", new HardLightBlock(ModItems.SENTINEL_HARD_LIGHT_PROJECTOR, QuiltBlockSettings.copy(HARD_LIGHT).mapColor(MapColor.RED)));
    public static final Block HARD_LIGHT_BARRIER = registerBlock("hard_light_barrier", new GlassBlock(QuiltBlockSettings.copy(HARD_LIGHT)));
    public static final Block CAUTION_HARD_LIGHT_BARRIER = registerBlock("caution_hard_light_barrier", new GlassBlock(QuiltBlockSettings.copy(CAUTION_HARD_LIGHT)));
    public static final Block SENTINEL_HARD_LIGHT_BARRIER = registerBlock("sentinel_hard_light_barrier", new GlassBlock(QuiltBlockSettings.copy(SENTINEL_HARD_LIGHT)));

    public static final Block NUCLEAR_BLOCK = registerBlock("nuclear_block",
		new NuclearBlock(QuiltBlockSettings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(50f,1200f).mapColor(MapColor.EMERALD).requiresTool()),
		new QuiltItemSettings().fireproof());
    public static final Block NUCLEAR_ORE = registerBlock("nuclear_ore",
		new ExperienceDroppingBlock(QuiltBlockSettings.create().sounds(BlockSoundGroup.STONE).strength(50f,1200f).mapColor(MapColor.EMERALD).requiresTool()),
		new QuiltItemSettings().fireproof());
    public static final Block NUCLEAR_CHARGE = registerBlock("nuclear_charge",
		new NuclearChargeBlock(QuiltBlockSettings.create().mapColor(MapColor.EMERALD).sounds(ModSounds.STEEL_SOUNDS)), new QuiltItemSettings().fireproof());
    public static final Block CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks", new Block(QuiltBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block CRACKED_END_STONE_BRICKS = registerBlock("cracked_end_stone_bricks", new Block(QuiltBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block END_STONE_BRICK_COLUMN = registerBlock("end_stone_brick_column", new PillarBlock(QuiltBlockSettings.copy(Blocks.END_STONE_BRICKS)));

    public static final Block SNOWSTONE = registerBlock("snowstone", new Block(QuiltBlockSettings.copy(Blocks.SANDSTONE).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block SNOWSTONE_STAIRS = registerBlock("snowstone_stairs", new StairsBlock(ModBlocks.SNOWSTONE.getDefaultState(), QuiltBlockSettings.copy(Blocks.SANDSTONE_STAIRS).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block SNOWSTONE_SLAB = registerBlock("snowstone_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.SANDSTONE_SLAB).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block SNOWSTONE_WALL = registerBlock("snowstone_wall", new WallBlock(QuiltBlockSettings.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block SMOOTH_SNOWSTONE = registerBlock("smooth_snowstone", new Block(QuiltBlockSettings.copy(Blocks.SMOOTH_SANDSTONE).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block SMOOTH_SNOWSTONE_STAIRS = registerBlock("smooth_snowstone_stairs", new StairsBlock(ModBlocks.SMOOTH_SNOWSTONE.getDefaultState(),
            QuiltBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_STAIRS).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block SMOOTH_SNOWSTONE_SLAB = registerBlock("smooth_snowstone_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_SLAB).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block SMOOTH_SNOWSTONE_WALL = registerBlock("smooth_snowstone_wall", new WallBlock(QuiltBlockSettings.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block CUT_SNOWSTONE = registerBlock("cut_snowstone", new Block(QuiltBlockSettings.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block CUT_SNOWSTONE_SLAB = registerBlock("cut_snowstone_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.CUT_SANDSTONE_SLAB).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block CHISELED_SNOWSTONE = registerBlock("chiseled_snowstone", new Block(QuiltBlockSettings.copy(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.WHITE_TERRACOTTA)));

    public static final Block DIRT_STAIRS = registerBlock("dirt_stairs", new StairsBlock(Blocks.DIRT.getDefaultState(), QuiltBlockSettings.copy(Blocks.DIRT)));
    public static final Block DIRT_SLAB = registerBlock("dirt_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.DIRT)));
    public static final Block COARSE_DIRT_STAIRS = registerBlock("coarse_dirt_stairs", new StairsBlock(Blocks.COARSE_DIRT.getDefaultState(), QuiltBlockSettings.copy(Blocks.COARSE_DIRT)));
    public static final Block COARSE_DIRT_SLAB = registerBlock("coarse_dirt_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.COARSE_DIRT)));
    public static final Block OVERGROWN_GRASS_BLOCK = registerBlock("overgrown_grass_block", new Block(QuiltBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block GRASS_STAIRS = registerBlock("grass_stairs", new StairsBlock(Blocks.GRASS_BLOCK.getDefaultState(), QuiltBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block GRASS_SLAB = registerBlock("grass_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block MOSS_STAIRS = registerBlock("moss_stairs", new StairsBlock(Blocks.MOSS_BLOCK.getDefaultState(), QuiltBlockSettings.copy(Blocks.MOSS_BLOCK)));
    public static final Block MOSS_SLAB = registerBlock("moss_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.MOSS_BLOCK)));
    public static final Block FLESH_BLOCK = registerBlock("flesh_block", new FleshBlock(0.5f, ModSounds.FLESH_AMBIENT,
            QuiltBlockSettings.create().slipperiness(0.7f).strength(1.5F, 6.0F).mapColor(MapColor.RED).sounds(ModSounds.FLESH_SOUNDS)));
    public static final Block FLESH_VEINS = registerBlock("flesh_veins", new FleshVeinBlock(QuiltBlockSettings.copy(Blocks.GLOW_LICHEN)
            .strength(0.7F, 3.0F).luminance((state) -> 0).mapColor(MapColor.RED).sounds(ModSounds.FLESH_SOUNDS)));
    public static final Block FLESHY_EYE = registerBlock("fleshy_eye", new FleshyEyeBlock(QuiltBlockSettings.copy(ModBlocks.FLESH_BLOCK)
            .mapColor(MapColor.YELLOW).luminance((state) -> state.get(ToggleableLampBlock.CLICKED) ? 8 : 0)));
    public static final Block BIG_RED_BUTTON = registerBlock("big_red_button", new ButtonBlock(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK).noCollision().mapColor(MapColor.RED),
            BlockSetType.IRON, 5, false));
    public static final Block BIG_RED_PLATE = registerBlock("big_red_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK).mapColor(MapColor.RED), BlockSetType.IRON));

    public static final Block PALE_PLANKS = registerBlock("pale_planks", new Block(QuiltBlockSettings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block PALE_SAPLING = registerBlock("pale_sapling",new SaplingBlock(new YggdrasilSaplingGenerator(), QuiltBlockSettings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block POTTED_PALE_SAPLING = registerBlockWithoutBlockItem("potted_pale_sapling", new FlowerPotBlock(PALE_SAPLING, QuiltBlockSettings.copy(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block PALE_LOG = registerBlock("pale_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block STRIPPED_PALE_LOG = registerBlock("stripped_pale_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block PALE_WOOD = registerBlock("pale_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block STRIPPED_PALE_WOOD = registerBlock("stripped_pale_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block PALE_LEAVES = registerBlock("pale_leaves", new LeavesBlock(QuiltBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.MAGENTA)));
    public static final Block PALE_SLAB = registerBlock("pale_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.WARPED_SLAB).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block PALE_FENCE = registerBlock("pale_fence", new FenceBlock(QuiltBlockSettings.copy(Blocks.WARPED_FENCE).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block PALE_STAIRS = registerBlock("pale_stairs", new StairsBlock(ModBlocks.PALE_PLANKS.getDefaultState(), QuiltBlockSettings.copy(Blocks.WARPED_STAIRS).mapColor(MapColor.WHITE_TERRACOTTA)));
    public static final Block PALE_BUTTON = registerBlock("pale_button",
		new ButtonBlock(QuiltBlockSettings.copy(Blocks.WARPED_BUTTON).mapColor(MapColor.WHITE_TERRACOTTA), ModRegistries.YGGDRASIL_WOOD.setType(), 30, true));
    public static final Block PALE_PRESSURE_PLATE = registerBlock("pale_pressure_plate",
		new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copy(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.WHITE_TERRACOTTA), ModRegistries.YGGDRASIL_WOOD.setType()));
    public static final Block PALE_DOOR = registerBlock("pale_door", new DoorBlock(QuiltBlockSettings.copy(Blocks.WARPED_DOOR).mapColor(MapColor.WHITE_TERRACOTTA), ModRegistries.YGGDRASIL_WOOD.setType()));
    public static final Block PALE_TRAPDOOR = registerBlock("pale_trapdoor", new TrapdoorBlock(QuiltBlockSettings.copy(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.WHITE_TERRACOTTA), ModRegistries.YGGDRASIL_WOOD.setType()));
    public static final Block PALE_FENCE_GATE = registerBlock("pale_fence_gate", new FenceGateBlock(QuiltBlockSettings.copy(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.WHITE_TERRACOTTA), ModRegistries.YGGDRASIL_WOOD));

    public static final Identifier PALE_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/pale");
    public static final Identifier PALE_HANGING_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/hanging/pale");
    public static final Identifier PALE_HANGING_GUI_SIGN_TEXTURE = new Identifier(MOD_ID, "textures/gui/hanging_signs/pale");

    public static final Block PALE_SIGN = registerBlockWithoutBlockItem("pale_sign",
            new TerraformSignBlock(PALE_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.PALE_PLANKS).noCollision().instrument(NoteBlockInstrument.BASS)));
    public static final Block PALE_WALL_SIGN = registerBlockWithoutBlockItem("pale_wall_sign",
            new TerraformWallSignBlock(PALE_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.PALE_SIGN)));
    public static final Block PALE_HANGING_SIGN = registerBlockWithoutBlockItem("pale_hanging_sign",
            new TerraformHangingSignBlock(PALE_HANGING_SIGN_TEXTURE, PALE_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.PALE_SIGN)));
    public static final Block PALE_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("pale_wall_hanging_sign",
            new TerraformWallHangingSignBlock(PALE_HANGING_SIGN_TEXTURE, PALE_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.PALE_SIGN)));

    public static final BlockFamily PALE_FAMILY = BlockFamilies.register(PALE_PLANKS).stairs(PALE_STAIRS).slab(PALE_SLAB).button(PALE_BUTTON)
            .pressurePlate(PALE_PRESSURE_PLATE).fence(PALE_FENCE).fenceGate(PALE_FENCE_GATE).door(PALE_DOOR).trapdoor(PALE_TRAPDOOR)
            .sign(PALE_SIGN, PALE_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();

    public static final Block CHARRED_PLANKS = registerBlock("charred_planks", new Block(QuiltBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_LOG = registerBlock("charred_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_WOOD = registerBlock("charred_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_CHARRED_WOOD = registerBlock("stripped_charred_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_SLAB = registerBlock("charred_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_FENCE = registerBlock("charred_fence", new FenceBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_STAIRS = registerBlock("charred_stairs", new StairsBlock(ModBlocks.CHARRED_PLANKS.getDefaultState(), QuiltBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_BUTTON = registerBlock("charred_button",
		new ButtonBlock(QuiltBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType(), 30, true));
    public static final Block CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate",
		new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType()));
    public static final Block CHARRED_DOOR = registerBlock("charred_door", new DoorBlock(QuiltBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType()));
    public static final Block CHARRED_TRAPDOOR = registerBlock("charred_trapdoor", new TrapdoorBlock(QuiltBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType()));
    public static final Block CHARRED_FENCE_GATE = registerBlock("charred_fence_gate", new FenceGateBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD));

    public static final Identifier CHARRED_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/charred");
    public static final Identifier CHARRED_HANGING_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/hanging/charred");
    public static final Identifier CHARRED_HANGING_GUI_SIGN_TEXTURE = new Identifier(MOD_ID, "textures/gui/hanging_signs/charred");

    public static final Block CHARRED_SIGN = registerBlockWithoutBlockItem("charred_sign",
            new TerraformSignBlock(CHARRED_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CHARRED_PLANKS).noCollision().instrument(NoteBlockInstrument.BASS)));
    public static final Block CHARRED_WALL_SIGN = registerBlockWithoutBlockItem("charred_wall_sign",
            new TerraformWallSignBlock(CHARRED_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CHARRED_SIGN)));
    public static final Block CHARRED_HANGING_SIGN = registerBlockWithoutBlockItem("charred_hanging_sign",
            new TerraformHangingSignBlock(CHARRED_HANGING_SIGN_TEXTURE, CHARRED_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CHARRED_SIGN)));
    public static final Block CHARRED_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("charred_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CHARRED_HANGING_SIGN_TEXTURE, CHARRED_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CHARRED_SIGN)));

    public static final BlockFamily CHARRED_FAMILY = BlockFamilies.register(CHARRED_PLANKS).stairs(CHARRED_STAIRS).slab(CHARRED_SLAB).button(CHARRED_BUTTON)
            .pressurePlate(CHARRED_PRESSURE_PLATE).fence(CHARRED_FENCE).fenceGate(CHARRED_FENCE_GATE).door(CHARRED_DOOR).trapdoor(CHARRED_TRAPDOOR)
            .sign(CHARRED_SIGN, CHARRED_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();

    public static final Block MIDAS_PLANKS = registerBlock("midas_planks", new Block(QuiltBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_SAPLING = registerBlock("midas_sapling",new SaplingBlock(new MidasSaplingGenerator(), QuiltBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_MIDAS_SAPLING = registerBlockWithoutBlockItem("potted_midas_sapling", new FlowerPotBlock(MIDAS_SAPLING, QuiltBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block MIDAS_LOG = registerBlock("midas_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GOLD)));
    public static final Block STRIPPED_MIDAS_LOG = registerBlock("stripped_midas_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_WOOD = registerBlock("midas_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GOLD)));
    public static final Block STRIPPED_MIDAS_WOOD = registerBlock("stripped_midas_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_LEAVES = registerBlock("midas_leaves", new LeavesBlock(QuiltBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.EMERALD)));
    public static final Block MIDAS_SLAB = registerBlock("midas_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_FENCE = registerBlock("midas_fence", new FenceBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_STAIRS = registerBlock("midas_stairs", new StairsBlock(ModBlocks.MIDAS_PLANKS.getDefaultState(), QuiltBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_BUTTON = registerBlock("midas_button",
		new ButtonBlock(QuiltBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType(), 30, true));
    public static final Block MIDAS_PRESSURE_PLATE = registerBlock("midas_pressure_plate",
		new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType()));
    public static final Block MIDAS_DOOR = registerBlock("midas_door", new DoorBlock(QuiltBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType()));
    public static final Block MIDAS_TRAPDOOR = registerBlock("midas_trapdoor", new TrapdoorBlock(QuiltBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType()));
    public static final Block MIDAS_FENCE_GATE = registerBlock("midas_fence_gate", new FenceGateBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD));

    public static final Identifier MIDAS_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/midas");
    public static final Identifier MIDAS_HANGING_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/hanging/midas");
    public static final Identifier MIDAS_HANGING_GUI_SIGN_TEXTURE = new Identifier(MOD_ID, "textures/gui/hanging_signs/midas");

    public static final Block MIDAS_SIGN = registerBlockWithoutBlockItem("midas_sign",
            new TerraformSignBlock(MIDAS_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.MIDAS_PLANKS).noCollision().instrument(NoteBlockInstrument.BASS)));
    public static final Block MIDAS_WALL_SIGN = registerBlockWithoutBlockItem("midas_wall_sign",
            new TerraformWallSignBlock(MIDAS_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.MIDAS_SIGN)));
    public static final Block MIDAS_HANGING_SIGN = registerBlockWithoutBlockItem("midas_hanging_sign",
            new TerraformHangingSignBlock(MIDAS_HANGING_SIGN_TEXTURE, MIDAS_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.MIDAS_SIGN)));
    public static final Block MIDAS_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("midas_wall_hanging_sign",
            new TerraformWallHangingSignBlock(MIDAS_HANGING_SIGN_TEXTURE, MIDAS_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.MIDAS_SIGN)));

    public static final BlockFamily MIDAS_FAMILY = BlockFamilies.register(MIDAS_PLANKS).stairs(MIDAS_STAIRS).slab(MIDAS_SLAB).button(MIDAS_BUTTON)
            .pressurePlate(MIDAS_PRESSURE_PLATE).fence(MIDAS_FENCE).fenceGate(MIDAS_FENCE_GATE).door(MIDAS_DOOR).trapdoor(MIDAS_TRAPDOOR)
            .sign(MIDAS_SIGN, MIDAS_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();

    public static final Block VIRIDIAN_PLANKS = registerBlock("viridian_planks", new Block(QuiltBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GREEN)));
    public static final Block VIRIDIAN_SAPLING = registerBlock("viridian_sapling",new SaplingBlock(new ViridianSaplingGenerator(), QuiltBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_VIRIDIAN_SAPLING = registerBlockWithoutBlockItem("potted_viridian_sapling", new FlowerPotBlock(VIRIDIAN_SAPLING, QuiltBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block VIRIDIAN_LOG = registerBlock("viridian_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GREEN)));
    public static final Block STRIPPED_VIRIDIAN_LOG = registerBlock("stripped_viridian_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GREEN)));
    public static final Block VIRIDIAN_WOOD = registerBlock("viridian_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GREEN)));
    public static final Block STRIPPED_VIRIDIAN_WOOD = registerBlock("stripped_viridian_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GREEN)));
    public static final Block VIRIDIAN_LEAVES = registerBlock("viridian_leaves", new LeavesBlock(QuiltBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.GREEN)));
    public static final Block VIRIDIAN_SLAB = registerBlock("viridian_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GREEN)));
    public static final Block VIRIDIAN_FENCE = registerBlock("viridian_fence", new FenceBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GREEN)));
    public static final Block VIRIDIAN_STAIRS = registerBlock("viridian_stairs", new StairsBlock(ModBlocks.VIRIDIAN_PLANKS.getDefaultState(), QuiltBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GREEN)));
    public static final Block VIRIDIAN_BUTTON = registerBlock("viridian_button",
		new ButtonBlock(QuiltBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType(), 30, true));
    public static final Block VIRIDIAN_PRESSURE_PLATE = registerBlock("viridian_pressure_plate",
		new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copy(Blocks.JUNGLE_PRESSURE_PLATE).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType()));
    public static final Block VIRIDIAN_DOOR = registerBlock("viridian_door", new DoorBlock(QuiltBlockSettings.copy(Blocks.JUNGLE_DOOR).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType()));
    public static final Block VIRIDIAN_TRAPDOOR = registerBlock("viridian_trapdoor", new TrapdoorBlock(QuiltBlockSettings.copy(Blocks.JUNGLE_TRAPDOOR).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType()));
    public static final Block VIRIDIAN_FENCE_GATE = registerBlock("viridian_fence_gate", new FenceGateBlock(QuiltBlockSettings.copy(Blocks.JUNGLE_FENCE_GATE).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD));

    public static final Identifier VIRIDIAN_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/viridian");
    public static final Identifier VIRIDIAN_HANGING_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/hanging/viridian");
    public static final Identifier VIRIDIAN_HANGING_GUI_SIGN_TEXTURE = new Identifier(MOD_ID, "textures/gui/hanging_signs/viridian");

    public static final Block VIRIDIAN_SIGN = registerBlockWithoutBlockItem("viridian_sign",
            new TerraformSignBlock(VIRIDIAN_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.VIRIDIAN_PLANKS).noCollision().instrument(NoteBlockInstrument.BASS)));
    public static final Block VIRIDIAN_WALL_SIGN = registerBlockWithoutBlockItem("viridian_wall_sign",
            new TerraformWallSignBlock(VIRIDIAN_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.VIRIDIAN_SIGN)));
    public static final Block VIRIDIAN_HANGING_SIGN = registerBlockWithoutBlockItem("viridian_hanging_sign",
            new TerraformHangingSignBlock(VIRIDIAN_HANGING_SIGN_TEXTURE, VIRIDIAN_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.VIRIDIAN_SIGN)));
    public static final Block VIRIDIAN_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("viridian_wall_hanging_sign",
            new TerraformWallHangingSignBlock(VIRIDIAN_HANGING_SIGN_TEXTURE, VIRIDIAN_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.VIRIDIAN_SIGN)));

    public static final BlockFamily VIRIDIAN_FAMILY = BlockFamilies.register(VIRIDIAN_PLANKS).stairs(VIRIDIAN_STAIRS).slab(VIRIDIAN_SLAB).button(VIRIDIAN_BUTTON)
            .pressurePlate(VIRIDIAN_PRESSURE_PLATE).fence(VIRIDIAN_FENCE).fenceGate(VIRIDIAN_FENCE_GATE).door(VIRIDIAN_DOOR).trapdoor(VIRIDIAN_TRAPDOOR)
            .sign(VIRIDIAN_SIGN, VIRIDIAN_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();

    public static final Block CERULII_PLANKS = registerBlock("cerulii_planks", new Block(QuiltBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.BLUE)));
    public static final Block CERULII_SAPLING = registerBlock("cerulii_sapling",new SaplingBlock(new CeruliiSaplingGenerator(), QuiltBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_CERULII_SAPLING = registerBlockWithoutBlockItem("potted_cerulii_sapling", new FlowerPotBlock(CERULII_SAPLING, QuiltBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block CERULII_LOG = registerBlock("cerulii_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.BLUE)));
    public static final Block STRIPPED_CERULII_LOG = registerBlock("stripped_cerulii_log", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.BLUE)));
    public static final Block CERULII_WOOD = registerBlock("cerulii_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.BLUE)));
    public static final Block STRIPPED_CERULII_WOOD = registerBlock("stripped_cerulii_wood", new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.BLUE)));
    public static final Block CERULII_LEAVES = registerBlock("cerulii_leaves", new LeavesBlock(QuiltBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.BLUE)));
    public static final Block CERULII_SLAB = registerBlock("cerulii_slab", new SlabBlock(QuiltBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.BLUE)));
    public static final Block CERULII_FENCE = registerBlock("cerulii_fence", new FenceBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.BLUE)));
    public static final Block CERULII_STAIRS = registerBlock("cerulii_stairs", new StairsBlock(ModBlocks.CERULII_PLANKS.getDefaultState(), QuiltBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.BLUE)));
    public static final Block CERULII_BUTTON = registerBlock("cerulii_button",
		new ButtonBlock(QuiltBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType(), 30, true));
    public static final Block CERULII_PRESSURE_PLATE = registerBlock("cerulii_pressure_plate",
		new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType()));
    public static final Block CERULII_DOOR = registerBlock("cerulii_door", new DoorBlock(QuiltBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType()));
    public static final Block CERULII_TRAPDOOR = registerBlock("cerulii_trapdoor", new TrapdoorBlock(QuiltBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType()));
    public static final Block CERULII_FENCE_GATE = registerBlock("cerulii_fence_gate", new FenceGateBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD));

    public static final Identifier CERULII_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/cerulii");
    public static final Identifier CERULII_HANGING_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/signs/hanging/cerulii");
    public static final Identifier CERULII_HANGING_GUI_SIGN_TEXTURE = new Identifier(MOD_ID, "textures/gui/hanging_signs/cerulii");

    public static final Block CERULII_SIGN = registerBlockWithoutBlockItem("cerulii_sign",
            new TerraformSignBlock(CERULII_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CERULII_PLANKS).noCollision().instrument(NoteBlockInstrument.BASS)));
    public static final Block CERULII_WALL_SIGN = registerBlockWithoutBlockItem("cerulii_wall_sign",
            new TerraformWallSignBlock(CERULII_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CERULII_SIGN)));
    public static final Block CERULII_HANGING_SIGN = registerBlockWithoutBlockItem("cerulii_hanging_sign",
            new TerraformHangingSignBlock(CERULII_HANGING_SIGN_TEXTURE, CERULII_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CERULII_SIGN)));
    public static final Block CERULII_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("cerulii_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CERULII_HANGING_SIGN_TEXTURE, CERULII_HANGING_GUI_SIGN_TEXTURE, QuiltBlockSettings.copy(ModBlocks.CERULII_SIGN)));

    public static final BlockFamily CERULII_FAMILY = BlockFamilies.register(CERULII_PLANKS).stairs(CERULII_STAIRS).slab(CERULII_SLAB).button(CERULII_BUTTON)
            .pressurePlate(CERULII_PRESSURE_PLATE).fence(CERULII_FENCE).fenceGate(CERULII_FENCE_GATE).door(CERULII_DOOR).trapdoor(CERULII_TRAPDOOR)
            .sign(CERULII_SIGN, CERULII_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();

    public static final Block DARKSTEEL_BLOCK = registerBlock("darksteel_block", new Block(QuiltBlockSettings.create()
		.sounds(BlockSoundGroup.NETHERITE).mapColor(MapColor.PURPLE_TERRACOTTA).strength(8f,12f).requiresTool()));
    public static final Block IRON_GOLD_BLOCK = registerBlock("iron_gold_block", new Block(QuiltBlockSettings.create()
		.strength(6f,8f).mapColor(MapColor.YELLOW).requiresTool()));
    public static final Block COPPER_IRON_BLOCK = registerBlock("copper_iron_block", new Block(QuiltBlockSettings.create()
		.strength(6f,8f).mapColor(MapColor.RAW_IRON).requiresTool()));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block", new Block(QuiltBlockSettings.create()
		.mapColor(MapColor.RAW_IRON).strength(5f,7f).requiresTool()));
    public static final Block DARK_CHAMBER_BLOCK = registerBlock("dark_chamber_block", new FallDamagelessBlock(0.0f,
		QuiltBlockSettings.create().mapColor(MapColor.BLACK).sounds(BlockSoundGroup.NETHER_STEM).strength(2f,4f)));
    public static final Block LIGHT_CHAMBER_BLOCK = registerBlock("light_chamber_block", new FallDamagelessBlock(0.0f,
		QuiltBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).mapColor(MapColor.SNOW)));
	public static final Block CHAMBER_BLOCK = registerBlock("chamber_block", new FallDamagelessBlock(0.0f,
		QuiltBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).mapColor(MapColor.ORANGE_TERRACOTTA)));
	public static final Block BLUE_AGILITY_BLOCK = registerBlock("blue_agility_block", new FallDamagelessBlock(0.0f,
            QuiltBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).mapColor(MapColor.CYAN).jumpVelocityMultiplier(2.7f).slipperiness(0.989f)));
    public static final Block ORANGE_AGILITY_BLOCK = registerBlock("orange_agility_block", new FallDamagelessBlock(0.0f,
            QuiltBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).mapColor(MapColor.ORANGE).velocityMultiplier(1.4f).slipperiness(0.75f)));
    public static final Block BLACK_AGILITY_BLOCK = registerBlock("black_agility_block",
            new Block(QuiltBlockSettings.copy(ModBlocks.STEEL_BLOCK).slipperiness(/*1.098*/1.2f).mapColor(MapColor.LIGHT_BLUE)));
    //public static final Block FORGE = registerBlock("forge",
    //        new ForgeBlock(QuiltBlockSettings.create().strength(3.5f,3.5f).mapColor(MapColor.GRAY).requiresTool()));
    public static final Block RECONSTRUCTION_TABLE = registerBlock("reconstruction_table", new ReconstructionTableBlock(QuiltBlockSettings.create()
            .sounds(ModSounds.STEEL_SOUNDS).mapColor(MapColor.WARPED_WART_BLOCK).strength(35f,1200f).nonOpaque().requiresTool()),
            new QuiltItemSettings().fireproof());
    public static final Block MODIFICATION_TABLE = registerBlock("modification_table", new ModificationTableBlock(QuiltBlockSettings.create()
            .sounds(ModSounds.STEEL_SOUNDS).mapColor(MapColor.WARPED_WART_BLOCK).strength(35f,1200f).nonOpaque().requiresTool()));

    public static final Block TRANQUIL_ROSE = registerBlock("tranquil_rose",
            new FlowerBlock(StatusEffects.DARKNESS, 8, QuiltBlockSettings.copy(Blocks.ALLIUM).luminance((state) -> 4)),
            new QuiltItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.4f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 30, 0), 0.3f).build()));
    public static final Block POTTED_TRANQUIL_ROSE = registerBlockWithoutBlockItem("potted_tranquil_rose",
            new FlowerPotBlock(ModBlocks.TRANQUIL_ROSE, QuiltBlockSettings.copy(Blocks.POTTED_ALLIUM).luminance((state) -> 4)));
    public static final Block SKULLWEED = registerBlock("skullweed",
            new FlowerBlock(StatusEffects.HASTE, 8, QuiltBlockSettings.copy(Blocks.ALLIUM).sounds(BlockSoundGroup.NETHER_SPROUTS)),
            new QuiltItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.4f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 30, 0), 0.3f).build()));
    public static final Block POTTED_SKULLWEED = registerBlockWithoutBlockItem("potted_skullweed",
            new FlowerPotBlock(ModBlocks.SKULLWEED, QuiltBlockSettings.copy(Blocks.POTTED_ALLIUM)));
    public static final Block FEATHERCORN = registerBlockWithoutBlockItem("feathercorn", new TallFlowerBlock(QuiltBlockSettings.copy(Blocks.ROSE_BUSH)));

    private static Block registerBlock(String name, Block block){ registerBlockItem(name, block, new QuiltItemSettings()); return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block); }
    private static Block registerBlock(String name, Block block, QuiltItemSettings settings){ registerBlockItem(name, block, settings); return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block); }
    private static void registerBlockItem(String name, Block block, QuiltItemSettings settings) { Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, settings)); }
    private static Block registerBlockWithoutBlockItem(String name, Block block){ return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block); }

    public static void registerModBlocks(){ LOGGER.info("Registering blocks... (" + MOD_ID + ")"); }
}
