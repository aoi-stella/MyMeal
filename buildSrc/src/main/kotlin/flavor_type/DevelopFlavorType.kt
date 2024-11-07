package flavor_type

import BuildConfig

class DevelopFlavorType(
    override val flavorName: String = BuildConfig.Flavor.FlavorTypes.DEVELOP,
    override val dimension: String = BuildConfig.Flavor.FlavorDimensions.ENVIRONMENT,
    override val applicationIdSuffix: String = BuildConfig.ApplicationIdSuffix.DEVELOP,
    override val versionNameSuffix: String = BuildConfig.VersionNameSuffix.DEVELOP
) : FlavorType