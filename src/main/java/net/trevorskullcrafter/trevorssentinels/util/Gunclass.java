package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.sound.SoundEvent;

public class Gunclass {
    String name; SoundEvent shootSound; SoundEvent shootFailSound; SoundEvent reloadSound;

    public Gunclass(String name, SoundEvent shoot, SoundEvent shootFail, SoundEvent reload){
        this.name = name; this.shootSound = shoot; this.shootFailSound = shootFail; this.reloadSound = reload;
    }

    public String getName(){ return name; }
    public SoundEvent getShootSound() { return shootSound; }
    public SoundEvent getShootFailSound(){ return shootFailSound; }
    public SoundEvent getReloadSound(){ return reloadSound; }
}