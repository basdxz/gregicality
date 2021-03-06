package gregicadditions;

import com.google.common.collect.ImmutableList;
import gregicadditions.materials.IsotopeMaterial;
import gregicadditions.materials.RadioactiveMaterial;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.IMaterialHandler;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.util.GTLog;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static com.google.common.collect.ImmutableList.of;
import static gregtech.api.unification.Element.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.type.DustMaterial.MatFlags.*;
import static gregtech.api.unification.material.type.FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK;
import static gregtech.api.unification.material.type.FluidMaterial.MatFlags.GENERATE_PLASMA;
import static gregtech.api.unification.material.type.GemMaterial.MatFlags.GENERATE_LENSE;
import static gregtech.api.unification.material.type.GemMaterial.MatFlags.HIGH_SIFTER_OUTPUT;
import static gregtech.api.unification.material.type.IngotMaterial.MatFlags.*;
import static gregtech.api.unification.material.type.Material.MatFlags.*;
import static gregtech.api.unification.material.type.SolidMaterial.MatFlags.*;
import static gregtech.api.util.GTUtility.createFlag;

@IMaterialHandler.RegisterMaterialHandler
public class GAMaterials implements IMaterialHandler {

    public static final long GENERATE_METAL_CASING = createFlag(46);
    public static final long DISABLE_REPLICATION = createFlag(47);

    public static final long GENERATE_NUCLEAR_COMPOUND = createFlag(48);

