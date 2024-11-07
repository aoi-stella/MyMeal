package flavor_type

import BuildConfig

class StagingFlavorType(
    override val flavorName: String = BuildConfig.Flavor.FlavorTypes.STAGING,
    override val dimension: String = BuildConfig.Flavor.FlavorDimensions.ENVIRONMENT,
    override val applicationIdSuffix: String = BuildConfig.ApplicationIdSuffix.STAGING,
    override val versionNameSuffix: String = BuildConfig.VersionNameSuffix.STAGING
) : FlavorType