package flavor_type

class ProductionFlavorType(
    override val flavorName: String = BuildConfig.Flavor.FlavorTypes.PRODUCTION,
    override val dimension: String = BuildConfig.Flavor.FlavorDimensions.ENVIRONMENT,
    override val applicationIdSuffix: String = "",
    override val versionNameSuffix: String = ""
) : FlavorType