    public static long STD_METAL = GENERATE_PLATE;
    static long EXT2_METAL = GENERATE_PLATE | GENERATE_DENSE | GENERATE_ROD | GENERATE_BOLT_SCREW | GENERATE_GEAR | GENERATE_FOIL | GENERATE_FINE_WIRE;
    public static final FluidMaterial FishOil = new FluidMaterial(999, "fish_oil", 14467421, MaterialIconSet.FLUID, ImmutableList.of(), GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial RawGrowthMedium = new FluidMaterial(998, "raw_growth_medium", 10777425, MaterialIconSet.FLUID, ImmutableList.of(), GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial SterileGrowthMedium = new FluidMaterial(997, "sterilized_growth_medium", 11306862, MaterialIconSet.FLUID, ImmutableList.of(), GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final DustMaterial Meat = new DustMaterial(996, "meat", 12667980, MaterialIconSet.SAND, 1, ImmutableList.of(), DISABLE_DECOMPOSITION);
    public static final FluidMaterial NeutralMatter = new FluidMaterial(995, "neutral_matter", 3956968, MaterialIconSet.FLUID, ImmutableList.of(), DISABLE_DECOMPOSITION);
    public static final FluidMaterial PositiveMatter = new FluidMaterial(994, "positive_matter", 11279131, MaterialIconSet.FLUID, ImmutableList.of(), DISABLE_DECOMPOSITION);
    public static final IngotMaterial Neutronium = new IngotMaterial(993, "neutronium", 12829635, MaterialIconSet.METALLIC, 6, ImmutableList.of(), EXT2_METAL | GENERATE_RING | GENERATE_ROTOR | GENERATE_SMALL_GEAR | GENERATE_LONG_ROD | GENERATE_FRAME | GENERATE_DENSE, Element.valueOf("Nt"), 24.0F, 12F, 655360);
    public static final DustMaterial Pyrotheum = new DustMaterial(991, "pyrotheum", 0xFF9A3C, MaterialIconSet.SAND, 1, ImmutableList.of(), DISABLE_DECOMPOSITION | EXCLUDE_BLOCK_CRAFTING_RECIPES | SMELT_INTO_FLUID);
    public static final DustMaterial EglinSteelBase = new DustMaterial(990, "eglin_steel_base", 0x8B4513, MaterialIconSet.SAND, 6, ImmutableList.of(new MaterialStack(Iron, 4), new MaterialStack(Kanthal, 1), new MaterialStack(Invar, 5)), 0);
    public static final IngotMaterial EglinSteel = new IngotMaterial(989, "eglin_steel", 0x8B4513, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(GAMaterials.EglinSteelBase, 10), new MaterialStack(Sulfur, 1), new MaterialStack(Silicon, 1), new MaterialStack(Carbon, 1)), EXT2_METAL | GENERATE_METAL_CASING, null, 1048);
    public static final IngotMaterial Grisium = new IngotMaterial(987, "grisium", 0x355D6A, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Titanium, 9), new MaterialStack(Carbon, 9), new MaterialStack(Potassium, 9), new MaterialStack(Lithium, 9), new MaterialStack(Sulfur, 9), new MaterialStack(Hydrogen, 5)), EXT2_METAL | GENERATE_METAL_CASING, null, 3850);
    public static final IngotMaterial Inconel625 = new IngotMaterial(986, "inconel_a", 0x80C880, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Nickel, 3), new MaterialStack(Chrome, 7), new MaterialStack(Molybdenum, 10), new MaterialStack(Invar, 10), new MaterialStack(Nichrome, 13)), EXT2_METAL | GENERATE_METAL_CASING, null, 2425);
    public static final IngotMaterial MaragingSteel250 = new IngotMaterial(985, "maraging_steel_a", 0x92918D, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Steel, 16), new MaterialStack(Molybdenum, 1), new MaterialStack(Titanium, 1), new MaterialStack(Nickel, 4), new MaterialStack(Cobalt, 2)), EXT2_METAL | GENERATE_METAL_CASING, null, 2413);
    public static final IngotMaterial Potin = new IngotMaterial(984, "potin", 0xC99781, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Lead, 2), new MaterialStack(Bronze, 2), new MaterialStack(Tin, 1)), EXT2_METAL | GENERATE_METAL_CASING, null);
    public static final IngotMaterial Staballoy = new IngotMaterial(983, "staballoy", 0x444B42, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Uranium, 9), new MaterialStack(Titanium, 1)), EXT2_METAL | GENERATE_METAL_CASING, null, 3450);
    public static final IngotMaterial HastelloyN = new IngotMaterial(982, "hastelloy_n", 0xDDDDDD, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Yttrium, 2), new MaterialStack(Molybdenum, 4), new MaterialStack(Chrome, 2), new MaterialStack(Titanium, 2), new MaterialStack(Nickel, 15)), EXT2_METAL | GENERATE_METAL_CASING | GENERATE_DENSE, null, 4350);
    public static final IngotMaterial Tumbaga = new IngotMaterial(981, "tumbaga", 0xFFB20F, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Gold, 7), new MaterialStack(Bronze, 3)), EXT2_METAL | GENERATE_METAL_CASING, null, 1200);
    public static final IngotMaterial Stellite = new IngotMaterial(980, "stellite", 0x9991A5, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Cobalt, 9), new MaterialStack(Chrome, 9), new MaterialStack(Manganese, 5), new MaterialStack(Titanium, 2)), EXT2_METAL | GENERATE_METAL_CASING, null, 4310);
    public static final IngotMaterial Talonite = new IngotMaterial(979, "talonite", 0x9991A5, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Cobalt, 4), new MaterialStack(Chrome, 3), new MaterialStack(Phosphorus, 2), new MaterialStack(Molybdenum, 1)), EXT2_METAL | GENERATE_METAL_CASING, null, 3454);
    public static final FluidMaterial IronChloride = new FluidMaterial(978, "iron_chloride", 0x060b0b, MaterialIconSet.FLUID, ImmutableList.of(new MaterialStack(Iron, 1), new MaterialStack(Chlorine, 3)), DECOMPOSITION_BY_ELECTROLYZING);
    public static final IngotMaterial MVSuperconductorBase = new IngotMaterial(976, "mv_superconductor_base", 0x535353, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Cadmium, 5), new MaterialStack(Magnesium, 1), new MaterialStack(Oxygen, 6)), STD_METAL, null, 2500);
    public static final IngotMaterial HVSuperconductorBase = new IngotMaterial(975, "hv_superconductor_base", 0x4a2400, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Titanium, 1), new MaterialStack(Barium, 9), new MaterialStack(Copper, 10), new MaterialStack(Oxygen, 20)), STD_METAL, null, 3300);
    public static final IngotMaterial EVSuperconductorBase = new IngotMaterial(974, "ev_superconductor_base", 0x005800, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Uranium, 1), new MaterialStack(Platinum, 3)), STD_METAL, null, 4400);
    public static final IngotMaterial IVSuperconductorBase = new IngotMaterial(973, "iv_superconductor_base", 0x300030, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Vanadium, 1), new MaterialStack(Indium, 3)), STD_METAL, null, 5200);
    public static final IngotMaterial LuVSuperconductorBase = new IngotMaterial(972, "luv_superconductor_base", 0x7a3c00, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Indium, 4), new MaterialStack(Bronze, 8), new MaterialStack(Barium, 2), new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 14)), STD_METAL, null, 6000);
    public static final IngotMaterial ZPMSuperconductorBase = new IngotMaterial(971, "zpm_superconductor_base", 0x111111, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Naquadah, 4), new MaterialStack(Indium, 2), new MaterialStack(Palladium, 6), new MaterialStack(Osmium, 1)), STD_METAL, null, 8100);
    public static final IngotMaterial MVSuperconductor = new IngotMaterial(970, "mv_superconductor", 0x535353, MaterialIconSet.SHINY, 1, of(), 0);
    public static final IngotMaterial HVSuperconductor = new IngotMaterial(969, "hv_superconductor", 0x4a2400, MaterialIconSet.SHINY, 1, of(), 0);
    public static final IngotMaterial EVSuperconductor = new IngotMaterial(968, "ev_superconductor", 0x005800, MaterialIconSet.SHINY, 1, of(), 0);
    public static final IngotMaterial IVSuperconductor = new IngotMaterial(967, "iv_superconductor", 0x300030, MaterialIconSet.SHINY, 1, of(), 0);
    public static final IngotMaterial LuVSuperconductor = new IngotMaterial(966, "luv_superconductor", 0x7a3c00, MaterialIconSet.SHINY, 1, of(), 0);
    public static final IngotMaterial ZPMSuperconductor = new IngotMaterial(964, "zpm_superconductor", 0x111111, MaterialIconSet.SHINY, 1, of(), 0);
    public static final IngotMaterial Enderium = new IngotMaterial(963, "enderium", 0x23524a, MaterialIconSet.METALLIC, 3, ImmutableList.of(new MaterialStack(Lead, 3), new MaterialStack(Platinum, 1), new MaterialStack(EnderPearl, 1)), EXT2_METAL | DISABLE_DECOMPOSITION, null, 8.0F, 3.0F, 1280, 4500);
    public static final DustMaterial MicaPulp = new DustMaterial(962, "mica_based", 0x917445, MaterialIconSet.SAND, 1, ImmutableList.of(), DISABLE_DECOMPOSITION);
    public static final DustMaterial AluminoSilicateWool = new DustMaterial(961, "alumino_silicate_wool", 0xbbbbbb, MaterialIconSet.SAND, 1, ImmutableList.of(), DISABLE_DECOMPOSITION);
    public static final DustMaterial QuartzSand = new DustMaterial(960, "sand", 0xd2cfbc, MaterialIconSet.SAND, 1, ImmutableList.of(), DISABLE_DECOMPOSITION);
    public static final DustMaterial Massicot = new DustMaterial(959, "massicot", 8943149, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Lead, 1), new MaterialStack(Oxygen, 1)), 0);
    public static final DustMaterial AntimonyTrioxide = new DustMaterial(958, "antimony_trioxide", 8092544, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Antimony, 2), new MaterialStack(Oxygen, 3)), 0);
    public static final DustMaterial Zincite = new DustMaterial(957, "zincite", 8947843, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Zinc, 1), new MaterialStack(Oxygen, 1)), 0);
    public static final DustMaterial CobaltOxide = new DustMaterial(956, "cobalt_oxide", 3556352, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Cobalt, 1), new MaterialStack(Oxygen, 1)), 0);
    public static final DustMaterial ArsenicTrioxide = new DustMaterial(955, "arsenic_trioxide", 15856113, MaterialIconSet.ROUGH, 1, ImmutableList.of(new MaterialStack(Arsenic, 2), new MaterialStack(Oxygen, 3)), 0);
    public static final DustMaterial CupricOxide = new DustMaterial(954, "cupric_oxide", 526344, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Copper, 1), new MaterialStack(Oxygen, 1)), 0);
    public static final DustMaterial Ferrosilite = new DustMaterial(953, "ferrosilite", 5256470, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Iron, 1), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 3)), 0);
    public static final DustMaterial Cryotheum = new DustMaterial(952, "cryotheum", 0x01F3F6, MaterialIconSet.SAND, 1, ImmutableList.of(), DISABLE_DECOMPOSITION | EXCLUDE_BLOCK_CRAFTING_RECIPES | SMELT_INTO_FLUID);
    public static final DustMaterial Blizz = new DustMaterial(951, "blizz", 0x01F3F6, MaterialIconSet.DULL, 1, ImmutableList.of(), NO_SMELTING | SMELT_INTO_FLUID | MORTAR_GRINDABLE | BURNING);
    public static final DustMaterial Snow = new DustMaterial(950, "snow", 0xFFFFFF, MaterialIconSet.OPAL, 1, ImmutableList.of(), NO_SMELTING);
    //    public static final FluidMaterial HighPressureSteam = new FluidMaterial(949, "high_pressure_steam", 0xFFFFFF, MaterialIconSet.GAS, of(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION).setFluidTemperature(1000);
    public static final FluidMaterial HighOctaneGasoline = new FluidMaterial(948, "high_octane", 0xC7860B, MaterialIconSet.FLUID, ImmutableList.of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial Octane = new FluidMaterial(947, "octane", 0xCBCBCB, MaterialIconSet.FLUID, ImmutableList.of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial EthylTertButylEther = new FluidMaterial(946, "ethyl_tert_butyl_ether", 0xCBCBCB, MaterialIconSet.FLUID, ImmutableList.of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial Gasoline = new FluidMaterial(945, "gasoline", 0xC7860B, MaterialIconSet.FLUID, ImmutableList.of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial RawGasoline = new FluidMaterial(944, "raw_gasoline", 0xC5560C, MaterialIconSet.FLUID, ImmutableList.of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final IngotMaterial Nitinol60 = new IngotMaterial(943, "nitinol_a", 0xCCB0EC, MaterialIconSet.METALLIC, 4, ImmutableList.of(new MaterialStack(Nickel, 2), new MaterialStack(Titanium, 3)), EXT2_METAL | GENERATE_METAL_CASING, null, 0);
    public static final IngotMaterial BabbittAlloy = new IngotMaterial(942, "babbitt_alloy", 0xA19CA4, MaterialIconSet.METALLIC, 4, ImmutableList.of(new MaterialStack(Tin, 5), new MaterialStack(Lead, 36), new MaterialStack(Antimony, 8), new MaterialStack(Arsenic, 1)), EXT2_METAL | GENERATE_METAL_CASING, null, 5925);
    public static final IngotMaterial HG1223 = new IngotMaterial(941, "hg_alloy", 0x245397, MaterialIconSet.METALLIC, 4, ImmutableList.of(new MaterialStack(Mercury, 1), new MaterialStack(Barium, 2), new MaterialStack(Calcium, 2), new MaterialStack(Copper, 3), new MaterialStack(Oxygen, 8)), EXT2_METAL | GENERATE_METAL_CASING | GENERATE_DENSE, null, 5925);
    public static final IngotMaterial IncoloyMA956 = new IngotMaterial(940, "incoloy_ma", 0xAABEBB, MaterialIconSet.METALLIC, 4, ImmutableList.of(new MaterialStack(Iron, 16), new MaterialStack(Aluminium, 3), new MaterialStack(Chrome, 5), new MaterialStack(Yttrium, 1)), EXT2_METAL | GENERATE_METAL_CASING, null, 5925);
    public static final FluidMaterial RocketFuelH8N4C2O4 = new FluidMaterial(939, "rocket_fuel_a", 0x5ECB22, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial NitrogenTetroxide = new FluidMaterial(938, "nitrogen_tetroxide", 0xBE6800, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial CoalTar = new FluidMaterial(937, "coal_tar", 0x5E3122, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial CoalTarOil = new FluidMaterial(936, "coal_tar_oil", 0xB5B553, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial SulfuricCoalTarOil = new FluidMaterial(935, "sulfuric_coal_tar_oil", 0xFFFFAD, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial Anthracene = new FluidMaterial(934, "anthracene", 0xA2ACA2, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial Kerosene = new FluidMaterial(933, "kerosene", 0xD570D5, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial EthylBenzene = new FluidMaterial(932, "ethylbenzene", 0xD5D5D5, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial MonoMethylHydrazine = new FluidMaterial(931, "monomethylhydrazine", 0xFFFFFF, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial Hydrazine = new FluidMaterial(930, "hydrazine", 0xFFFFFF, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial HydrogenPeroxide = new FluidMaterial(929, "hydrogen_peroxide", 0xD1FFFF, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial EthylAnthraQuinone = new FluidMaterial(928, "ethylanthraquinone", 0xFFFF00, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial EthylAnthraHydroQuinone = new FluidMaterial(927, "ethylanthrahydroquinone", 0xFFFF47, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final DustMaterial PhthalicAnhydride = new DustMaterial(926, "phthalicanhydride", 0xD1D1D1, MaterialIconSet.SAND, 1, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial PhthalicAcid = new FluidMaterial(925, "phthalicacid", 0xD1D1D1, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial Naphtalene = new FluidMaterial(924, "naphtalene", 0xFFFFFF, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial DenseHydrazineFuelMixture = new FluidMaterial(923, "dense_hydrazine_fuel_mixture", 0x5E2B4A, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial RocketFuelCN3H7O3 = new FluidMaterial(922, "rocket_fuel_b", 0xBE46C5, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial RP1RocketFuel = new FluidMaterial(921, "rocket_fuel_c", 0xFF503C, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial RP1 = new FluidMaterial(920, "rp", 0xFF6E5D, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial LiquidOxygen = new FluidMaterial(919, "liquid_oxygen", 0x81FFFD, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION).setFluidTemperature(54);
    public static final FluidMaterial FermentationBase = new FluidMaterial(918, "fermentation_base", 0x3D5917, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION);
    public static final FluidMaterial LiquidHydrogen = new FluidMaterial(917, "liquid_hydrogen", 0x3AFFC6, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION).setFluidTemperature(14);
    public static final FluidMaterial Xenon = new FluidMaterial(916, "xenon", 0x270095, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION, Xe);
    public static final FluidMaterial Neon = new FluidMaterial(915, "neon", 0xFF422A, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION, Ne);
    public static final FluidMaterial Krypton = new FluidMaterial(914, "krypton", 0x31C42F, MaterialIconSet.FLUID, of(), NO_RECYCLING | GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION, Kr);
    public static final IngotMaterial Zirconium = new IngotMaterial(912, "zirconium", 0xE0E1E1, MaterialIconSet.METALLIC, 6, of(), EXT2_METAL, Zr);
    public static final GemMaterial CubicZirconia = new GemMaterial(911, "cubic_zirconia", 0xFFDFE2, MaterialIconSet.DIAMOND, 6, of(new MaterialStack(Zirconium, 1), new MaterialStack(Oxygen, 2)), NO_RECYCLING | NO_SMELTING);
    public static final GemMaterial Prasiolite = new GemMaterial(910, "prasiolite", 0x9EB749, MaterialIconSet.QUARTZ, 2, of(new MaterialStack(Silicon, 5), new MaterialStack(Oxygen, 10), new MaterialStack(Iron, 1)), GENERATE_ORE);
    public static final DustMaterial Dibismusthydroborat = new DustMaterial(909, "dibismuthhydroborat", 0x00B749, MaterialIconSet.SAND, 2, of(new MaterialStack(Bismuth, 2), new MaterialStack(Hydrogen, 1), new MaterialStack(Boron, 1)), 0);
    public static final DustMaterial BismuthTellurite = new DustMaterial(908, "bismuth_tellurite", 0x006B38, MaterialIconSet.SAND, 2, of(new MaterialStack(Bismuth, 2), new MaterialStack(Tellurium, 3)), 0);
    public static final DustMaterial CircuitCompoundMK3 = new DustMaterial(907, "circuit_compound_mkc", 0x003316, MaterialIconSet.SAND, 2, of(new MaterialStack(IndiumGalliumPhosphide, 1), new MaterialStack(Dibismusthydroborat, 3), new MaterialStack(BismuthTellurite, 2)), 0);
    public static final DustMaterial YttriumOxide = new DustMaterial(906, "yttrium_oxide", 0xC6EBB3, MaterialIconSet.SAND, 2, of(new MaterialStack(Yttrium, 2), new MaterialStack(Oxygen, 3)), 0);
    public static final GemMaterial MagnetoResonatic = new GemMaterial(913, "magneto_resonatic", 0xFF97FF, MaterialIconSet.MAGNETIC, 2, of(new MaterialStack(Prasiolite, 3), new MaterialStack(BismuthTellurite, 6), new MaterialStack(CubicZirconia, 1), new MaterialStack(SteelMagnetic, 1)), NO_RECYCLING | DISABLE_DECOMPOSITION | FLAMMABLE | HIGH_SIFTER_OUTPUT | NO_SMELTING);
    public static final IngotMaterial ZirconiumCarbide = new IngotMaterial(905, "zirconium_carbide", 0xFFDACD, MaterialIconSet.SHINY, 2, of(new MaterialStack(Zirconium, 1), new MaterialStack(Carbon, 1)), EXT2_METAL | GENERATE_METAL_CASING, null, 0);
    public static final DustMaterial Zirkelite = new DustMaterial(904, "zirkelite", 0x6B5E6A, MaterialIconSet.DULL, 4, of(new MaterialStack(Calcium, 1), new MaterialStack(Thorium, 1), new MaterialStack(Cerium, 1), new MaterialStack(Zirconium, 1), new MaterialStack(Rutile, 2), new MaterialStack(Niobium, 2), new MaterialStack(Oxygen, 7)), GENERATE_ORE);
    public static final FluidMaterial PlatinumConcentrate = new FluidMaterial(903, "platinum_concentrate", Platinum.materialRGB, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial PlatinumSaltCrude = new DustMaterial(902, "platinum_salt", Platinum.materialRGB, MaterialIconSet.DULL, 2, of(), 0);
    public static final DustMaterial PlatinumSaltRefined = new DustMaterial(901, "refined_platinum_salt", Platinum.materialRGB, MaterialIconSet.METALLIC, 2, of(), 0);
    public static final DustMaterial PlatinumMetallicPowder = new DustMaterial(900, "platinum_metallic_powder", Platinum.materialRGB, MaterialIconSet.METALLIC, 2, of(), GENERATE_ORE);
    public static final FluidMaterial AquaRegia = new FluidMaterial(899, "aqua_regia", 0xFFB132, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial PlatinumResidue = new DustMaterial(898, "platinum_residue", 0x64632E, MaterialIconSet.ROUGH, 2, of(), 0);
    public static final FluidMaterial AmmoniumChloride = new FluidMaterial(897, "ammonium_chloride", 0xFFFFFF, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial PlatinumRawPowder = new DustMaterial(896, "reprecipitated_platinum", Platinum.materialRGB, MaterialIconSet.METALLIC, 2, of(), 0);
    public static final FluidMaterial PalladiumAmmonia = new FluidMaterial(895, "palladium_enriched_ammonia", Platinum.materialRGB, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial PalladiumMetallicPowder = new DustMaterial(894, "palladium_metallic_powder", Palladium.materialRGB, MaterialIconSet.METALLIC, 2, of(), GENERATE_ORE);
    public static final DustMaterial PalladiumRawPowder = new DustMaterial(893, "reprecipitated_palladium", Palladium.materialRGB, MaterialIconSet.METALLIC, 2, of(), 0);
    public static final DustMaterial PalladiumSalt = new DustMaterial(892, "palladium_salt", Palladium.materialRGB, MaterialIconSet.METALLIC, 2, of(), 0);
    public static final FluidMaterial Sodiumformate = new FluidMaterial(891, "sodium_formate", 0xFFAAAA, MaterialIconSet.FLUID, of(), 0);
    public static final FluidMaterial Sodiumsulfate = new FluidMaterial(890, "sodium_sulfate", 0xFFFFFF, MaterialIconSet.FLUID, of(), 0);
    public static final FluidMaterial FormicAcid = new FluidMaterial(889, "formic_acid", 0xFFAA77, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial PotassiumDisulfate = new DustMaterial(888, "potassium_disulfate", 0xFBBB66, MaterialIconSet.DULL, 2, of(new MaterialStack(Potassium, 2), new MaterialStack(Sulfur, 2), new MaterialStack(Oxygen, 7)), EXCLUDE_BLOCK_CRAFTING_RECIPES | SMELT_INTO_FLUID);
    public static final DustMaterial LeachResidue = new DustMaterial(887, "leach_residue", 0x644629, MaterialIconSet.ROUGH, 2, of(), 0);
    public static final FluidMaterial RhodiumSulfate = new FluidMaterial(886, "rhodium_sulfate", 0xEEAA55, MaterialIconSet.FLUID, of(), 0);
    public static final FluidMaterial RhodiumSulfateSolution = new FluidMaterial(885, "rhodium_sulfate_solution", 0xFFBB66, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial CalciumChloride = new DustMaterial(884, "calcium_chloride", 0xFFFFFF, MaterialIconSet.DULL, 2, of(new MaterialStack(Calcium, 1), new MaterialStack(Chlorine, 2)), 0);
    public static final IngotMaterial Ruthenium = new IngotMaterial(883, "ruthenium", 0x646464, MaterialIconSet.METALLIC, 2, of(), EXT2_METAL, null, 2607);
    public static final DustMaterial SodiumRuthenate = new DustMaterial(882, "sodium_ruthenate", 0x3A40CB, MaterialIconSet.SHINY, 2, of(), 0);
    public static final DustMaterial RutheniumTetroxide = new DustMaterial(881, "ruthenium_tetroxide", 0xC7C7C7, MaterialIconSet.DULL, 2, of(), SMELT_INTO_FLUID | GENERATE_FLUID_BLOCK | EXCLUDE_BLOCK_CRAFTING_RECIPES);
    public static final FluidMaterial HotRutheniumTetroxideSolution = new FluidMaterial(880, "hot_ruthenium_tetroxide_solution", 0xC7C7C7, MaterialIconSet.FLUID, of(), 0);
    public static final FluidMaterial RutheniumTetroxideSolution = new FluidMaterial(879, "ruthenium_tetroxide_solution", 0xC7C7C7, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial IrOsLeachResidue = new DustMaterial(878, "rarest_metal_residue", 0x644629, MaterialIconSet.ROUGH, 2, of(), GENERATE_ORE);
    public static final DustMaterial IrLeachResidue = new DustMaterial(877, "iridium_metal_residue", 0x846649, MaterialIconSet.ROUGH, 2, of(), GENERATE_ORE);
    public static final DustMaterial PGSDResidue = new DustMaterial(876, "sludge_dust_residue", 0x846649, MaterialIconSet.DULL, 2, of(), 0);
    public static final FluidMaterial AcidicOsmiumSolution = new FluidMaterial(875, "acidic_osmium_solution", 0x846649, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial IridiumDioxide = new DustMaterial(874, "iridium_dioxide", 0x846649, MaterialIconSet.DULL, 0, of(), EXCLUDE_BLOCK_CRAFTING_RECIPES | SMELT_INTO_FLUID);
    public static final FluidMaterial OsmiumSolution = new FluidMaterial(873, "osmium_solution", 0x846649, MaterialIconSet.FLUID, of(), 0);
    public static final FluidMaterial AcidicIridiumSolution = new FluidMaterial(872, "acidic_iridium_solution", 0x846649, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial IridiumChloride = new DustMaterial(871, "iridium_chloride", 0x846649, MaterialIconSet.LAPIS, 2, of(), 0);
    public static final DustMaterial PGSDResidue2 = new DustMaterial(870, "metallic_sludge_dust_residue", 0x846649, MaterialIconSet.DULL, 2, of(), 0);
    public static final IngotMaterial Rhodium = new IngotMaterial(869, "rhodium", 0xF4F4F4, MaterialIconSet.METALLIC, 2, of(), EXT2_METAL, null, 2237);
    public static final DustMaterial CrudeRhodiumMetall = new DustMaterial(868, "crude_rhodium_metal", 0x666666, MaterialIconSet.DULL, 2, of(), 0);
    public static final GemMaterial RhodiumSalt = new GemMaterial(867, "rhodium_salt", 0x848484, MaterialIconSet.GEM_VERTICAL, 2, of(), 0);
    public static final FluidMaterial RhodiumSaltSolution = new FluidMaterial(866, "rhodium_salt_solution", 0x667788, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial SodiumNitrate = new DustMaterial(865, "sodium_nitrate", 0x846684, MaterialIconSet.ROUGH, 2, of(), 0);
    public static final DustMaterial RhodiumNitrate = new DustMaterial(864, "rhodium_nitrate", 0x776649, MaterialIconSet.QUARTZ, 2, of(), 0);
    public static final DustMaterial ZincSulfate = new DustMaterial(863, "zinc_sulfate", 0x846649, MaterialIconSet.QUARTZ, 2, of(), 0);
    public static final DustMaterial RhodiumFilterCake = new DustMaterial(862, "rhodium_filter_cake", 0x776649, MaterialIconSet.QUARTZ, 2, of(), 0);
    public static final FluidMaterial RhodiumFilterCakeSolution = new FluidMaterial(861, "rhodium_filter_cake_solution", 0x667788, MaterialIconSet.FLUID, of(), 0);
    public static final DustMaterial ReRhodium = new DustMaterial(860, "reprecipitated_rhodium", 0x776649, MaterialIconSet.QUARTZ, 2, of(), 0);
    public static final IngotMaterial RhodiumPlatedPalladium = new IngotMaterial(859, "rhodium_plated_palladium", Palladium.materialRGB, MaterialIconSet.METALLIC, 2, of(), EXT2_METAL);
    public static final DustMaterial Tiberium = new DustMaterial(858, "tiberium", 0x22EE22, MaterialIconSet.DIAMOND, 2, of(), 0);
    public static final IngotMaterial Ruridit = new IngotMaterial(857, "ruridit", 0xA4A4A4, MaterialIconSet.METALLIC, 2, of(), 0);
    public static final GemMaterial Fluorspar = new GemMaterial(856, "fluorspar", 0xB945FB, MaterialIconSet.GEM_VERTICAL, 2, of(), 0);
    public static final DustMaterial HDCS = new DustMaterial(855, "high_durability_compound_steel", 0x334433, MaterialIconSet.SHINY, 2, of(), 0);
    public static final DustMaterial Atheneite = new DustMaterial(854, "atheneite", 0xAFAFAF, MaterialIconSet.SHINY, 2, of(), 0);
    public static final DustMaterial Temagamite = new DustMaterial(853, "temagamite", 0xF5F5F5, MaterialIconSet.ROUGH, 2, of(), 0);
    public static final GemMaterial Terlinguaite = new GemMaterial(852, "terlinguaite", 0xF5F5F5, MaterialIconSet.GEM_HORIZONTAL, 2, of(), 0);
    public static final DustMaterial AdemicSteel = new DustMaterial(851, "ademic_steel", 0xCCCCCC, MaterialIconSet.METALLIC, 2, of(), 0);
    public static final DustMaterial RawAdemicSteel = new DustMaterial(850, "raw_ademic_steel", 0xEDEDED, MaterialIconSet.ROUGH, 2, of(), 0);
    public static final DustMaterial PotassiumNitrade = new DustMaterial(849, "potassium_nitrade", 0x81228D, MaterialIconSet.DULL, 0, of(new MaterialStack(Potassium, 1), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 3)), 0);
    public static final DustMaterial ChromiumTrioxide = new DustMaterial(848, "chromium_trioxide", 0xFFE4E1, MaterialIconSet.DULL, 0, of(new MaterialStack(Chrome, 1), new MaterialStack(Oxygen, 3)), 0);
    public static final FluidMaterial Nitrochlorobenzene = new FluidMaterial(847, "nitrochlorobenzene", 0x8FB51A, MaterialIconSet.DULL, of(), 0);
    public static final FluidMaterial Dimethylbenzene = new FluidMaterial(846, "dimethylbenzene", 0x669C40, MaterialIconSet.DULL, of(), 0);
    public static final DustMaterial Potassiumdichromate = new DustMaterial(845, "potassiumdichromate", 0xFF087F, MaterialIconSet.DULL, 0, of(), 0);
    public static final FluidMaterial Dichlorobenzidine = new FluidMaterial(843, "dichlorobenzidine", 0xA1DEA6, MaterialIconSet.DULL, of(), 0);
    public static final FluidMaterial Diaminobenzidine = new FluidMaterial(842, "diaminobenzidine", 0x337D59, MaterialIconSet.DULL, of(), 0);
    public static final FluidMaterial Diphenylisophtalate = new FluidMaterial(841, "diphenylisophtalate", 0x246E57, MaterialIconSet.DULL, of(), 0);
    public static final IngotMaterial Polybenzimidazole = new IngotMaterial(840, "polybenzimidazole", 0x2D2D2D, MaterialIconSet.DULL, 0, of(), EXCLUDE_BLOCK_CRAFTING_RECIPES | SMELT_INTO_FLUID);
    public static final FluidMaterial Chlorobenzene = new FluidMaterial(839, "chlorobenzene", 0x326A3E, MaterialIconSet.DULL, of(), 0);
    public static final IngotMaterial Polonium = new IngotMaterial(838, "polonium", 0xC9D47E, MaterialIconSet.DULL, 4, of(), 0, Po);
    public static final IngotMaterial Copernicium = new IngotMaterial(837, "copernicium", 0xFFFEFF, MaterialIconSet.DULL, 4, of(), 0, Cn);
    public static final DustMaterial CopperLeach = new DustMaterial(836, "copper_leach", 0x765A30, MaterialIconSet.DULL, 2, of(new MaterialStack(Copper, 1), new MaterialStack(RareEarth, 1)), GENERATE_FLUID_BLOCK | DISABLE_DECOMPOSITION | SMELT_INTO_FLUID | NO_SMELTING);
    public static final DustMaterial SilverOxide = new DustMaterial(835, "silver_oxide", 0x4D4D4D, MaterialIconSet.DULL, 2, of(new MaterialStack(Silver, 2), new MaterialStack(Oxygen, 1)), 0);
    public static final DustMaterial SilverChloride = new DustMaterial(834, "silver_chloride", 0xFEFEFE, MaterialIconSet.DULL, 2, of(new MaterialStack(Silver, 1), new MaterialStack(Chlorine, 1)), DISABLE_DECOMPOSITION | GENERATE_FLUID_BLOCK);
    public static final FluidMaterial PreciousLeachNitrate = new FluidMaterial(833, "precious_leach_nitrate", 0x1D1F4D, MaterialIconSet.DULL, of(new MaterialStack(CopperLeach, 1), new MaterialStack(Silver, 1)), DISABLE_DECOMPOSITION);
    public static final DustMaterial PotassiumMetabisulfite = new DustMaterial(832, "potassium_metabisulfite", 0xFFFFFF, MaterialIconSet.DULL, 2, of(new MaterialStack(Potassium, 2), new MaterialStack(Sulfur, 2), new MaterialStack(Oxygen, 5)), 0);
    public static final FluidMaterial ChloroauricAcid = new FluidMaterial(831, "chloroauric_acid", 0xDFD11F, MaterialIconSet.SHINY, of(new MaterialStack(Hydrogen, 1), new MaterialStack(Gold, 1), new MaterialStack(Chlorine, 4)), DISABLE_DECOMPOSITION);
    public static final DustMaterial LeadNitrate = new DustMaterial(830, "lead_nitrate", 0xFEFEFE, MaterialIconSet.DULL, 2, of(new MaterialStack(Lead, 1), new MaterialStack(NitrogenTetroxide, 2)), 0);
    public static final DustMaterial GoldLeach = new DustMaterial(829, "gold_leach", 0xBBA52B, MaterialIconSet.DULL, 2, of(new MaterialStack(Gold, 1), new MaterialStack(RareEarth, 1)), DISABLE_DECOMPOSITION);
    public static final IngotMaterial GoldAlloy = new IngotMaterial(828, "gold_alloy", 0xBBA52B, MaterialIconSet.SHINY, 2, of(new MaterialStack(GoldLeach, 1), new MaterialStack(CopperLeach, 3)), DISABLE_DECOMPOSITION);
    public static final IngotMaterial PreciousMetal = new IngotMaterial(827, "precious_metal", 0xB99023, MaterialIconSet.SHINY, 2, of(new MaterialStack(GoldLeach, 1), new MaterialStack(RareEarth, 1)), DISABLE_DECOMPOSITION | GENERATE_ORE, null);
    public static final FluidMaterial HydrogenFluoride = new FluidMaterial(826, "hydrogen_fluoride", 0xFFFFFF, MaterialIconSet.FLUID, of(new MaterialStack(Hydrogen, 1), new MaterialStack(Chlorine, 1)), 0);

    //Thorium
    public static final RadioactiveMaterial ThoriumRadioactive = new RadioactiveMaterial(Thorium);
    public static final IsotopeMaterial Thorium232Isotope = new IsotopeMaterial(Thorium, RadioactiveMaterial.REGISTRY.get(Thorium), 232);
    public static final IsotopeMaterial Thorium233 = new IsotopeMaterial(825, RadioactiveMaterial.REGISTRY.get(Thorium), 233, 0);

    //Protactinium
    public static final RadioactiveMaterial Protactinium = new RadioactiveMaterial(824, "protactinium", 0xA78B6D, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Pa, 0, 0, 0, 0);
    public static final IsotopeMaterial Protactinium233 = new IsotopeMaterial(823, RadioactiveMaterial.REGISTRY.get(Protactinium.getMaterial()), 233, 0);

    //uranium
    public static final RadioactiveMaterial UraniumRadioactive = new RadioactiveMaterial(822, "uranium_radioactive", Uranium.materialRGB, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL | GENERATE_ORE, U, 0, 0, 0, 0);

    public static final IsotopeMaterial Uranium238Isotope = new IsotopeMaterial(Uranium, RadioactiveMaterial.REGISTRY.get(UraniumRadioactive.getMaterial()), 238);
    public static final IsotopeMaterial Uranium233 = new IsotopeMaterial(821, RadioactiveMaterial.REGISTRY.get(UraniumRadioactive.getMaterial()), 233, 0);
    public static final IsotopeMaterial Uranium234 = new IsotopeMaterial(820, RadioactiveMaterial.REGISTRY.get(UraniumRadioactive.getMaterial()), 234, 0);
    public static final IsotopeMaterial Uranium235Isotope = new IsotopeMaterial(Uranium235, RadioactiveMaterial.REGISTRY.get(UraniumRadioactive.getMaterial()), 235);
    public static final IsotopeMaterial Uranium239 = new IsotopeMaterial(819, RadioactiveMaterial.REGISTRY.get(UraniumRadioactive.getMaterial()), 239, 0);

    //Neptunium
    public static final RadioactiveMaterial Neptunium = new RadioactiveMaterial(818, "neptunium", 0x284D7B, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Np, 0, 0, 0, 0);
    public static final IsotopeMaterial Neptunium235 = new IsotopeMaterial(817, RadioactiveMaterial.REGISTRY.get(Neptunium.getMaterial()), 235, 0);
    public static final IsotopeMaterial Neptunium237 = new IsotopeMaterial(816, RadioactiveMaterial.REGISTRY.get(Neptunium.getMaterial()), 237, 0);
    public static final IsotopeMaterial Neptunium239 = new IsotopeMaterial(815, RadioactiveMaterial.REGISTRY.get(Neptunium.getMaterial()), 239, 0);

    //plutonium
    public static final RadioactiveMaterial PlutoniumRadioactive = new RadioactiveMaterial(814, "plutonium_radioactive", Plutonium.materialRGB, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Pu, 0, 0, 0, 0);
    public static final IsotopeMaterial Plutonium239 = new IsotopeMaterial(813, RadioactiveMaterial.REGISTRY.get(PlutoniumRadioactive.getMaterial()), 239, 0);
    public static final IsotopeMaterial Plutonium240 = new IsotopeMaterial(812, RadioactiveMaterial.REGISTRY.get(PlutoniumRadioactive.getMaterial()), 240, 0);
    public static final IsotopeMaterial Plutonium241Isotope = new IsotopeMaterial(Plutonium241, RadioactiveMaterial.REGISTRY.get(PlutoniumRadioactive.getMaterial()), 241);
    public static final IsotopeMaterial Plutonium244Isotope = new IsotopeMaterial(Plutonium, RadioactiveMaterial.REGISTRY.get(PlutoniumRadioactive.getMaterial()), 244);
    public static final IsotopeMaterial Plutonium245 = new IsotopeMaterial(811, RadioactiveMaterial.REGISTRY.get(PlutoniumRadioactive.getMaterial()), 245, 0);

    //americium
    public static final RadioactiveMaterial AmericiumRadioactive = new RadioactiveMaterial(Americium);
    public static final IsotopeMaterial Americium241 = new IsotopeMaterial(810, RadioactiveMaterial.REGISTRY.get(Americium), 241, 0);
    public static final IsotopeMaterial Americium243 = new IsotopeMaterial(809, RadioactiveMaterial.REGISTRY.get(Americium), 243, 0);
    public static final IsotopeMaterial Americium245 = new IsotopeMaterial(808, RadioactiveMaterial.REGISTRY.get(Americium), 245, 0);

    //curium
    public static final RadioactiveMaterial Curium = new RadioactiveMaterial(807, "curium", 0x7B544E, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Cm, 0, 0, 0, 0);
    public static final IsotopeMaterial Curium245 = new IsotopeMaterial(806, RadioactiveMaterial.REGISTRY.get(Curium.getMaterial()), 245, 0);
    public static final IsotopeMaterial Curium246 = new IsotopeMaterial(805, RadioactiveMaterial.REGISTRY.get(Curium.getMaterial()), 246, 0);
    public static final IsotopeMaterial Curium247 = new IsotopeMaterial(804, RadioactiveMaterial.REGISTRY.get(Curium.getMaterial()), 247, 0);
    public static final IsotopeMaterial Curium250 = new IsotopeMaterial(803, RadioactiveMaterial.REGISTRY.get(Curium.getMaterial()), 250, 0);
    public static final IsotopeMaterial Curium251 = new IsotopeMaterial(802, RadioactiveMaterial.REGISTRY.get(Curium.getMaterial()), 251, 0);

    //Berkelium
    public static final RadioactiveMaterial Berkelium = new RadioactiveMaterial(801, "berkelium", 0x645A88, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Bk, 0, 0, 0, 0);
    public static final IsotopeMaterial Berkelium247 = new IsotopeMaterial(800, RadioactiveMaterial.REGISTRY.get(Berkelium.getMaterial()), 247, 0);
    public static final IsotopeMaterial Berkelium249 = new IsotopeMaterial(799, RadioactiveMaterial.REGISTRY.get(Berkelium.getMaterial()), 249, 0);
    public static final IsotopeMaterial Berkelium251 = new IsotopeMaterial(798, RadioactiveMaterial.REGISTRY.get(Berkelium.getMaterial()), 251, 0);

    //Californium
    public static final RadioactiveMaterial Californium = new RadioactiveMaterial(797, "californium", 0xA85A12, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Cf, 0, 0, 0, 0);
    public static final IsotopeMaterial Californium251 = new IsotopeMaterial(796, RadioactiveMaterial.REGISTRY.get(Californium.getMaterial()), 251, 0);
    public static final IsotopeMaterial Californium252 = new IsotopeMaterial(795, RadioactiveMaterial.REGISTRY.get(Californium.getMaterial()), 252, 0);
    public static final IsotopeMaterial Californium253 = new IsotopeMaterial(794, RadioactiveMaterial.REGISTRY.get(Californium.getMaterial()), 253, 0);
    public static final IsotopeMaterial Californium256 = new IsotopeMaterial(793, RadioactiveMaterial.REGISTRY.get(Californium.getMaterial()), 256, 0);
    public static final IsotopeMaterial Californium257 = new IsotopeMaterial(792, RadioactiveMaterial.REGISTRY.get(Californium.getMaterial()), 257, 0);

    //Einsteinium
    public static final RadioactiveMaterial Einsteinium = new RadioactiveMaterial(791, "einsteinium", 0xCE9F00, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Es, 0, 0, 0, 0);
    public static final IsotopeMaterial Einsteinium253 = new IsotopeMaterial(790, RadioactiveMaterial.REGISTRY.get(Einsteinium.getMaterial()), 253, 0);
    public static final IsotopeMaterial Einsteinium255 = new IsotopeMaterial(789, RadioactiveMaterial.REGISTRY.get(Einsteinium.getMaterial()), 255, 0);
    public static final IsotopeMaterial Einsteinium257 = new IsotopeMaterial(787, RadioactiveMaterial.REGISTRY.get(Einsteinium.getMaterial()), 257, 0);

    //Fermium
    public static final RadioactiveMaterial Fermium = new RadioactiveMaterial(786, "fermium", 0x984ACF, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Fm, 0, 0, 0, 0);
    public static final IsotopeMaterial Fermium257 = new IsotopeMaterial(785, RadioactiveMaterial.REGISTRY.get(Fermium.getMaterial()), 257, 0);
    public static final IsotopeMaterial Fermium258 = new IsotopeMaterial(784, RadioactiveMaterial.REGISTRY.get(Fermium.getMaterial()), 258, 0);
    public static final IsotopeMaterial Fermium259 = new IsotopeMaterial(783, RadioactiveMaterial.REGISTRY.get(Fermium.getMaterial()), 259, 0);
    public static final IsotopeMaterial Fermium262 = new IsotopeMaterial(782, RadioactiveMaterial.REGISTRY.get(Fermium.getMaterial()), 262, 0);
    public static final IsotopeMaterial Fermium263 = new IsotopeMaterial(781, RadioactiveMaterial.REGISTRY.get(Fermium.getMaterial()), 263, 0);

    //Mendelevium
    public static final RadioactiveMaterial Mendelevium = new RadioactiveMaterial(780, "mendelevium", 0x1D4ACF, MaterialIconSet.METALLIC, 3, of(), EXT2_METAL, Md, 0, 0, 0, 0);
    public static final IsotopeMaterial Mendelevium259 = new IsotopeMaterial(779, RadioactiveMaterial.REGISTRY.get(Mendelevium.getMaterial()), 259, 0);
    public static final IsotopeMaterial Mendelevium261 = new IsotopeMaterial(778, RadioactiveMaterial.REGISTRY.get(Mendelevium.getMaterial()), 261, 0);
    public static final IsotopeMaterial Mendelevium263 = new IsotopeMaterial(777, RadioactiveMaterial.REGISTRY.get(Mendelevium.getMaterial()), 263, 0);

    public static final DustMaterial SodiumPotassiumAlloy = new DustMaterial(776, "sodium_potassium_alloy", 0x252525, MaterialIconSet.SHINY, 2, of(new MaterialStack(Sodium, 7), new MaterialStack(Potassium, 3)), SMELT_INTO_FLUID);
    public static final DustMaterial LithiumHydroxide = new DustMaterial(775, "lithium_hydroxide", 0xFDFDFD, MaterialIconSet.DULL, 2, of(new MaterialStack(Lithium, 1), new MaterialStack(Oxygen, 1), new MaterialStack(Hydrogen, 1)), 0); // Lithium + water = LithiumHydroxide
    public static final IngotMaterial LithiumFluoride = new IngotMaterial(774, "lithium_fluoride", 0x757575, MaterialIconSet.SHINY, 2, of(new MaterialStack(Lithium, 1), new MaterialStack(Fluorine, 1)), 0); //LithiumHydroxide + Hydrogen = LithiumFluoride
    public static final DustMaterial SodiumFluoride = new DustMaterial(773, "sodium_fluoride", 0xFDFDFD, MaterialIconSet.DULL, 2, of(new MaterialStack(Sodium, 1), new MaterialStack(Fluorine, 1)), 0);
    public static final DustMaterial PotassiumFluoride = new DustMaterial(772, "potassium_fluoride", 0xFDFDFD, MaterialIconSet.DULL, 2, of(new MaterialStack(Potassium, 1), new MaterialStack(Fluorine, 1)), 0);
    public static final DustMaterial FLiNaK = new DustMaterial(771, "flinak", 0x252525, MaterialIconSet.DULL, 2, of(new MaterialStack(LithiumFluoride, 1), new MaterialStack(SodiumFluoride, 1), new MaterialStack(PotassiumFluoride, 1)), SMELT_INTO_FLUID);
    public static final IngotMaterial BerylliumFluoride = new IngotMaterial(770, "beryllium_fluoride", 0x757575, MaterialIconSet.SHINY, 2, of(new MaterialStack(Beryllium, 1), new MaterialStack(Fluorine, 2)), 0);
    public static final DustMaterial FLiBe = new DustMaterial(769, "flibe", 0x252525, MaterialIconSet.DULL, 2, of(new MaterialStack(LithiumFluoride, 1), new MaterialStack(BerylliumFluoride, 1)), SMELT_INTO_FLUID);
    public static final DustMaterial LeadBismuthEutectic = new IngotMaterial(768, "lead_bismuth_eutatic", 0x757575, MaterialIconSet.SHINY, 2, of(new MaterialStack(Lead, 3), new MaterialStack(Bismuth, 7)), SMELT_INTO_FLUID);
    public static final IngotMaterial Francium = new IngotMaterial(767, "francium", 0xAAAAAA, MaterialIconSet.SHINY, 2, of(), 0, Fr);
    public static final IngotMaterial Radium = new IngotMaterial(766, "radium", 0xFFC840, MaterialIconSet.SHINY, 2, of(), 0, Ra);
    public static final IngotMaterial Actinium = new IngotMaterial(765, "actinium", 0xC3D1FF, MaterialIconSet.SHINY, 2, of(), 0, Ac);
    public static final IngotMaterial Hafnium = new IngotMaterial(764, "hafnium", 0xB6BAB4, MaterialIconSet.SHINY, 2, of(), 0, Hf);
    public static final IngotMaterial Rhenium = new IngotMaterial(763, "rhenium", 0xB6BAB4, MaterialIconSet.SHINY, 2, of(), 0, Re);
    public static final IngotMaterial Technetium = new IngotMaterial(762, "technetium", 0xB6BAB4, MaterialIconSet.SHINY, 2, of(), 0, Tc);
    public static final IngotMaterial Thallium = new IngotMaterial(761, "thalium", 0xB6BAB4, MaterialIconSet.SHINY, 2, of(), 0, Tl);
    public static final IngotMaterial Germanium = new IngotMaterial(760, "germanium", 0xB6BAB4, MaterialIconSet.SHINY, 2, of(), 0, Ge);
    public static final DustMaterial Selenium = new IngotMaterial(759, "selenium", 0xB6BA6B, MaterialIconSet.SHINY, 2, of(), 0, Se);
    public static final FluidMaterial Bromine = new FluidMaterial(758, "bromine", 0xB64D6B, MaterialIconSet.SHINY, of(), 0, Br);
    public static final DustMaterial Iodine = new DustMaterial(757, "iodine", 0x2C344F, MaterialIconSet.SHINY, 2, of(), 0, I);
    public static final IngotMaterial Astatine = new IngotMaterial(756, "astatine", 0xB6BAB4, MaterialIconSet.SHINY, 2, of(), 0, At);
    public static final IngotMaterial AbyssalAlloy = new IngotMaterial(755, "abyssal_alloy", 0x9E706A, MaterialIconSet.METALLIC, 6, of(new MaterialStack(StainlessSteel, 5), new MaterialStack(TungstenCarbide, 5), new MaterialStack(Nichrome, 5), new MaterialStack(Bronze, 5), new MaterialStack(IncoloyMA956, 5), new MaterialStack(Iodine, 1), new MaterialStack(Germanium, 1), new MaterialStack(Radon, 1)), EXT2_METAL | DISABLE_DECOMPOSITION, null, 9625);
    public static final DustMaterial OrganicFertilizer = new DustMaterial(754, "organic_fertilizer", 0xDDDDDD, MaterialIconSet.SHINY, 2, of(new MaterialStack(Calcium, 5), new MaterialStack(Phosphate, 3), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 1)), 0);

    @Override
    public void onMaterialsInit() {
        initNuclearMaterial();
        platinumProcess();
        goldProcess();

        Enderium.setFluidPipeProperties(650, 1500, true);
        Neutronium.setFluidPipeProperties(2800, 1000000, true);
        Naquadah.setFluidPipeProperties(1000, 19000, true);
        NiobiumTitanium.setFluidPipeProperties(450, 2900, true);

        MVSuperconductorBase.setCableProperties(128, 1, 2);
        HVSuperconductorBase.setCableProperties(512, 1, 2);
        EVSuperconductorBase.setCableProperties(2048, 2, 2);
        IVSuperconductorBase.setCableProperties(8192, 2, 2);
        LuVSuperconductorBase.setCableProperties(32768, 4, 2);
        ZPMSuperconductorBase.setCableProperties(131072, 4, 2);

        MVSuperconductor.setCableProperties(128, 2, 0);
        ignoreCable(MVSuperconductor);
        HVSuperconductor.setCableProperties(512, 2, 0);
        ignoreCable(HVSuperconductor);
        EVSuperconductor.setCableProperties(2048, 4, 0);
        ignoreCable(EVSuperconductor);
        IVSuperconductor.setCableProperties(8192, 4, 0);
        ignoreCable(IVSuperconductor);
        LuVSuperconductor.setCableProperties(32768, 8, 0);
        ignoreCable(LuVSuperconductor);
        ZPMSuperconductor.setCableProperties(131072, 8, 0);
        ignoreCable(ZPMSuperconductor);


        Radon.addFlag(GENERATE_PLASMA);
        Potassium.addFlag(GENERATE_PLASMA);
        Helium.addFlag(GENERATE_PLASMA);
        Oxygen.addFlag(GENERATE_PLASMA);
        Iron.addFlag(GENERATE_PLASMA);
        Nickel.addFlag(GENERATE_PLASMA);

        Tellurium.addFlag(GENERATE_ORE);
        Diatomite.addFlag(GENERATE_ORE);
        GarnetSand.addFlag(GENERATE_ORE);
        Mica.addFlag(GENERATE_ORE);
        Asbestos.addFlag(GENERATE_ORE);
        Kyanite.addFlag(GENERATE_ORE);
        Pollucite.addFlag(GENERATE_ORE);
        BasalticMineralSand.addFlag(GENERATE_ORE);
        GraniticMineralSand.addFlag(GENERATE_ORE);
        FullersEarth.addFlag(GENERATE_ORE);
        Gypsum.addFlag(GENERATE_ORE);
        Zeolite.addFlag(GENERATE_ORE);
        Kaolinite.addFlag(GENERATE_ORE);
        Dolomite.addFlag(GENERATE_ORE);
        Wollastonite.addFlag(GENERATE_ORE);
        Trona.addFlag(GENERATE_ORE);
        Andradite.addFlag(GENERATE_ORE);
        Vermiculite.addFlag(GENERATE_ORE);
        Alunite.addFlag(GENERATE_ORE);
        GlauconiteSand.addFlag(GENERATE_ORE);
        Niter.addFlag(GENERATE_ORE);


        YttriumBariumCuprate.addFlag(GENERATE_FINE_WIRE);
        Manganese.addFlag(GENERATE_FOIL);
        Naquadah.addFlag(GENERATE_FOIL);
        NaquadahEnriched.addFlag(GENERATE_FOIL);
        Duranium.addFlag(GENERATE_FOIL);
        Graphene.addFlag(GENERATE_FOIL);
        Polytetrafluoroethylene.addFlag(GENERATE_FOIL);
        Rubber.addFlag(GENERATE_FOIL);
        Polybenzimidazole.addFlag(GENERATE_FOIL);
        Polycaprolactam.addFlag(GENERATE_FOIL);
        Polystyrene.addFlag(GENERATE_FOIL);
        Plastic.addFlag(GENERATE_FOIL);
        ReinforcedEpoxyResin.addFlag(GENERATE_FINE_WIRE);
        Plutonium.addFlag(GENERATE_FINE_WIRE);
        Europium.addFlag(GENERATE_FINE_WIRE | GENERATE_LONG_ROD);
        Cerium.addFlag(GENERATE_FINE_WIRE);
        Arsenic.addFlag(SMELT_INTO_FLUID);
        Polonium.addFlag(SMELT_INTO_FLUID);
        Copernicium.addFlag(GENERATE_FLUID_BLOCK);

        //turbine component
        Cobalt.addFlag(GENERATE_BOLT_SCREW);
        Manganese.addFlag(GENERATE_BOLT_SCREW);
        Manganese.addFlag(GENERATE_DENSE);
        Molybdenum.addFlag(GENERATE_BOLT_SCREW);
        Neodymium.addFlag(GENERATE_BOLT_SCREW);


        GreenSapphire.addFlag(GENERATE_PLATE);
        GreenSapphire.addFlag(GENERATE_LENSE);
        Iron.addFlag(GENERATE_METAL_CASING);
        Tritanium.addFlag(GENERATE_FRAME);
        RedSteel.addFlag(GENERATE_GEAR);
        RedSteel.addFlag(GENERATE_METAL_CASING);
        Titanium.addFlag(GENERATE_METAL_CASING);
        StainlessSteel.addFlag(GENERATE_METAL_CASING);
        Steel.addFlag(GENERATE_METAL_CASING);
        TungstenSteel.addFlag(GENERATE_METAL_CASING);
        Aluminium.addFlag(GENERATE_METAL_CASING);
        Invar.addFlag(GENERATE_METAL_CASING);
        Lead.addFlag(GENERATE_METAL_CASING);
        BlackSteel.addFlag(GENERATE_METAL_CASING | GENERATE_GEAR);
        HSSG.addFlag(GENERATE_METAL_CASING);
        HSSS.addFlag(GENERATE_METAL_CASING);
        Naquadria.addFlag(GENERATE_METAL_CASING | GENERATE_DENSE | GENERATE_GEAR);

        Apatite.addFlag(GENERATE_ROD);
        Iron.addFlag(GENERATE_LONG_ROD);
        Bronze.addFlag(GENERATE_LONG_ROD);
        Steel.addFlag(GENERATE_LONG_ROD);
        StainlessSteel.addFlag(GENERATE_LONG_ROD);

        Steel.addFlag(DISABLE_DECOMPOSITION);

        Rubber.addFlag(GENERATE_BOLT_SCREW);

        Plastic.addFlag(GENERATE_ROTOR);

        Salt.addOreByProducts(Borax);
        RockSalt.addOreByProducts(Borax);
        Lepidolite.addOreByProducts(Boron);
        Zirkelite.addOreByProducts(Thorium, Zirconium, Cerium);

        OrePrefix.block.setIgnored(Pyrotheum);
        OrePrefix.block.setIgnored(Cryotheum);
        OrePrefix.block.setIgnored(Snow);
        OrePrefix.block.setIgnored(MagnetoResonatic);
        OrePrefix.block.setIgnored(PotassiumDisulfate);
        OrePrefix.dust.setIgnored(Snow);
        OrePrefix.dustSmall.setIgnored(Snow);
        OrePrefix.dustTiny.setIgnored(Snow);

        Magnetite.setDirectSmelting(Iron);

        Duranium.addFlag(GENERATE_FOIL);
        Graphene.addFlag(GENERATE_FOIL);

        Thorium.addFlag(GENERATE_ROD);

        for (Material material : Material.MATERIAL_REGISTRY) {
            if (material instanceof IngotMaterial && material.hasFlag(GENERATE_METAL_CASING)) {
                material.addFlag(GENERATE_FRAME);
                material.addFlag(GENERATE_PLATE);
            }
            if (material instanceof IngotMaterial && ((IngotMaterial) material).toolSpeed > 0) {
                material.addFlag(GENERATE_DENSE);
            }
        }
    }

    public static void goldProcess() {
        PreciousMetal.setOreMultiplier(3);

        Bornite.oreByProducts.clear();
        Bornite.addOreByProducts(Pyrite, Cobalt, Cadmium, PreciousMetal);

        Chalcopyrite.oreByProducts.clear();
        Chalcopyrite.addOreByProducts(Pyrite, Cobalt, Cadmium, PreciousMetal);

        Copper.oreByProducts.clear();
        Copper.addOreByProducts(Cobalt, PreciousMetal, Nickel);

        Glowstone.oreByProducts.clear();
        Glowstone.addOreByProducts(Redstone, PreciousMetal);

        Magnetite.oreByProducts.clear();
        Magnetite.addOreByProducts(Iron, PreciousMetal);
    }

    public static void platinumProcess() {
        OrePrefix.block.setIgnored(RutheniumTetroxide);
        PlatinumMetallicPowder.setOreMultiplier(2);
        PlatinumMetallicPowder.washedIn = SodiumPersulfate;
        PlatinumMetallicPowder.addOreByProducts(Nickel, IrLeachResidue, IrOsLeachResidue, PlatinumMetallicPowder);
        PalladiumMetallicPowder.setOreMultiplier(2);
        Nickel.oreByProducts.clear();
        Nickel.addOreByProducts(Cobalt, PlatinumMetallicPowder, Iron);
        Iridium.oreByProducts.clear();
        Iridium.addOreByProducts(PlatinumMetallicPowder, IrOsLeachResidue);
        Platinum.oreByProducts.clear();
        Platinum.addOreByProducts(Nickel, IrLeachResidue);
        Osmium.oreByProducts.clear();
        Osmium.addOreByProducts(IrLeachResidue);
        IrOsLeachResidue.addOreByProducts(IrLeachResidue, IrLeachResidue, IrLeachResidue, IrOsLeachResidue);
        IrOsLeachResidue.washedIn = SodiumPersulfate;
        IrLeachResidue.addOreByProducts(PlatinumMetallicPowder, IrOsLeachResidue);
        IrLeachResidue.washedIn = SodiumPersulfate;
    }


    public static void initNuclearMaterial() {
        OrePrefix.block.setIgnored(SodiumPotassiumAlloy);
        OrePrefix.block.setIgnored(FLiNaK);
        OrePrefix.block.setIgnored(FLiBe);
        OrePrefix.block.setIgnored(LeadBismuthEutectic);

        Uranium.addFlag(GENERATE_LONG_ROD);
        Plutonium.addFlag(GENERATE_LONG_ROD);

        ThoriumRadioactive.complexity = 100;
        Protactinium.complexity = 100;
        UraniumRadioactive.complexity = 100;
        Neptunium.complexity = 115;
        PlutoniumRadioactive.complexity = 120;
        AmericiumRadioactive.complexity = 135;
        Curium.complexity = 145;
        Berkelium.complexity = 150;
        Californium.complexity = 160;
        Einsteinium.complexity = 170;
        Fermium.complexity = 185;
        Mendelevium.complexity = 200;

        Thorium.addFlag(GENERATE_LONG_ROD);
        Uranium235.addFlag(GENERATE_LONG_ROD);

        Thorium232Isotope.fertile = true;
        Thorium232Isotope.isotopeDecay.put(Thorium233, 100);
        Thorium232Isotope.isotopeDecay.put(Protactinium233, 1000);
        Thorium232Isotope.isotopeDecay.put(Uranium233, 8900);

        Thorium233.isotopeDecay.put(Protactinium233, 9000);

        Protactinium233.isotopeDecay.put(Uranium233, 9000);

        //Uranium
        UraniumRadioactive.composition.put(Uranium238Isotope, 9890);
        UraniumRadioactive.composition.put(Uranium235Isotope, 100);
        UraniumRadioactive.composition.put(Uranium234, 10);

        Uranium233.fissile = true;
        Uranium235Isotope.fissile = true;
        Uranium234.fertile = true;
        Uranium238Isotope.fertile = true;

        Uranium235Isotope.baseHeat = 10;
        Uranium233.baseHeat = 7;

        Uranium234.isotopeDecay.put(Uranium235Isotope, 9000);
        Uranium238Isotope.isotopeDecay.put(Uranium239, 100);
        Uranium238Isotope.isotopeDecay.put(Neptunium239, 1000);
        Uranium238Isotope.isotopeDecay.put(Plutonium239, 8900);
        Uranium239.isotopeDecay.put(Neptunium239, 9000);


        //neptunium
        Neptunium.composition.put(Neptunium235, 2000);
        Neptunium.composition.put(Neptunium237, 5000);
        Neptunium.composition.put(Neptunium239, 3000);

        Neptunium237.fissile = true;
        Neptunium237.baseHeat = 11;

        Neptunium237.isotopeDecay.put(Protactinium233, 9000);
        Neptunium239.isotopeDecay.put(Plutonium239, 9000);
        Neptunium235.isotopeDecay.put(Uranium235Isotope, 9000);

        //plutonium
        PlutoniumRadioactive.composition.put(Plutonium244Isotope, 9890);
        PlutoniumRadioactive.composition.put(Plutonium241Isotope, 100);
        PlutoniumRadioactive.composition.put(Plutonium240, 10);

        Plutonium241Isotope.fissile = true;
        Plutonium239.fissile = true;
        Plutonium240.fertile = true;
        Plutonium244Isotope.fertile = true;

        Plutonium241Isotope.baseHeat = 13;
        Plutonium239.baseHeat = 10;

        Plutonium240.isotopeDecay.put(Plutonium241Isotope, 9000);
        Plutonium244Isotope.isotopeDecay.put(Plutonium245, 100);
        Plutonium244Isotope.isotopeDecay.put(Americium245, 1000);
        Plutonium244Isotope.isotopeDecay.put(Curium245, 8900);
        Plutonium245.isotopeDecay.put(Americium245, 9000);

        //Americium
        AmericiumRadioactive.composition.put(Americium241, 2000);
        AmericiumRadioactive.composition.put(Americium243, 5000);
        AmericiumRadioactive.composition.put(Americium245, 3000);

        Americium243.fissile = true;
        Americium243.baseHeat = 14;

        Americium243.isotopeDecay.put(Neptunium239, 9000);
        Americium245.isotopeDecay.put(Curium245, 9000);
        Americium241.isotopeDecay.put(Plutonium241Isotope, 9000);

        //Curium
        Curium.composition.put(Curium250, 9890);
        Curium.composition.put(Curium247, 100);
        Curium.composition.put(Curium246, 10);

        Curium245.fissile = true;
        Curium247.fissile = true;
        Curium246.fertile = true;
        Curium250.fertile = true;

        Curium245.baseHeat = 13;
        Curium247.baseHeat = 16;

        Curium246.isotopeDecay.put(Curium247, 9000);
        Curium250.isotopeDecay.put(Curium251, 100);
        Curium250.isotopeDecay.put(Berkelium251, 1000);
        Curium250.isotopeDecay.put(Californium251, 8900);
        Curium251.isotopeDecay.put(Americium245, 9000);

        //Berkelium
        Berkelium.composition.put(Berkelium247, 2000);
        Berkelium.composition.put(Berkelium249, 5000);
        Berkelium.composition.put(Berkelium251, 3000);

        Berkelium249.fissile = true;
        Berkelium249.baseHeat = 17;

        Berkelium249.isotopeDecay.put(Americium245, 9000);
        Berkelium251.isotopeDecay.put(Californium251, 9000);
        Berkelium247.isotopeDecay.put(Curium247, 9000);

        //Californium
        Californium.composition.put(Californium252, 9890);
        Californium.composition.put(Californium253, 100);
        Californium.composition.put(Californium256, 10);

        Californium251.fissile = true;
        Californium253.fissile = true;
        Californium252.fertile = true;
        Californium256.fertile = true;

        Californium251.baseHeat = 16;
        Californium253.baseHeat = 19;

        Californium252.isotopeDecay.put(Californium253, 9000);
        Californium256.isotopeDecay.put(Californium257, 100);
        Californium256.isotopeDecay.put(Einsteinium257, 1000);
        Californium256.isotopeDecay.put(Fermium257, 8900);
        Californium257.isotopeDecay.put(Einsteinium257, 9000);

        //Einsteinium
        Einsteinium.composition.put(Einsteinium253, 2000);
        Einsteinium.composition.put(Einsteinium255, 5000);
        Einsteinium.composition.put(Einsteinium257, 3000);

        Einsteinium255.fissile = true;
        Einsteinium255.baseHeat = 20;

        Einsteinium255.isotopeDecay.put(Berkelium251, 9000);
        Einsteinium257.isotopeDecay.put(Fermium257, 9000);
        Einsteinium253.isotopeDecay.put(Californium253, 9000);


        //Fermium
        Fermium.composition.put(Fermium258, 9890);
        Fermium.composition.put(Fermium259, 100);
        Fermium.composition.put(Fermium262, 10);

        Fermium257.fissile = true;
        Fermium259.fissile = true;
        Fermium258.fertile = true;
        Fermium262.fertile = true;

        Fermium257.baseHeat = 19;
        Fermium259.baseHeat = 22;

        Fermium258.isotopeDecay.put(Fermium259, 9000);
        Fermium262.isotopeDecay.put(Fermium263, 1000);
        Fermium262.isotopeDecay.put(Mendelevium263, 9000);
        Fermium263.isotopeDecay.put(Mendelevium263, 9000);

        //Mendelevium
        Mendelevium.composition.put(Mendelevium259, 2000);
        Mendelevium.composition.put(Mendelevium261, 5000);
        Mendelevium.composition.put(Mendelevium263, 3000);

        Mendelevium261.fissile = true;
        Mendelevium261.baseHeat = 23;
        Mendelevium261.isotopeDecay.put(Einsteinium257, 9000);
        Mendelevium259.isotopeDecay.put(Fermium259, 9000);

    }

    public static void ignoreCable(Material m) {
        if (m instanceof IngotMaterial && ((IngotMaterial) m).cableProperties != null) {
            OrePrefix.cableGtSingle.setIgnored(m);
            OrePrefix.cableGtDouble.setIgnored(m);
            OrePrefix.cableGtQuadruple.setIgnored(m);
            OrePrefix.cableGtOctal.setIgnored(m);
            OrePrefix.cableGtHex.setIgnored(m);
        }
    }

    public static void setBlastFurnaceTemperature(IngotMaterial material, int temperature) {
        try {
            Field blastFurnaceTemperature = IngotMaterial.class.getField("blastFurnaceTemperature");
            blastFurnaceTemperature.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(blastFurnaceTemperature, blastFurnaceTemperature.getModifiers() & ~Modifier.FINAL);

            blastFurnaceTemperature.setInt(material, temperature);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            GTLog.logger.error("setBlastFurnaceTemperature doesnt seems to works", e);
        }
    }

    public static void removeFlags(Material material, long flags) {
        if (!material.hasFlag(flags)) {
            return;
        }
        try {
            Field materialGenerationFlags = ObfuscationReflectionHelper.findField(Material.class, "materialGenerationFlags");
            materialGenerationFlags.setLong(material, materialGenerationFlags.getLong(material) ^ flags);
        } catch (IllegalAccessException e) {
            GTLog.logger.error("Remove flags doesnt seems to works", e);
        }
    }

}