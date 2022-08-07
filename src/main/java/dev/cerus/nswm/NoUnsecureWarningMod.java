package dev.cerus.nswm;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoUnsecureWarningMod implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("nswm");

    @Override
    public void onInitialize() {
        LOGGER.info("Initialized!");
    }

}
