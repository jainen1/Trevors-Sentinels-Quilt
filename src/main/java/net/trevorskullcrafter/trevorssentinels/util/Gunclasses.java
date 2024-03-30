package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.sound.SoundEvents;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;

public class Gunclasses {
    public static final Gunclass PISTOL = new Gunclass("Pistol", ModSounds.BLASTER_SHOOT, SoundEvents.BLOCK_LEVER_CLICK, ModSounds.PISTOL_RELOAD);
    public static final Gunclass SNIPER = new Gunclass("Sniper", ModSounds.BLASTER_SHOOT, SoundEvents.BLOCK_LEVER_CLICK, ModSounds.SNIPER_RELOAD);
    public static final Gunclass SHOTGUN = new Gunclass("Shotgun", ModSounds.BLASTER_SHOOT, SoundEvents.BLOCK_LEVER_CLICK, ModSounds.SHOTGUN_RELOAD);
    public static final Gunclass RIFLE = new Gunclass("Rifle", ModSounds.BLASTER_SHOOT, SoundEvents.BLOCK_LEVER_CLICK, ModSounds.SHOTGUN_RELOAD);

    public static final Gunclass GAS_LAUNCHER = new Gunclass("Gas Launcher", SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundEvents.BLOCK_LEVER_CLICK, ModSounds.BIO_RELOAD);
    public static final Gunclass FLAMETHROWER = new Gunclass("Flamethrower", SoundEvents.ITEM_FIRECHARGE_USE, SoundEvents.BLOCK_LEVER_CLICK, ModSounds.BIO_RELOAD);

    public static final Gunclass VILE_SPITTER = new Gunclass("Living Pistol", ModSounds.FLESH_BREAK, ModSounds.FLESH_HIT, ModSounds.FLESH_AMBIENT);
}