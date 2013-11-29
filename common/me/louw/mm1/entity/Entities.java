package me.louw.mm1.entity;

import me.louw.mm1.MyMod;
import me.louw.mm1.model.ModelHermes;
import me.louw.mm1.render.RenderHermes;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Entities {

	public Entities() {
	}

	@SuppressWarnings("unchecked")
	public void addEntities(MyMod mod) {
		System.out.print("Registering Entities");
		EntityRegistry.registerModEntity(EntityHermes.class, "hermes", MyMod.ids.get(), mod, 50, 1, true);
		//EntityRegistry.registerModEntity(EntityPredator.class, "predator", MyMod.ids.get(), mod, 50, 1, true);

		System.out.print(" -> Renderers");
		RenderingRegistry.registerEntityRenderingHandler(EntityHermes.class, new RenderHermes(new ModelHermes(), 0.6F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityPredator.class, new RenderPredator(new ModelPredator(), 0.6F));

		System.out.print(" -> Eggs");
		int id = MyMod.ids.get();
		EntityList.IDtoClassMapping.put(id, EntityHermes.class);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, 0x00FF00, 0xFFFFFF));
		//id = MyMod.ids.get();
		//EntityList.IDtoClassMapping.put(id, EntityPredator.class);
		//EntityList.entityEggs.put(id, new EntityEggInfo(id, 0xA6A6A6, 0x666666));

		System.out.println(" -> Names");
		LanguageRegistry.instance().addStringLocalization("entity.MM1.hermes.name", "Hermes");
		//LanguageRegistry.instance().addStringLocalization("entity.MM1.predator.name", "Predator");
	}
}
