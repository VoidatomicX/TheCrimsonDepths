package arsenal.the_crimson_depths.entity;

import arsenal.the_crimson_depths.The_crimson_depths;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModEntities {
    static Map<EntityType<? extends Entity>, Identifier> ENTITIES = new LinkedHashMap<>();

     public static EntityType<ScytheEntity> Pure_Resonite_Slash = createEntity("pure_resonite_slash", FabricEntityTypeBuilder.<ScytheEntity>create(SpawnGroup.MISC, ScytheEntity::new).disableSaving().dimensions(EntityDimensions.changing(5.0f, 0.2f)).build());



    private static <T extends EntityType<? extends Entity>> T createEntity(String name, T entity) {
        ENTITIES.put(entity, Identifier.of(The_crimson_depths.MOD_ID, name));
        return entity;
    }

    public static void registerModEntities() {
        The_crimson_depths.LOGGER.info("Registering Mod Entities for" + The_crimson_depths.MOD_ID);

        ENTITIES.keySet().forEach(entityType -> Registry.register(Registries.ENTITY_TYPE, ENTITIES.get(entityType), entityType));
    }
}
