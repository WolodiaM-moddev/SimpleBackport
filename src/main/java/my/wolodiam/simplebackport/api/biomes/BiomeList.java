// Java package
package my.wolodiam.simplebackport.api.biomes;
// Import minecraft classes
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
// Import Java classes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BiomeList {
    /**
     * Get list of all biomes
     * @return -> List<Biome> => list of all biomes (include modded)
     */
    public static @NotNull List<Biome> getBiomes() {
        List<Biome> biomes = new ArrayList<>();
        for (Biome biome : Biome.REGISTRY) {
            biomes.add(biome);
        }
        return biomes;
    }

    /**
     * Get map for all biome + it's formatted name
     * @return -> Map<String, Biome> => Map from biome name to biome
     */
    public static @NotNull Map<String, Biome> getBiomesWithName() {
        Map<String, Biome> biomes = new HashMap<>();
        for (Biome biome : Biome.REGISTRY) {
            biomes.put(BiomeList.getFormattedBiomeName(biome), biome);
        }
        return biomes;
    }

    /**
     * Get name of biome
     * @param biome -> Biome => Biome
     * @return -> String => Name of inputted biome
     */
    @Contract(pure = true)
    public static @NotNull String getBiomeName(@NotNull Biome biome) {
        return biome.getBiomeName();
    }

    /**
     * Get formatted name of biome, spaces in name will be removed
     * @param b -> Biome => Biome
     * @return -> String => Formatted name of biome
     */
    public static @NotNull String getFormattedBiomeName(@NotNull Biome b) {
        String tmp = BiomeList.getBiomeName(b);
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i <= tmp.length(); i++)
        {
            String c = tmp.substring(i - 1, i);
            if (!c.equals(" ")) ret.append(c);
        }
        return ret.toString();
    }

    /**
     * Get size of biomes (from settings)
     * @param world -> World => For what world we need data
     * @return -> int => Biome size index
     */
    public static int getBiomeSize(@NotNull World world) {
        final String stng = world.getWorldInfo().getGeneratorOptions();
        return ChunkGeneratorSettings.Factory.jsonToFactory(stng).build().biomeSize;
    }
}
